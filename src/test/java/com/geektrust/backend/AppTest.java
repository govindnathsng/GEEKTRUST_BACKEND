package com.geektrust.backend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void shouldHavePower145WhenSourceIs14NAndDestinationIs46() {
        App.main(new String[]{"src/test/resources/input1.txt"});
        assertEquals("POWER 145", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower155WhenSourceIs21EAndDestinationIs43() {
        App.main(new String[]{"src/test/resources/input2.txt"});
        assertEquals("POWER 155", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower90WhenSourceIs05WAndDestinationIs61() {
        App.main(new String[]{"src/test/resources/input3.txt"});
        assertEquals("POWER 90", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower110WhenSourceIs36NAndDestinationIs10() {
        App.main(new String[]{"src/test/resources/input4.txt"});
        assertEquals("POWER 110", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower140WhenSourceIs14SAndDestinationIs46() {
        App.main(new String[]{"src/test/resources/input5.txt"});
        assertEquals("POWER 140", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower180WhenSourceIs11SAndDestinationIs12() {
        App.main(new String[]{"src/test/resources/input6.txt"});
        assertEquals("POWER 180", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldHavePower170WhenSourceIs31WAndDestinationIs51() {
        App.main(new String[]{"src/test/resources/input7.txt"});
        assertEquals("POWER 170", outputStreamCaptor.toString().trim());
    }
}
