package my.tutorials.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private PersonGender gender;

    @Override
    public String toString() {
        return "\nPerson{ Name: "+ name + ", Age: " + age + " years"+ ", Gender: " + gender + " }";
    }
}
