import { APIRequestParam, APIRequestParamWithMethod, DEFAULT_TIMEOUT } from 'api/api.types'
import { ObjectUtils } from 'utils/objectUtils'
import { QueryUtils } from 'utils/queryUtils'

class ServerAPIClass {
  get<T>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<T | undefined> {
    const queryUrl = ObjectUtils.isNotEmpty(params) ? `${url}?${QueryUtils.stringify(params)}` : url
    return this.fetch<T>(queryUrl, { config: { ...config, method: 'GET' } })
  }

  post<T>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<T | undefined> {
    return this.fetch<T>(url, { params, config: { ...config, method: 'POST' } })
  }

  put<T>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<T | undefined> {
    return this.fetch<T>(url, { params, config: { ...config, method: 'PUT' } })
  }

  delete<T>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<T | undefined> {
    return this.fetch<T>(url, { params, config: { ...config, method: 'DELETE' } })
  }

  private async fetch<T>(url: string, param: APIRequestParamWithMethod): Promise<T | undefined> {
    const { params, config } = param
    const { baseUrl, timeout = DEFAULT_TIMEOUT, headers } = config
    const fetchUrl = baseUrl ? `${baseUrl}${url}` : url

    try {
      const init: RequestInit = {
        headers: {
          'Content-Type': 'application/json',
          ...headers,
        },
        method: config.method,
        ...(ObjectUtils.isNotEmpty(params) ? { body: JSON.stringify(params) } : {}),
      }

      const response = await fetchWithTimeout(fetchUrl, init, timeout)
      if (!response) {
        // todo - logger setting
        return
      }
      return response.json()
    } catch (error) {
      // todo - logger setting
      console.log('error: ', error.message)
      throw error
    }
  }
}

export const ServerAPI = new ServerAPIClass()

const fetchWithTimeout = (url: string, options: RequestInit, timeout: number): Promise<Response | undefined> => {
  return Promise.race([
    fetch(url, options),
    // eslint-disable-next-line no-promise-executor-return
    new Promise<undefined>(resolve => setTimeout(() => resolve(undefined), timeout)),
  ])
}
