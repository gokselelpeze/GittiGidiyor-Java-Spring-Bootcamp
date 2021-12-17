package service.loan.gittigidiyor_graduation_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditFormDTO {

    private int id;

    private String userIdentityNumber;

    private int creditLimit;

    private Boolean result;


}
