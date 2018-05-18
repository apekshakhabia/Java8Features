package my.tutorials.behaviorparameterization.stratergy.filter.person;


import my.tutorials.model.Person;

public class FilterByNameAndAge implements PersonPredicate {

    @Override
    public boolean filter(Person person) {
        return person.getName().length() > 5 && person.getAge() > 20;
    }
}
