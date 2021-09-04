package goksel.elpeze.h2db.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
@NoArgsConstructor
public class PermanentInstructor extends Instructor {

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double fixedSalary;

    @Builder
    public PermanentInstructor(int id, @NotBlank(message = "Name is mandatory") String name, String address, String phoneNumber, List<Course> courses, double fixedSalary) {
        super(id, name, address, phoneNumber, courses);
        this.fixedSalary = fixedSalary;
    }
}
