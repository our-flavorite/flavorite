'use client'

import { useState } from 'react'

import { ClientAPI } from 'api/client/clientAPI'
import { cn } from 'utils/commonUtils'

import s from './testComponent.module.scss'
import { useQuery } from '@tanstack/react-query'

const TestComponent = () => {
  const [result, setResult] = useState<string | undefined>(undefined)
  const { data, refetch } = useQuery<string>({
    queryKey: ["example"], // todo - 관리 방법 참고해서 업데이트하기
    queryFn: async () => await ClientAPI.get<string>('/api/health', {})
  })

  const handleClick = async () => {
    const res = await refetch()
    setResult(data)
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
