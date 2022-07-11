package br.com.megadata.megareg.apiintegracaobancos.infra.config.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.megadata.megareg.apiintegracaobancos.core.exception.ApiBankIntergrationException;
import br.com.megadata.megareg.apiintegracaobancos.core.exception.business.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

	@ExceptionHandler({BusinessException.class})
    protected ResponseEntity<ApiError> handleBadRequestExceptionsForDecanting(final ApiBankIntergrationException exception) {
        log.error(BAD_REQUEST.getReasonPhrase(), exception);

        return createResponseEntity(BAD_REQUEST, exception.getError(), exception.getMessage());
    }

	private ResponseEntity<ApiError> createResponseEntity(HttpStatus badRequest, String error, String message) {
		// TODO Auto-generated method stub
		return null;
	}
}
