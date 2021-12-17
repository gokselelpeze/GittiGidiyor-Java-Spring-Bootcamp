package service.loan.gittigidiyor_graduation_project.model.logger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditApplicationLogger extends BaseLogger {

    private String message;

    private String identityNumber;
}

