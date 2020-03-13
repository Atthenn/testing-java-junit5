package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
       // Assertions.assertEquals("indexd", controller.index(), "it is not matched");
        assertThat(controller.index()).isEqualTo("index");

    }

    @Test
    void oupsHandler() {

       // Assertions.assertTrue("notimplemented ".equals(controller.oupsHandler()), () -> "dddddd");
        Assertions.assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }

    @Disabled
    @Test
    void testTimeOut() {
        Assertions.assertTimeout(Duration.ofMillis(100), () ->
                Thread.sleep(2000));
        System.out.println("I got here");
    }

    @Disabled
    @Test
    void testTimeOutPreemptivly() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () ->
                Thread.sleep(2000));

        System.out.println("I got here helllooo");

    }

    @Test
    void testAssumptionTrue() {

        Assumptions.assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrue2() {

        Assumptions.assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }


    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "atena")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }
}