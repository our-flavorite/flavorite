'use client'

import { useQuery } from '@tanstack/react-query'
import { useState } from 'react'

import { ClientAPI } from 'api/client/clientAPI'
import { cn } from 'utils/commonUtils'

import s from './testComponent.module.scss'

const TestComponent = () => {
  const [result] = useState<string | undefined>(undefined)
  const { refetch } = useQuery<string>({
    queryKey: ['example'], // todo - 관리 방법 참고해서 업데이트하기
    queryFn: () => ClientAPI.get<string>('/api/health', {}),
  })

  const handleClick = async () => {
    await refetch()
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
