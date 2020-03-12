package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    @Test
    void dependentAssertion() {

        Owner owner = new Owner(1L,"Atena","Kalaki");
        owner.setCity("Paris");
        owner.setTelephone("1234");

        assertAll( "Properties test",
                () -> assertAll("Person properties",
                        () ->    assertEquals("Atena", owner.getFirstName(),"Fisrt Name not matched"),
                        () ->    assertEquals("Kalaki", owner.getLastName())),

                () -> assertAll("Owner properties",
                        () ->    assertEquals("Paris", owner.getCity(),"city name not matched"),
                        () ->    assertEquals("1234", owner.getTelephone()))

        );



    }
}