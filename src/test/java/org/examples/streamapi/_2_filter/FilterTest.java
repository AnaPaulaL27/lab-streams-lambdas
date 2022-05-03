package org.examples.streamapi._2_filter;

import org.examples.streamapi.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTest {

    @Test
    void filterPeopleYoungerThan20_comments(){
        List<Person> filteredPeople = PEOPLE
                // We need to change a list into a stream to have access to Stream
                .stream()
                .filter(
                        // Let's pass lambda (again, a more extended version to be more similar to a method
                        (person) -> {
                            return person.getAge() < 20;
                        }
                )
                // Now it's time to go back to a List
                .toList();

        assertEquals(5, filteredPeople.size());
    }

    @Test
    void filterPeopleYoungerThan20(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getAge() < 20)
                .toList();

        assertEquals(5, filteredPeople.size());
    }


//    Time for some practice:
//     - filter by: age < 20 && age > 30
     @Test

    void filterPeopleYoungerThan20andOlderThan30(){
         List<Person> filteredPeople = PEOPLE

                 .stream()
                 .filter(person -> person.getAge() <20 || person.getAge()>30)
                         .toList();

         assertEquals(11, filteredPeople.size());

     }


//     - filter by: firstName starts with "Z" and age < 20

    @Test
    void filterPeopleFirstLetterZAndAgeBelow20(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getName().startsWith("Z") && (person.getAge()<20))
                        .toList();

        assertEquals(1, filteredPeople.size());
    }


//     - filter by: Gender: non-binary and  age > 30


    @Test
    void filterGenderNonBinaryAgeGreater30(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getGender()== Person.Gender.NON_BINARY && (person.getAge()>30))
                .toList();

        assertEquals(2, filteredPeople.size());

    }

//     - filter by lastName starts with "B" and age > 50

    @Test

    void filterPeopleLastNameLetterBAndAgeGreater50(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getLastName().startsWith("B") && (person.getAge()>50))
                .toList();

        assertEquals(1, filteredPeople.size());

    }

}
