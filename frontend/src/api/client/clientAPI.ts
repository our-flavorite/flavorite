import {APIRequestParamWithMethod, DEFAULT_TIMEOUT} from "api/client/clientAPI.types";
import {API_BASE_PATH} from "api/api.types";

class ClientAPIClass {
  private controller: AbortController
  
  constructor() {
    this.controller = new AbortController()
  }
  
  get() {
  
  }
  put(){
  
  }
  post(){
  
  }
  delete(){
  
  }
  
  private async fetch<T>(url: string, {params, config}: APIRequestParamWithMethod): Promise<T> {
    const {timeout= DEFAULT_TIMEOUT, headers} = config
    const timeoutTimer = setTimeout(() => this.controller.abort, timeout)
    const fetchUrl = `${API_BASE_PATH}`
    try {
      const requestInit: RequestInit = {
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
          // todo - headers 정보 spread
        },
        method: config.method,
        signal: this.controller.signal,
        // todo - params 정보 spread
      }
      const result = await fetch(fetchUrl, requestInit).then((res) => res.json())
      const { error, data } = result ?? {}
    } catch (e){
    
    } finally {
      clearTimeout(timeoutTimer)
    }
  }
  
}

export const ClientAPI = new ClientAPIClass()
