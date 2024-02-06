import {ServerAPI} from "api/server/serverAPI";
import {ResponseWithError} from "api/api.types";
import {NextResponse} from "next/server";

export const GET = async(): Promise<ResponseWithError<string>> => {
  const result = await ServerAPI.get<{body: string}>('/v1/api/ping', {})
  return NextResponse.json({ data: result?.body })
}
