package springexample.controller;

import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public String homePage() throws IOException {
        List<Student> students = studentDao.getAllStudents();

        String html = "";
        for (Student student : students) {
            html += student.getAge() + "<br>";
            html += student.getName() + "<br>";
            html += student.getAvgMark() + "<br><br>";
        }

        html += "<form action=\"/create\" method=\"post\">" +
                "<input name=\"age\"><br>" +
                "<input name=\"name\"><br>" +
                "<input name=\"avgMark\"><br>" +
                "<button>Send</button>" +
                "</form>";
        return html;
    }

    @PostMapping("/create")
    public String createStudent(Student student) throws IOException {
        studentDao.saveStudent(student);
        return "redirect:/";
    }

}
