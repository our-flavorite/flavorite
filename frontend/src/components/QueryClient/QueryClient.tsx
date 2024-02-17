'use client'

import { QueryClient, QueryClientProvider } from "@tanstack/react-query"
import { ReactQueryDevtools } from "@tanstack/react-query-devtools"
import { ReactNode } from "react"

const client = new QueryClient()

const ReactQueryProvider = ({children}: {children: ReactNode}) => {
  return <QueryClientProvider client={client}>
  {children}
    <ReactQueryDevtools initialIsOpen={false}/>
</QueryClientProvider> 
}

export default ReactQueryProvider
