import { QueryClient } from '@tanstack/react-query'
import ReactQueryProvider from 'components/QueryClient/QueryClient'
import { Metadata } from 'next'
import { ReactNode } from 'react'

export const metadata: Metadata = {
  title: '내가 가장 좋아하는 맛, flavorite',
}

interface RootLayoutProps {
  children: ReactNode
}

const queryClient = new QueryClient()

const RootLayout = ({ children }: RootLayoutProps) => {
  return (
    <html lang={'ko'}>
      <body>
        <ReactQueryProvider>
        {children}
        </ReactQueryProvider>
      </body>
    </html>
  )
}

export default RootLayout
