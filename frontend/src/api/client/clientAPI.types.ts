export const DEFAULT_TIMEOUT = 10000

export interface APIRequestParamWithMethod {
  params?: {[key in string]: any}
  config?: APIRequestConfig & { method: string }
}

interface APIRequestConfig {
  baseUrl?: string
  headers?: HeadersInit
  timeout?: number
}