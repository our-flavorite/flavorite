'use client'

import s from './testComponent.module.scss'
import {cn} from "utils/commonUtils";
import {useState} from "react";
import {ClientAPI} from "api/client/clientAPI";

const TestComponent = () => {
  const [result, setResult] = useState<string | undefined>(undefined)
  const handleClick= async () => {
    await ClientAPI.get<string>('/api/ping', {}).then((res) => {
      setResult(res.data)
    })
  }
  
  return <div className={cn(s.test_component)}>
    <button onClick={handleClick}>버튼</button>
    <div>fetch 결과: ${result}</div>
  </div>
}

export default TestComponent
