import ReactQueryProvider from 'components/QueryClient/QueryClient'
import { Metadata } from 'next'
import { ReactNode } from 'react'

export const metadata: Metadata = {
  title: '내가 가장 좋아하는 맛, flavorite',
}

interface RootLayoutProps {
  children: ReactNode
}

const RootLayout = ({ children }: RootLayoutProps) => {
  return (
    <html lang={'ko'}>
      <body>
        <div>gnb 영역</div>
        <ReactQueryProvider>
        {children}
        </ReactQueryProvider>
      </body>
    </html>
  )
}

export default RootLayout
