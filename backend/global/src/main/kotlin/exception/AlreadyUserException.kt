package exception

class AlreadyUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message) {
}