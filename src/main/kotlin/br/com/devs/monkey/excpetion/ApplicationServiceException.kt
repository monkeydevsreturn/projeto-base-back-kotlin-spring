package br.com.devs.monkey.excpetion

import br.com.devs.monkey.utils.MessageLoader

class ApplicationServiceException: Exception {
    constructor() : super()
    constructor(message: String?) : super(MessageLoader.getMessage(message))
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) : super(
        message,
        cause,
        enableSuppression,
        writableStackTrace
    )

}