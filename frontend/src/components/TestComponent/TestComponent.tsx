import s from './testComponent.module.scss'
import {cn} from "utils/commonUtils";

const TestComponent = () => {
  return <div className={cn(s.test_component)}>
    Please!
  </div>
}

export default TestComponent
