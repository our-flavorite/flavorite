export const API_BASE_PATH = 'http://localhost:3000'
export const DEFAULT_TIMEOUT = 10000

export interface APIRequestParam {
  params?: {[key in string]: any}
  config?: APIRequestConfig
}

export interface APIRequestParamWithMethod {
  params?: {[key in string]: any}
  config?: APIRequestConfig & { method: string }
}

interface APIRequestConfig {
  baseUrl?: string
  headers?: HeadersInit
  timeout?: number
}

export type QueryResponse<T = any> = { data: T | undefined }
export type MutationResponse<T = any> = { data: T | undefined; isSuccess: boolean }