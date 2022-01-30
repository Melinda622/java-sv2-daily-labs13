package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNotebook {

    Map<Student,List<Integer>> notebook=new TreeMap<>();

    public ClassNotebook(Map<Student, List<Integer>> notebook) {
        this.notebook = notebook;
    }

    public void addStudent(Student student){
        List<Integer> grades=new ArrayList<>();
        notebook.put(student,grades);
    }

    public void addMark(int id, int mark){
        for (Map.Entry<Student,List<Integer> >actual: notebook.entrySet()){
            if(actual.getKey().getId()==id){
                List<Integer> grades=new ArrayList<>();
                grades.add(mark);
                notebook.put(actual.getKey(),grades);
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> grades=new ArrayList<>();
        Map<Student,List<Integer>>notebook=new TreeMap<>();
        notebook.put(new Student("John",34),grades);
        notebook.put(new Student("Jack",35),grades);
        notebook.put(new Student("Jane",36),grades);

        ClassNotebook classNotebook=new ClassNotebook(notebook);

        System.out.println(classNotebook.notebook);
        classNotebook.addMark(34,5);
        System.out.println(classNotebook.notebook);


    }
}
