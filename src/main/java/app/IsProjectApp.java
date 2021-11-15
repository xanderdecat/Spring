package app;

import model.Student;
import model.University;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class IsProjectApp {

    public static void main(String[] args) {
        SpringApplication.run(IsProjectApp.class, args);
    }

    @GetMapping("/index")
    public String showStudenten(Model model) {
        University university = new University();
        model.addAttribute("studenten", university.getStudents());
        return "index";
    }

    @GetMapping("/toevoegenStudent")
    public String studentToevoegen(Model model) {

        University university = new University();
        model.addAttribute("student", new Student());
        return "toevoegenstudent";
    }

    @PostMapping("/toevoegenStudent")
    public String studentToevoegenSubmit(@ModelAttribute Student student, Model model, RedirectAttributes redirAttrs) {
        University university = new University();
        university.addStudent(student);
        redirAttrs.addFlashAttribute("success", "Student werd toegevoegd");
        model.addAttribute("studenten", university.getStudents());
        return "redirect:/index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        University university = new University();
        return "test";
    }


}
