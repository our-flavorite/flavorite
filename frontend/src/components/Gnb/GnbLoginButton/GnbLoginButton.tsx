'use client'

import { useState } from 'react'

import { cn } from 'utils/commonUtils'

import s from './gnbLoginButton.module.scss'

const GnbLoginButton = () => {
  const [isLogin, setIsLogin] = useState<boolean>(false)
  return (
    <button className={cn(s.gnb_login_button)} type={'button'} onClick={() => setIsLogin(!isLogin)}>
      {isLogin ? '로그아웃' : '로그인'}
    </button>
  )
}

export default GnbLoginButton
