package service.loan.gittigidiyor_graduation_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.loan.gittigidiyor_graduation_project.dto.CreditFormDTO;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.exceptions.IdentityNumberIsNotValidException;
import service.loan.gittigidiyor_graduation_project.exceptions.UserHasLoanApplicationException;
import service.loan.gittigidiyor_graduation_project.exceptions.UserHasNotLoanApplicationException;
import service.loan.gittigidiyor_graduation_project.mappers.CreditFormMapper;
import service.loan.gittigidiyor_graduation_project.model.logger.CreditApplicationLogger;
import service.loan.gittigidiyor_graduation_project.repository.CreditFormRepository;
import service.loan.gittigidiyor_graduation_project.repository.LoggerRepository;
import service.loan.gittigidiyor_graduation_project.utils.Constants;

@Service
@Transactional
@RequiredArgsConstructor
public class CreditFormService {

    public final int CREDIT_LIMIT_MULTIPLIER = 4;
    private final CreditFormRepository creditFormRepository;
    private final CreditFormMapper creditFormMapper;
    private final UserService userService;
    private final LoggerRepository loggerRepository;

    public int getCreditScore(String lastDigit) {

        switch (lastDigit) {
            case "0":
                return 2000;
            case "2":
                return 550;
            case "4":
                return 1000;
            case "6":
                return 400;
            case "8":
                return 900;
            default:
                return -1;
        }
    }

    @Transactional
    public CreditFormDTO applyCredit(UserDTO userDTO) {
        String lastDigit = userDTO.getIdentityNumber().substring(userDTO.getIdentityNumber().length() - 1);
        int creditScore = getCreditScore(lastDigit);
        if (creditScore == -1) {
            throw new IdentityNumberIsNotValidException("Given identity number: " + userDTO.getIdentityNumber() + " is not valid!");
        }

        int limit = 0;
        boolean creditResult = true;

        if (creditScore < 500)
            creditResult = false;

        else if (creditScore < 1000) {
            if (userDTO.getMonthlyIncome() < 5000)
                limit = 10000;
            else
                limit = 20000;
        }
        else
            limit = userDTO.getMonthlyIncome() * CREDIT_LIMIT_MULTIPLIER;


        // Create credit form
        CreditFormDTO creditFormDTO = new CreditFormDTO();
        creditFormDTO.setUserIdentityNumber(userDTO.getIdentityNumber());
        creditFormDTO.setResult(creditResult);
        creditFormDTO.setCreditLimit(limit);

        userDTO.setCreditForm(creditFormMapper.mapFromCreditFormDTOToCreditForm(creditFormDTO));
        userService.saveUser(userDTO);

        // Create log
        String message = "Your credit application is " + ((creditResult) ? Constants.CONFIRMED : Constants.REJECTED) + ". Credit Limit: " + limit;
        CreditApplicationLogger log = new CreditApplicationLogger(message, userDTO.getIdentityNumber());
        loggerRepository.save(log);

        return creditFormMapper.mapFromCreditFormToCreditFormDTO(userDTO.getCreditForm());
    }

    @Transactional
    public void save(CreditFormDTO creditFormDTO) {

        boolean isExists = creditFormRepository.existsByUserIdentityNumber(creditFormDTO.getUserIdentityNumber());

        if (isExists) {
            throw new UserHasLoanApplicationException("User with identity number : " + creditFormDTO.getUserIdentityNumber() + " is already has a loan application!");
        }
        creditFormRepository.save(creditFormMapper.mapFromCreditFormDTOToCreditForm(creditFormDTO));

    }

    @Transactional
    public CreditFormDTO findCreditFormByUserIdentityNumber(String identityNumber) {
        boolean isExists = creditFormRepository.existsByUserIdentityNumber(identityNumber);

        if (!isExists) {
            throw new UserHasNotLoanApplicationException("User with identity number : " + identityNumber + " is not has a loan application!");
        }

        return creditFormMapper.mapFromCreditFormToCreditFormDTO(
                creditFormRepository.findCreditFormByUserIdentityNumber(identityNumber));
    }
}
