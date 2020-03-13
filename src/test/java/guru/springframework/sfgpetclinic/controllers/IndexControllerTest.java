package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        Assertions.assertEquals("index", controller.index());
       // Assertions.assertEquals("indexd", controller.index(), "it is not matched");

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
}