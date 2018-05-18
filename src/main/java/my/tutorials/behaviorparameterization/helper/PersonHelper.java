package my.tutorials.behaviorparameterization.helper;

import my.tutorials.behaviorparameterization.stratergy.filter.person.FilterByName;
import my.tutorials.behaviorparameterization.stratergy.filter.person.FilterByNameAndAge;
import my.tutorials.behaviorparameterization.stratergy.filter.person.PersonPredicate;
import my.tutorials.behaviorparameterization.stratergy.generic.GenericPredicate;
import my.tutorials.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonHelper {

    //Given a list of People, filter all people with names starting with 'a' or 'm'
    public static List<Person> findPeopleStartingWithAorM(List<Person> personList) {
        List<Person> filteredPerson = new ArrayList<>();

        for(Person person : personList) {
            if(person.getName().startsWith("A") || person.getName().startsWith("M")) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    //Given a list of People, filter all people with names greater than 5 characters and age greater than 20
    public static List<Person> findPeopleWithNameLengthAndAge(List<Person> personList) {
        List<Person> filteredPerson = new ArrayList<>();

        for(Person person : personList) {
            if(person.getName().length() > 5 && person.getAge() > 20) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    //Given the 2 functions, written to satisfy Requirement 1 and 2, write a common function that will accept the filtering behaviour as a parameter
    public static List<Person> findPeopleWithGivenNameAndAge(List<Person> personList, String prefixName, int nameLength, int age) {
        List<Person> filteredPerson = new ArrayList<>();

        for(Person person : personList) {
            if(person.getName().length() > nameLength && person.getName().startsWith(prefixName) && person.getAge() > age) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }


    //Use PersonPredicate as the interface with the filter method, accepting Person entity and returning a boolean value.
    //  Define 2 implementations of the PersonPredicate that will satisfy Requirement 1 and 2.
    public static List<Person> findPersonByPredicateWithName(List<Person> personList, FilterByName filterByName){
        List<Person> filteredPerson = new ArrayList<>();

        for(Person person : personList) {
            if(filterByName.filter(person)) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    public static List<Person> findPersonByPredicateWithNameAndAge(List<Person> personList, FilterByNameAndAge filterByNameAndAge){
        List<Person> filteredPerson = new ArrayList<>();

        for(Person person : personList) {
            if(filterByNameAndAge.filter(person)) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    public static List<Person> findPersonByPersonPredicate(List<Person> personList, PersonPredicate personPredicate){
        List<Person> filteredPerson = new ArrayList<>();
        for(Person person : personList) {
            if(personPredicate.filter(person)) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    public static List<Person> findPersonByGenericPredicate(List<Person> personList, GenericPredicate<Person> genericPersonPredicate){
        List<Person> filteredPerson = new ArrayList<>();
        for(Person person : personList) {
            if(genericPersonPredicate.filter(person)) {
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

}
