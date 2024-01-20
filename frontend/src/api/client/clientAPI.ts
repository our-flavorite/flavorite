import {
  APIRequestParam,
  APIRequestParamWithMethod,
  DEFAULT_TIMEOUT,
  MutationResponse,
  QueryResponse,
  API_BASE_PATH,
} from 'api/api.types'
import { ObjectUtils } from 'utils/objectUtils'
import { QueryUtils } from 'utils/queryUtils'

class ClientAPIClass {
  private controller: AbortController

  constructor() {
    this.controller = new AbortController()
  }

  get<T, R = QueryResponse<T>>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<R | undefined> {
    const queryUrl = ObjectUtils.isNotEmpty(params) ? `${url}?${QueryUtils.stringify(params)}` : url
    return this.fetch<R>(queryUrl, { config: { ...config, method: 'GET' } })
  }

  post<T, R = MutationResponse<T>>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<R | undefined> {
    return this.fetch<R>(url, { params, config: { ...config, method: 'POST' } })
  }

  put<T, R = MutationResponse<T>>(url: string, { params = {}, config = {} }: APIRequestParam): Promise<R | undefined> {
    return this.fetch<R>(url, { params, config: { ...config, method: 'PUT' } })
  }

  delete<T, R = MutationResponse<T>>(
    url: string,
    { params = {}, config = {} }: APIRequestParam,
  ): Promise<R | undefined> {
    return this.fetch<R>(url, { params, config: { ...config, method: 'DELETE' } })
  }

  private async fetch<R>(url: string, { params, config }: APIRequestParamWithMethod): Promise<R | undefined> {
    const { timeout = DEFAULT_TIMEOUT, headers = {}, baseUrl } = config
    const timeoutTimer = setTimeout(() => this.controller.abort, timeout)
    const fetchUrl = `${baseUrl ?? API_BASE_PATH}${url}`
    try {
      const requestInit: RequestInit = {
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
          ...headers,
        },
        method: config.method,
        signal: this.controller.signal,
        ...(ObjectUtils.isNotEmpty(params) && { body: JSON.stringify(params) }),
      }

      const result = await fetch(fetchUrl, requestInit).then(res => {
        return res.json()
      })

      const { error, data } = result ?? {}
      if (error) {
        throw error
      }
      // 타입 관련 에러가 많은 경우 zod도입 검토ㅌ
      return data
    } catch (e) {
      // todo - logger setting
      console.log('error: ', e.message)
      throw e
    } finally {
      clearTimeout(timeoutTimer)
    }
  }
}

export const ClientAPI = new ClientAPIClass()
