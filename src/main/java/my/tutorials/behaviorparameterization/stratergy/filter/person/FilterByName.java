package my.tutorials.behaviorparameterization.stratergy.filter.person;


import my.tutorials.model.Person;

public class FilterByName implements PersonPredicate{

    @Override
    public boolean filter(Person person) {
        return person.getName().startsWith("A");
    }
}
