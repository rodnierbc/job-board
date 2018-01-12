package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewCompanyObjectGetsCorrectlyCreated_true() throws Exception {
        Company company = setupNewCompany();
        assertEquals(true, company instanceof Company);
    }

    //helper methods
    public Company setupNewCompany(){
        return new Company ("Intel", "1222 sw Lomita ave Hillsboro OR");
    }
}
