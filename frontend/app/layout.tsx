import {ReactNode} from 'react'
import {Metadata} from 'next'

export const metadata: Metadata = {
  title: '내가 가장 좋아하는 맛, flavorite',
}

interface RootLayoutProps {
  children: ReactNode
}

const RootLayout = ({children}: RootLayoutProps) => {
  return (
    <html lang="ko">
      <body>{children}</body>
    </html>
  )
}

export default RootLayout