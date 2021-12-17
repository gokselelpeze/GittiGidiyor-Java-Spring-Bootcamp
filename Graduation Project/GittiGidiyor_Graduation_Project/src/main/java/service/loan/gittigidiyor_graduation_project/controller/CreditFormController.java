package service.loan.gittigidiyor_graduation_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.loan.gittigidiyor_graduation_project.dto.CreditFormDTO;
import service.loan.gittigidiyor_graduation_project.dto.UserDTO;
import service.loan.gittigidiyor_graduation_project.service.CreditFormService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CreditFormController {

    private final CreditFormService creditFormService;


    @Autowired
    public CreditFormController(CreditFormService creditFormService) {
        this.creditFormService = creditFormService;
    }

    @PostMapping("/credit")
    public ResponseEntity<?> applyCredit(@RequestBody UserDTO userDTO) {
        CreditFormDTO creditFormDTO = creditFormService.applyCredit(userDTO);
        if (creditFormDTO.getResult()) {
            return new ResponseEntity<>("Your credit limit is: " + creditFormDTO.getCreditLimit(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Your credit limit is: " + creditFormDTO.getCreditLimit(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/credit/{identityNumber}")
    public ResponseEntity<?> findCreditForm(@PathVariable @Valid String identityNumber) {
        CreditFormDTO creditFormDTO = creditFormService.findCreditFormByUserIdentityNumber(identityNumber);
        return new ResponseEntity<>(creditFormDTO, HttpStatus.OK);
    }
}
