'use client'

import { useState } from "react"

const GnbLoginButton = () => {
    const [isLogin, setIsLogin] = useState<boolean>(false)
    return <button onClick={() => setIsLogin(!isLogin)}>
        {isLogin ? '로그아웃' : '로그인'}
    </button>
}

export default GnbLoginButton
