import { NextResponse } from 'next/server'

export const CLIENT_API_BASE_PATH = 'http://localhost:3000'
export const SERVER_API_BASE_PATH = 'http://localhost:8080'
export const DEFAULT_TIMEOUT = 10000

export interface APIRequestParam {
  params?: { [key in string]: any }
  config?: APIRequestConfig
}

export interface APIRequestParamWithMethod {
  params?: { [key in string]: any }
  config?: APIRequestConfig & { method: string }
}

interface APIRequestConfig {
  baseUrl?: string
  headers?: HeadersInit
  timeout?: number
}

export type QueryResponse<T = any> = { data: T | undefined }
export type MutationResponse<T = any> = { data: T | undefined; isSuccess: boolean }

export type MutationResponseWithError<T = any> = NextResponse<MutationResponse<T> | { error?: any }>
export type ResponseWithError<T = any> = NextResponse<QueryResponse<T> | { error?: any }>
