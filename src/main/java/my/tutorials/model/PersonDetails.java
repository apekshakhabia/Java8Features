package my.tutorials.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonDetails {
    //Name: name
    private String formattedName;
    //Age: age years
    private String formattedAge;
    //Gender: gender
    private String formattedGender;
}
