package ningenme.net.kiwaapi.application.common

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionHandler {

    companion object {
        private val logger = LoggerFactory.getLogger(CustomExceptionHandler::class.java)
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: java.lang.Exception): ResponseEntity<String> {
        logger.error(exception.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }
}
