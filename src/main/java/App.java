
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Applicant;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        //get: show all applicants
        get("/applicant/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Applicant> applicants = Applicant.getApplicants();
            model.put("applicants", applicants);
            return new ModelAndView(model, "applicant/index.hbs");
        }, new HandlebarsTemplateEngine());
        //get: show new applicant form
        get("/applicant/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "applicant/applicant-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: new Applicant form
        post("/applicant/new", (request, response) -> { //URL to make new applicant on POST route
            Map<String, Object> model = new HashMap<>();
            String fullName = request.queryParams("fullName");
            String email = request.queryParams("email");
            String addres = request.queryParams("addres");
            String phone = request.queryParams("phone");
            String education = request.queryParams("education");
            String description = request.queryParams("description");
            Applicant applicant = new Applicant(fullName,phone,addres,education,email,description);
            ArrayList<Applicant> applicants = Applicant.getApplicants();
            model.put("applicants", applicants);
            return new ModelAndView(model, "applicant/index.hbs");
        }, new HandlebarsTemplateEngine());

        //Applicant details.
        get("/applicant/view/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfApplicantToFind = Integer.parseInt(request.params("id")); //pull id - must match route segment
            Applicant applicant = Applicant.findById(idOfApplicantToFind);
            model.put("applicant", applicant);
            return new ModelAndView(model, "applicant/applicant-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

        get("/applicant/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfApplicantToEdit = Integer.parseInt(req.params("id"));
            Applicant editApplicant = Applicant.findById(idOfApplicantToEdit);
            model.put("editApplicant", editApplicant);
            return new ModelAndView(model, "applicant/applicant-form.hbs");
        }, new HandlebarsTemplateEngine());
        post("/applicant/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String fullNameUpdate = req.queryParams("fullNameUpdate");
            String emailUpdate = req.queryParams("emailUpdate");
            String addresUpdate = req.queryParams("addresUpdate");
            String phoneUpdate = req.queryParams("phoneUpdate");
            String educationUpdate = req.queryParams("educationUpdate");
            String descriptionUpdate = req.queryParams("descriptionUpdate");
            int idOfApplicantToEdit = Integer.parseInt(req.params("id"));
            Applicant editApplicant = Applicant.findById(idOfApplicantToEdit);
            editApplicant.update(fullNameUpdate,emailUpdate,addresUpdate,phoneUpdate, educationUpdate, descriptionUpdate); //don’t forget me
            model.put("applicant",Applicant.findById(idOfApplicantToEdit));
            return new ModelAndView(model, "applicant/applicant-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/applicant/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfApplicantToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Applicant deleteApplicant = Applicant.findById(idOfApplicantToDelete);
            deleteApplicant.deletePost();
            ArrayList<Applicant> applicants = Applicant.getApplicants();
            model.put("deleteApplicant",deleteApplicant );
            model.put("applicants", applicants);
            return new ModelAndView(model, "applicant/index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
