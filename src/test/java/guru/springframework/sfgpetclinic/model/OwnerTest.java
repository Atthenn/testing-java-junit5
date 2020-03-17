package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTest {
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

        assertThat(owner.getCity(),is("Paris"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three"})
    void testValueSource(String val) {

        System.out.println(val);
    }
    @DisplayName("someFancyName")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"one", "two", "three"})
    void testDisplayName(String val) {

        System.out.println(val);
    }

    @DisplayName("someFancyName")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnum(OwnerType ownerType) {

        System.out.println(ownerType);
    }
}