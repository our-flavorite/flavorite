import { isEmpty as isEmptyObject, isNil } from 'ramda'

const isEmpty = (o: object | null | undefined): boolean => {
  return isEmptyObject(o) || isNil(o)
}

const isNotEmpty = (o: object | null | undefined): boolean => !isEmpty(o)

export const ObjectUtils = {
  isEmpty,
  isNotEmpty,
}
