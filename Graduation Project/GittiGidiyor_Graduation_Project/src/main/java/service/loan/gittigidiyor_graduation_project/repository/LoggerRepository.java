package service.loan.gittigidiyor_graduation_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.loan.gittigidiyor_graduation_project.model.logger.BaseLogger;
import service.loan.gittigidiyor_graduation_project.model.logger.ExceptionLogger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoggerRepository extends JpaRepository<BaseLogger, Long> {

    Optional<List<ExceptionLogger>> findExceptionLoggerByStatusCodeContainingAndTimestampBetween(String statusCode, LocalDateTime from, LocalDateTime to);

    Optional<List<ExceptionLogger>> findExceptionLoggerByStatusCodeContaining(String statusCode);

}