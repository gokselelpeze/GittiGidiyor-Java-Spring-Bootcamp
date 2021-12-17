package service.loan.gittigidiyor_graduation_project.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.loan.gittigidiyor_graduation_project.model.CreditForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    @ApiModelProperty(hidden = true)
    private int id;

    @ApiModelProperty(example = "Gökhan Göksel Elpeze")
    @NotBlank(message = "Name is mandatory")
    private String fullName;

    @ApiModelProperty(example = "29903218711")
    @NotBlank(message = "Identity number is mandatory")
    private String identityNumber;

    @ApiModelProperty(example = "3000")
    @NotNull
    private int monthlyIncome;

    @ApiModelProperty(example = "05554554545")
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    private CreditForm creditForm;

}
