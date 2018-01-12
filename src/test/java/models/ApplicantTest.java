package models;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ApplicantTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewApplicantObjectGetsCorrectlyCreated_true() throws Exception {
        Applicant applicant = setupNewApplicant();
        assertEquals(true, applicant instanceof Applicant);
    }
    @Test
    public void FindApplicantByID_Applicant() {
        ArrayList<Applicant> applicants = new ArrayList<>();
        Applicant applicant = setupNewApplicant();
        applicants.add(applicant);
        assertEquals(true, Applicant.findById(1) == applicants.get(0));
    }


    //helper methods
    public Applicant setupNewApplicant(){
        return new Applicant ("Rodnier Borrego Clavero", "5037378990", "11517 sw Lomita ave Tigard OR", "Computer Science", "rodnierbc89@gmail.com","my description" );
    }
}