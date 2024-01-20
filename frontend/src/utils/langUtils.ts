import { isEmpty as isEmptyString} from "ramda";

const isNotEmpty = <T>(value?: T | null| undefined): value is T => !isEmptyString(value)
const isEmpty = <T>(value?: T | null | undefined) => !isNotEmpty(value)

export const LangUtils = {
  isNotEmpty,
  isEmpty,
}
