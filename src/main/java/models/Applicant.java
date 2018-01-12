package models;

import java.util.ArrayList;

public class Applicant {
    private String fullName;
    private String phone;
    private String addres;
    private String education;
    private String email;
    private String description;
    private static ArrayList<Applicant> applicants = new ArrayList<Applicant>();
    private int id;

    public Applicant(String fullName, String phone, String addres, String education, String email, String description){
        this.fullName = fullName;
        this.phone = phone;
        this.addres = addres;
        this.education = education;
        this.email = email;
        this.description = description;
        applicants.add(this);
        this.id = applicants.size();
    }

    public static ArrayList<Applicant> getApplicants(){
        return applicants;
    }
    public static void clearApplicants(){
        applicants.clear();
    }
    public static Applicant findById(int id){
        Applicant applicant = null;
        for(int i = 0; i<applicants.size();i++){
            if(applicants.get(i).getId() == id){
               applicant = applicants.get(i);
               i = applicants.size();
            }
        }
        return applicant;
    }

    public void update(String fullName, String phone, String addres, String education, String email, String description) {
        this.fullName = fullName;
        this.phone = phone;
        this.addres = addres;
        this.education = education;
        this.email = email;
        this.description = description;
    }
    public void deletePost(){
        applicants.remove(this);
    }

    public String getAddres() {
        return addres;
    }

    public String getDescription() {
        return description;
    }

    public String getEducation() {
        return education;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public int getId(){
        return id;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setAddres(String addres){
        this.addres = addres;
    }
    public void setEducation(String education){
        this.education = education;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
