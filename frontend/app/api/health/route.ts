import { NextResponse } from 'next/server'

import { ResponseWithError } from 'api/api.types'
import { ServerAPI } from 'api/server/serverAPI'

export const GET = async (): Promise<ResponseWithError<string>> => {
  const result = await ServerAPI.get<{ body: string }>('/health', {})
  return NextResponse.json({ data: result?.body })
}
