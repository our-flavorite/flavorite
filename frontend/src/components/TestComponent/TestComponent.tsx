'use client'

import { useState } from 'react'

import { ClientAPI } from 'api/client/clientAPI'
import { cn } from 'utils/commonUtils'

import s from './testComponent.module.scss'

const TestComponent = () => {
  const [result, setResult] = useState<string | undefined>(undefined)
  const handleClick = async () => {
    await ClientAPI.get<string>('/api/ping', {}).then(res => {
      setResult(res?.data)
    })
  }

  return (
    <div className={cn(s.test_component)}>
      <button type={'button'} onClick={handleClick}>
        {'버튼'}
      </button>
      <div>
        {'fetch 결과: $'}
        {result}
      </div>
    </div>
  )
}

export default TestComponent
