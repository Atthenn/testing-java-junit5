package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTest;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class VetControllerTest implements ControllerTest {


    VetService vetService ;
    SpecialtyService specialityService;
    VetController vc;


    @BeforeEach
    void setUp() {

        specialityService = new SpecialityMapService();
        vetService = new VetMapService(specialityService);
        vc = new VetController(vetService);
        Vet vet1 = new Vet(1L, "vetName1", "vetLastName1", null);
        Vet vet2 = new Vet(2L, "vetName2", "vetLastName2", null);
        vetService.save(vet1);
        vetService.save(vet2);


    }

   @Test
   void listVets(){


       ModelMapImpl model = new ModelMapImpl();

       String view = vc.listVets(model);
       Set modelAttribute = (Set) model.getMap().get("vets");

       assertThat("vets/index",is(view));
       assertThat(modelAttribute.size(),is(2));
   }
}