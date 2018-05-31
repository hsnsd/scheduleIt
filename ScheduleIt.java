/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hassan
 */
public class ScheduleIt {
    public static CourseContainer container;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        container = new CourseContainer();
        File text = new File("C:\\Users\\Hassan\\Desktop\\TT - Main Campus - Rev - 1.txt");
        String[] a;
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(text);
      
        //Reading each line of file using Scanner class
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            a = line.split("\t");
            container.addCourses(new Courses(a[0],a[1],a[2],a[3]));
        }
        //CourseContainer.printList(container.container);
        ArrayList<ArrayList<Courses>> allCourses = new ArrayList<ArrayList<Courses>>();
        
        
        //Getting all course names
        /*ArrayList<String> courseNames = CourseContainer.getCourseNames(container.container);
        for (String name: courseNames)
            System.out.println(name);*/
        
        //Getting all instructor names
        /*ArrayList<String> courseNamesIns = CourseContainer.getCourseInstructors(container.container);
        for (String name: courseNamesIns) {
            System.out.println(name);
        }*/
        
        
        /*allCourses.add((container.getAllCourse("Introduction to Differential Equation", "Maqsood Alam")));
        allCourses.add((container.getAllCourse("Development Economics", "TBA")));
        allCourses.add((container.getAllCourse("Regression Analysis & Experiment Design", "Zohaib Aziz")));
        allCourses.add((container.getAllCourse("Principles of Accounting", "Midhat Kidwai")));
        allCourses.add((container.getAllCourse("Financial Management", "Sana Tauseef")));
        allCourses.add((container.getAllCourse("Intermediate Macroeconomics", "Dr. Zulfiqar Hyder")));*/
        
        allCourses.add((container.getAllCourse("Physics-1")));
        
        allCourses.add((container.getAllCourse("Obj. Oriented Programming Techniques", "Farhan Siddiqui")));
        allCourses.add((container.getAllCourse("Obj. Oriented Programming Techniques", "Farhan Siddiqui")));
        allCourses.add((container.getAllCourse("Discrete Mathematics")));
        allCourses.add((container.getAllCourse("Introduction to Statistics", "Yaseen Minai")));
        allCourses.add((container.getAllCourse("Speech Communication", "Samina Wahid")));
        allCourses.add((container.getAllCourse("Calculus-2 and Solid Geometry", "Nazish Kanwal")));
        
        allCourses = CourseContainer.combineAll(allCourses);
        System.out.println(allCourses.size());
        allCourses = CourseContainer.checkAll(allCourses);
        System.out.println(allCourses.size());
        
        
                    for(int i=0; i<allCourses.size(); i++) {
                
                    CourseContainer.printList(allCourses.get(i));
                
        }
        
        /**Courses course1 = new Courses("a","ba","c","d");
        Courses course2 = new Courses("b","b","d","d");
        Courses course3 = new Courses("c","b","e","d");
        Courses course4 = new Courses("d","b","f","d");
        Courses course5 = new Courses("e","b","c","d");
        Courses course6 = new Courses("a","b","c","d");
        
        
        CourseContainer container = new CourseContainer();
        container.addCourses(course1);
        container.addCourses(course2);
        container.addCourses(course3);
        container.addCourses(course4);
        container.addCourses(course5);
        container.addCourses(course6);
        
        ArrayList<ArrayList<Courses>> allCourses = new ArrayList<ArrayList<Courses>>();
        allCourses.add((container.getAllCourse("a")));
        allCourses.add((container.getAllCourse("b")));
        allCourses.add((container.getAllCourse("c")));
        allCourses.add((container.getAllCourse("d")));
        allCourses.add((container.getAllCourse("e")));
        allCourses = CourseContainer.combineAll(allCourses);
        //System.out.println(allCourses.get(0).size());
        
        allCourses = CourseContainer.checkAll(allCourses);
        
            for(int i=0; i<allCourses.size(); i++) {
                
                    CourseContainer.printList(allCourses.get(i));
                    System.out.println(allCourses.get(i).get(i).getInstructor());
                
        }*/
    }
    
}
