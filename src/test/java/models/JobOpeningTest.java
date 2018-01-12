package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class JobOpeningTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewJobOpeningObjectGetsCorrectlyCreated_true() throws Exception {
        JobOpening jobOpening = setupNewJobOpening();
        assertEquals(true, jobOpening instanceof JobOpening);
    }

    //helper methods
    public JobOpening setupNewJobOpening(){
        LocalDateTime date = LocalDateTime.now();
        return new JobOpening("Java Developer", "Full time", date, true);
    }

}