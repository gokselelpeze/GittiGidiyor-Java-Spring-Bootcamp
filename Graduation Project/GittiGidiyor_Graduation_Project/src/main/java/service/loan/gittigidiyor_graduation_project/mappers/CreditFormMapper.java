package service.loan.gittigidiyor_graduation_project.mappers;

import org.mapstruct.Mapper;
import service.loan.gittigidiyor_graduation_project.dto.CreditFormDTO;
import service.loan.gittigidiyor_graduation_project.model.CreditForm;

@Mapper(componentModel = "spring")

public abstract class CreditFormMapper {

    public abstract CreditForm mapFromCreditFormDTOToCreditForm(CreditFormDTO creditFormDTO);

    public abstract CreditFormDTO mapFromCreditFormToCreditFormDTO(CreditForm creditForm);
}
