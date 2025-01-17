package pupket.togedogserver.domain.dog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

//@Entity
@Getter
@ToString
public class Vaccine {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long vaccinationId;

    private String vaccineName;

    private Date vaccinationDate;
}
