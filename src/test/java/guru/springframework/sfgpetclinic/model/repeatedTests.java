package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.assignmentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class repeatedTests implements assignmentTest {


    @RepeatedTest(value=10 , name = "{displayName} - {currentRepetition} : {totalRepetitions}")
    void repeatedTest(){
    }

    @RepeatedTest(5)
    void repeatedTestwithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ":" + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value=5, name="{displayName}")
    @DisplayName("CustomizedName")
    void assignmentTest() {
    }
}
