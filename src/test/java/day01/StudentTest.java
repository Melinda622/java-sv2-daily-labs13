package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createStudent(){
        Student student=new Student("John Doe",121);
        assertEquals("John Doe",student.getName());
        assertEquals(121,student.getId());
    }
}