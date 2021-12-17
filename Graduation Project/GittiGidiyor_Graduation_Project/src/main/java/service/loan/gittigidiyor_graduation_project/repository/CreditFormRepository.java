package service.loan.gittigidiyor_graduation_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.loan.gittigidiyor_graduation_project.model.CreditForm;

@Repository
public interface CreditFormRepository extends JpaRepository<CreditForm, Integer> {

    CreditForm findCreditFormByUserIdentityNumber(String identityNumber);

    Boolean existsByUserIdentityNumber(String identityNumber);

}
