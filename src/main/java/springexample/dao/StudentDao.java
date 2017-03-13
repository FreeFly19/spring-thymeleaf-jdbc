package springexample.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import springexample.Student;

import java.util.List;

public class StudentDao {
    private JdbcTemplate jdbcTemplate;

    public StudentDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1/java_course");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Student> getAllStudents() {
        List<Student> students = jdbcTemplate
                .query("select * from students",
                        new BeanPropertyRowMapper(Student.class));

        return students;
    }

    public void saveStudent(Student student) {
        jdbcTemplate.update(
                "INSERT INTO students(`name`, `age`) VALUES (?, ?)",
                    student.getName(), student.getAge()
        );
    }
}
