package models;

import java.util.ArrayList;

public class Company {
    private String name;
    private String addres;
    private ArrayList<JobOpening> jobOpenings;
    private static ArrayList<Company> companies = new ArrayList<Company>();
    private int id;

    public Company(String name, String addres){
        this.name = name;
        this.addres = addres;
        this.jobOpenings = new ArrayList<JobOpening>();
        companies.add(this);
        this.id = companies.size();
    }

    public static void clearCompanies(){
        companies.clear();
    }

    public static ArrayList<Company> getCompanies(){
        return companies;
    }

    public String getAddres() {
        return addres;
    }

    public String getName() {
        return name;
    }

    public ArrayList<JobOpening> getJobOpenings() {
        return jobOpenings;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public static void setCompanies(ArrayList<Company> companies) {
        Company.companies = companies;
    }

    public void setJobOpenings(ArrayList<JobOpening> jobOpenings) {
        this.jobOpenings = jobOpenings;
    }

}
