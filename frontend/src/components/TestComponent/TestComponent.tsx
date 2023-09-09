import s from './testComponent.module.scss'
import {cn} from "utils/commonUtils";
import axios from "axios";
import {useState} from "react";

const TestComponent = () => {
  const [result, setResult] = useState<string | undefined>(undefined)
  const handleClick= () => {
    axios.get('localhost:8080/v1/api/ping').then(result => {
      setResult(result.data)
    })
  }
  
  return <div className={cn(s.test_component)}>
    <button onClick={handleClick}>버튼</button>
    <div>fetch 결과: ${result}</div>
  </div>
}

export default TestComponent
