package my.tutorials.behaviorparameterization.stratergy.filter.person;

import my.tutorials.model.Person;

public interface PersonPredicate {

    boolean filter(Person person);
}
