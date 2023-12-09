import { isNil } from 'ramda'

const isNullish = (value?: any): boolean => {
  return isNil(value)
}

export const NullUtils = {
  isNullish
}
