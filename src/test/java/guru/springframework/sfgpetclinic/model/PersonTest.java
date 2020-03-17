package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTest {
    @Test
    void groupedAssertion() {

        Person person = new Person(1L,"atena","Kalaki");

        assertAll(
                "test props set",
                () -> assertEquals("atena", person.getFirstName()),
                () -> assertEquals("Kalaki", person.getLastName())
        );
    }
    @Test
    void groupedAssertionMsg() {

        Person person = new Person(1L,"atena","Kalaki");

        assertAll(
                "test props set2",
                () -> assertEquals("atena", person.getFirstName(),"wrong first name"),
                () -> assertEquals("Kalaki", person.getLastName(),"wrong last name")
        );

    }

    int x =1;

    @RepeatedTest(value=10 , name = "{displayName} - {currentRepetition} : {totalRepetitions}")
    void repeatedTest(){
        x++;
        System.out.println(x);

    }
}