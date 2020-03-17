package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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



    @DisplayName("someFancyName")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @CsvSource({"dd,1,1","bb,2,2","cc,3,3"})
    void csvTest(String val, int i, int j) {

        System.out.println(val + i+"="+ j );
    }


    @DisplayName("someFancyName")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvTestFile(String val, int i, int j) {

        System.out.println(val + i+"="+ j );
    }


    @DisplayName("Custom Args Provider")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void methodProviderTest(String val, int i, int j) {

        System.out.println(val + i+"="+ j );
    }

    static Stream<Arguments> getArgs(){

        return  Stream.of(
                Arguments.of("aa",1,1),
                Arguments.of("mm",2,2),
                Arguments.of("hh",3,3)
        );
    }

}