package exception

class NotFoundUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)
