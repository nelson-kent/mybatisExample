package test;

import main.java.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class StudentTest {
    /**
     *
     */
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(0);
        student.setName("nk");
        student.setBranch("age4");
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("oracelMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("no config file found !");
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("Student.insert", student);

    }
}
