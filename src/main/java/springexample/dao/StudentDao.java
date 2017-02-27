package springexample.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import springexample.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> getAllStudents() throws IOException {
        byte[] jsonBytes = Files.readAllBytes(new File("d:/students.txt").toPath());
        String json = new String(jsonBytes);

        Gson gson = new Gson();
        Type listOfStudents = new TypeToken<ArrayList<Student>>(){}.getType();

        return gson.fromJson(json, listOfStudents);
    }

    public void saveStudent(Student student) throws IOException {
        List<Student> allStudents = getAllStudents();
        allStudents.add(student);

        String json = new Gson().toJson(allStudents);

        FileOutputStream fileOS = new FileOutputStream("D:/students.txt");
        fileOS.write(json.getBytes());
        fileOS.close();
    }
}
