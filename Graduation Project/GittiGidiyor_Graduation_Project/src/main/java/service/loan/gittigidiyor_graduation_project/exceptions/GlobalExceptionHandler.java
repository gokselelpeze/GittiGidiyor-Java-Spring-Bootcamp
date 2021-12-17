package service.loan.gittigidiyor_graduation_project.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import service.loan.gittigidiyor_graduation_project.model.logger.ExceptionLogger;
import service.loan.gittigidiyor_graduation_project.repository.LoggerRepository;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private LoggerRepository loggerRepository;

    @ExceptionHandler({IdentityNumberIsNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(IdentityNumberIsNotValidException exc) {
        ExceptionLogger exception = new ExceptionLogger(exc.getMessage(), HttpStatus.BAD_REQUEST);
        loggerRepository.save(exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserHasLoanApplicationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(UserHasLoanApplicationException exc) {
        ExceptionLogger exception = new ExceptionLogger(exc.getMessage(), HttpStatus.BAD_REQUEST);
        loggerRepository.save(exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserHasNotLoanApplicationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(UserHasNotLoanApplicationException exc) {
        ExceptionLogger exception = new ExceptionLogger(exc.getMessage(), HttpStatus.BAD_REQUEST);
        loggerRepository.save(exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserIsExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(UserIsExistException exc) {
        ExceptionLogger exception = new ExceptionLogger(exc.getMessage(), HttpStatus.BAD_REQUEST);
        loggerRepository.save(exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserIsNotExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(UserIsNotExistException exc) {
        ExceptionLogger exception = new ExceptionLogger(exc.getMessage(), HttpStatus.BAD_REQUEST);
        loggerRepository.save(exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}