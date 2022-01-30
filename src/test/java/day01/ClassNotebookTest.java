package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    List<Integer> grades=new ArrayList<>();
    Map<Student,List<Integer>> notebook=new TreeMap<>();

    @Test
    void testAddStudent(){
        notebook.put(new Student("John Doe",34),grades);
        notebook.put(new Student("Jack Doe",35),grades);
        notebook.put(new Student("Jane Doe",36),grades);
    }

}