package springexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 27.02.2017.
 */
public class JsonExample {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        Student student = new Student();
        student.setAge(22);
        student.setName("Denis");
        student.setAvgMark(95);

        Student student2 = new Student();
        student2.setAge(35);
        student2.setName("Sergey");
        student2.setAvgMark(100);

        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(student2);
        String json = gson.toJson(students);

        FileOutputStream fileOS = new FileOutputStream("D:/students.txt");
        fileOS.write(json.getBytes());
        fileOS.close();
    }


}
