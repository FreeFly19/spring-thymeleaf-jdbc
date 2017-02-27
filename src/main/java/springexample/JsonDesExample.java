package springexample;

import com.fasterxml.jackson.databind.type.ReferenceType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 27.02.2017.
 */
public class JsonDesExample {
    public static void main(String[] args) throws IOException {
        byte[] jsonBytes = Files.readAllBytes(new File("d:/students.txt").toPath());
        String json = new String(jsonBytes);

        Gson gson = new Gson();
        Type listOfStudents = new TypeToken<ArrayList<Student>>(){}.getType();
        List<Student> students = gson.fromJson(json, listOfStudents);

        for (Student student : students) {
            System.out.println(student.getAge());
            System.out.println(student.getName());
            System.out.println(student.getAvgMark());
        }
    }
}
