package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JobOpening {
  private String jobTitle;
  private String jobType;
  private LocalDateTime postedAt;
  private boolean available;
  private ArrayList<Applicant> applicants;
  private static ArrayList<JobOpening> jobOpenings = new ArrayList<JobOpening>();
  private int id;

  public JobOpening(String jobTitle, String jobType, LocalDateTime postedAt, boolean available){
    this.jobTitle= jobTitle;
    this.jobType = jobType;
    this.postedAt = postedAt;
    this.applicants = new ArrayList<Applicant>();
    jobOpenings.add(this);
    this.id= jobOpenings.size();
  }

    public static ArrayList<JobOpening> getJobOpenings(){
      return jobOpenings;
    }
    public static void clearJobOpenings(){
      jobOpenings.clear();
    }
    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }
    public LocalDateTime getPostedAt(){
      return postedAt;
    }

    public ArrayList<Applicant> getApplicants() {
        return applicants;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setApplicants(ArrayList<Applicant> applicants) {
        this.applicants = applicants;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }
}
