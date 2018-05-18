package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.stratergy.filter.person.FilterByName;
import my.tutorials.behaviorparameterization.stratergy.filter.person.FilterByNameAndAge;
import my.tutorials.behaviorparameterization.stratergy.filter.person.PersonPredicate;
import my.tutorials.behaviorparameterization.stratergy.generic.GenericPredicate;
import my.tutorials.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPeopleStartingWithAorM;
import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPeopleWithGivenNameAndAge;
import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPeopleWithNameLengthAndAge;
import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPersonByGenericPredicate;
import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPersonByPersonPredicate;
import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPersonByPredicateWithName;
import static my.tutorials.behaviorparameterization.helper.PersonHelper.findPersonByPredicateWithNameAndAge;
import static my.tutorials.helper.DataHelper.initPeople;
import static org.assertj.core.api.Assertions.assertThat;


public class PersonFilterTestCases {

    private List<Person> personList = new ArrayList<>();

    @Before
    public void init() {
        //Given : List of Persons
        initPeople();
    }

    @Test
    public void filterPersonStartingWithAorM(){
         List<Person> filterPersonList = findPeopleStartingWithAorM(personList);

         for(Person person: filterPersonList){
             assertThat(person.getName()).startsWith("A");
         }
    }

    @Test
    public void filterPersonWithNameLengthAndAge(){
        List<Person> filterPersonList = findPeopleWithNameLengthAndAge(personList);

        for(Person person: filterPersonList){
            assertThat(person.getName().length()).isGreaterThan(3);
            assertThat(person.getAge()).isGreaterThan(20);
        }
    }

    @Test
    public void filterPersonWithGivenNameLengthAndAge(){
        List<Person> filterPersonList = findPeopleWithGivenNameAndAge(personList, "A", 5, 20);

        for(Person person: filterPersonList){
            assertThat(person.getName().length()).isGreaterThan(5);
            assertThat(person.getAge()).isGreaterThan(20);
        }
    }

    @Test
    public void filterPersonByPredicateWithName(){
        List<Person> filterPersonList = findPersonByPredicateWithName(personList, new FilterByName());

        for(Person person: filterPersonList){
            assertThat(person.getName()).startsWith("A");
        }
    }

    @Test
    public void filterPersonByPredicateWithNameAndAge(){
        List<Person> filterPersonList = findPersonByPredicateWithNameAndAge(personList, new FilterByNameAndAge());

        for(Person person: filterPersonList){
            assertThat(person.getName().length()).isGreaterThan(5);
            assertThat(person.getAge()).isGreaterThan(20);
        }
    }

    @Test
    public void filterPersonByAnonymousClass1(){
        List<Person> filterPersonList = findPersonByPersonPredicate(personList, new PersonPredicate() {
            @Override
            public boolean filter(Person person) {
                return person.getName().startsWith("A");
            }
        });

        for(Person person: filterPersonList){
            assertThat(person.getName()).startsWith("A");
        }
    }

    @Test
    public void filterPersonByAnonymousClass2(){
        List<Person> filterPersonList = findPersonByPersonPredicate(personList, new PersonPredicate() {
            @Override
            public boolean filter(Person person) {
                return person.getName().length() > 5 && person.getAge() > 20;
            }
        });

        for(Person person: filterPersonList){
            assertThat(person.getName().length()).isGreaterThan(5);
            assertThat(person.getAge()).isGreaterThan(20);
        }
    }

    @Test
    public void filterPersonByAnonymousClassGeneric1(){
        List<Person> filterPersonList = findPersonByGenericPredicate(personList, new GenericPredicate<Person>() {
            @Override
            public boolean filter(Person person) {
                return person.getName().startsWith("A");
            }
        });

        for(Person person: filterPersonList){
            assertThat(person.getName()).startsWith("A");
        }
    }

    @Test
    public void filterPersonByAnonymousClassGeneric2(){
        List<Person> filterPersonList = findPersonByGenericPredicate(personList, new GenericPredicate<Person>() {
            @Override
            public boolean filter(Person person) {
                return person.getName().length() > 5 && person.getAge() > 20;
            }
        });

        for(Person person: filterPersonList){
            assertThat(person.getName().length()).isGreaterThan(5);
            assertThat(person.getAge()).isGreaterThan(20);
        }
    }
}
