package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}