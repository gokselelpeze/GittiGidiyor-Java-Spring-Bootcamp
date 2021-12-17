package service.loan.gittigidiyor_graduation_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private String identityNumber;

    private int monthlyIncome;

    private String phoneNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    private CreditForm creditForm;

}
