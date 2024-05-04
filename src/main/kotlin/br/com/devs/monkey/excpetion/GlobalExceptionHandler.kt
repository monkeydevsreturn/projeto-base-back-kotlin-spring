package br.com.devs.monkey.excpetion

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException.InternalServerError
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handlerInternalServerException(ex: InternalServerError): ResponseEntity<MessageException> {
        val messageException = MessageException(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message,
            LocalDateTime.now()
        )
        return ResponseEntity(messageException, HttpStatus.INTERNAL_SERVER_ERROR)
    }
    @ExceptionHandler
    fun handlerConstraintValidationException(ex: ConstraintViolationException): ResponseEntity<MessageException> {
        val messageException = MessageException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            LocalDateTime.now()
        )
        return ResponseEntity(messageException, HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler
    fun handlerApplicationServiceException(ex: ApplicationServiceException): ResponseEntity<MessageException> {
        val messageException = MessageException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            LocalDateTime.now()
        )
        return ResponseEntity(messageException, HttpStatus.BAD_REQUEST)
    }
}