package ru.volkova.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.volkova.springcourse.models.Person;
import ru.volkova.springcourse.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    Person person = (Person) o;
    //check the existence of the person's name in the BD
       if (peopleService.findByName(person.getName()).isPresent())
           errors.rejectValue("name", "", "Человек с таким именем уже существует");

    }
}
