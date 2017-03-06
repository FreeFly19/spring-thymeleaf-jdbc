package springexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springexample.Student;
import springexample.dao.StudentDao;

import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    private StudentDao studentDao = new StudentDao();

    @GetMapping("")
    public String homePage(Model model) throws IOException {
        List<Student> studentList = studentDao.getAllStudents();
        model.addAttribute("students", studentList);
        return "show-all-students";
    }

    @PostMapping("/create")
    public String createStudent(Student student) throws IOException {
        studentDao.saveStudent(student);
        return "redirect:/";
    }

}
