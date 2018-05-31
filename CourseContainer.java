/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleit;
import java.util.*;
/**
 *
 * @author Hassan
 */
public class CourseContainer {
    public ArrayList<Courses> container;
    
    CourseContainer(){
        container = new ArrayList<>();
    }
    
    public void addCourses(Courses course){
        container.add(course);
    }
    
    public static ArrayList<String> getCourseNames(ArrayList<Courses> container){
        ArrayList<String> result = new ArrayList<>();
        String name;
        for (Courses  course : container) {
            name = course.getName();
            if (!result.contains(name))
                result.add(name);
        }
        java.util.Collections.sort(result);
        return result;
    }

    public static ArrayList<String> getCourseInstructors(ArrayList<Courses> container){
        ArrayList<String> result = new ArrayList<>();
        String name;
        for (Courses  course : container) {
            name = course.getInstructor();
            if (!result.contains(name))
                result.add(name);
        }
        java.util.Collections.sort(result);
        return result;
    }    
  
    public ArrayList<Courses> getAllCourse(String name){
        ArrayList<Courses> all = new ArrayList<>();
        for (Courses  course : container) {
            if (course.getName().equals(name)){
                all.add(course);
            }
        }
        return all;
    }
 
    public ArrayList<Courses> getAllCourse(String name, String instructor){
        ArrayList<Courses> all = new ArrayList<>();
        for (Courses  course : container) {
            if (course.getName().equals(name) && course.getInstructor().equals(instructor)){
                all.add(course);
            }
        }
        return all;
    }
    
    
    public static void printList(ArrayList<Courses> course){
        for (Courses  cours1 : course) {
            System.out.println(cours1.getName() + " " + cours1.getInstructor() + " " + cours1.getDay() + " " + cours1.getTime());
        }
    }
    
    public static String printListToString(ArrayList<Courses> course){
        String result="";
        String temp = "";
        for (Courses  cours1 : course) {
            
            temp = result + cours1.getName() + " " + cours1.getInstructor() + " " + cours1.getDay() + " " + cours1.getTime();
            result = temp + "\r\n";
        }            
        return result;
    }
        /*public static ArrayList<ArrayList<Courses>> combineAll(ArrayList<ArrayList<Courses>> allCourses){ //exactly 9 courses
        ArrayList<ArrayList<Courses>> timetable = new ArrayList<>();
        for(Courses course1 : allCourses.get(0)) {
            for(Courses course2 : allCourses.get(1)) {
                for(Courses course3 : allCourses.get(2)) {
                    for(Courses course4 : allCourses.get(3)) {
                        for(Courses course5 : allCourses.get(4)) {
                            for(Courses course6 : allCourses.get(5)) {
                                for(Courses course7 : allCourses.get(6)) {
                                    for(Courses course8 : allCourses.get(7)) {
                                        for(Courses course9 : allCourses.get(8)) {
                                    
                    ArrayList<Courses> time = new ArrayList<Courses>();
                    time.add(course1);
                    time.add(course2);
                    time.add(course3);
                    time.add(course4);
                    time.add(course5);
                    time.add(course6);
                    time.add(course7);
                    time.add(course8);
                    time.add(course9);
                    timetable.add(time);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return timetable;
    }*/
    public static ArrayList<ArrayList<Courses>> combineAll(ArrayList<ArrayList<Courses>> allCourses){ //exactly 7 courses default
        ArrayList<ArrayList<Courses>> timetable = new ArrayList<>();
        for(Courses course1 : allCourses.get(0)) {
            for(Courses course2 : allCourses.get(1)) {
                for(Courses course3 : allCourses.get(2)) {
                    for(Courses course4 : allCourses.get(3)) {
                        for(Courses course5 : allCourses.get(4)) {
                            for(Courses course6 : allCourses.get(5)) {
                                for(Courses course7 : allCourses.get(6)) {
                    ArrayList<Courses> time = new ArrayList<Courses>();
                    time.add(course1);
                    time.add(course2);
                    time.add(course3);
                    time.add(course4);
                    time.add(course5);
                    time.add(course6);
                    time.add(course7);
                    timetable.add(time);
                                }
                            }
                        }
                    }
                }
            }
        }
        return timetable;
    }
    public boolean compare(Courses a, Courses b){
        boolean result =false;
        if (a.getClass().equals(b.getClass()) && a.getInstructor().equals(b.getInstructor()) && 
                a.getTime().equals(b.getTime()) && a.getDay().equals(b.getDay()))
            result = true;
        
        return result;
    }
    
    public static void sortByCourseTime(ArrayList<Courses> course){
        String x,y,a,b;
        Courses temp;
        for(int i=0; i < course.size(); i++){  
            for(int j=1; j < course.size() - i ; j++){
                x = course.get(j-1).getName();
                y = course.get(j).getName();
                if (x.charAt(0)>y.charAt(0)){
                    //swap
                    temp = course.get(j-1);
                    course.set(j-1, course.get(j));
                    course.set(j, temp);
                }
                if (x.charAt(0)==y.charAt(0)){
                    a = (course.get(j-1).getTime().split(":"))[0];
                    b = (course.get(j).getTime().split(":"))[0];
                    if (Integer.parseInt(a)>Integer.parseInt(b)){
                        //swap
                        temp = course.get(j-1);
                        course.set(j-1, course.get(j));
                        course.set(j, temp);
                    }
                }
            }
        }
    }
    
    public static void remove(ArrayList<Courses> courses, Courses a){
        for (Courses course: courses)
            if (course.getName().equals(a.getName()) && course.getTime().equals(a.getTime()))
                courses.remove(a);
    }
    public static ArrayList<ArrayList<Courses>> checkAll(ArrayList<ArrayList<Courses>> allCourses){
        ArrayList<ArrayList<Courses>> result = new ArrayList<>(allCourses);
        
        ArrayList<Integer> toRemove = new ArrayList<>();
        boolean toBreak = false;
        for (int k=0; k<allCourses.size(); k++) {
            toBreak = false;
            for (int i=0; i<allCourses.get(k).size() && !toBreak;i++){
                for (int j=allCourses.get(k).size()-1; j>i; j--){
                    if (allCourses.get(k).get(i).getDay().equals(allCourses.get(k).get(j).getDay()) && allCourses.get(k).get(i).getTime().equals(allCourses.get(k).get(j).getTime())){
                        result.remove(allCourses.get(k));
                        toBreak = true;
                        
                    }
                        
                }
            }
        }
        
        for (ArrayList<Courses> courses: result)
            sortByCourseTime(courses);
        
        ArrayList<ArrayList<Courses>> finalResult = new ArrayList<>(result);
        
        //for 9
        /*for (int k=0; k<result.size()-1; k++) {
            for (int i=1; i<result.get(k).size();i++){
                if (result.get(k).get(0).equals(result.get(i).get(0)) && result.get(k).get(1).equals(result.get(i).get(1))
                        && result.get(k).get(2).equals(result.get(i).get(2)) && result.get(k).get(3).equals(result.get(i).get(3))
                        && result.get(k).get(4).equals(result.get(i).get(4)) && result.get(k).get(5).equals(result.get(i).get(5))
                        && result.get(k).get(6).equals(result.get(i).get(6)) && result.get(k).get(7).equals(result.get(i).get(7))
                        && result.get(k).get(8).equals(result.get(i).get(8))){
                    System.out.println(finalResult.size());
                    finalResult.remove(result.get(k));
                    System.out.println(finalResult.size());
                    System.out.println("REMOVED");
                    break;
                    
                }
                    
            }
        }*/
        //for 7 default
        for (int k=0; k<result.size()-1; k++) {
            for (int i=1; i<result.get(k).size();i++){
                if (result.get(k).get(0).equals(result.get(i).get(0)) && result.get(k).get(1).equals(result.get(i).get(1))
                        && result.get(k).get(2).equals(result.get(i).get(2)) && result.get(k).get(3).equals(result.get(i).get(3))
                        && result.get(k).get(4).equals(result.get(i).get(4)) && result.get(k).get(5).equals(result.get(i).get(5))
                        && result.get(k).get(6).equals(result.get(i).get(6))){
                    finalResult.remove(result.get(k));
                    break;
                    
                }
                    
            }
        }
        //ArrayList<ArrayList<Courses>> finalresult = new ArrayList<>(finalResult);
            
        Set<ArrayList<Courses>> mySet = new HashSet <ArrayList<Courses>>(finalResult);
        mySet.addAll(finalResult);
        finalResult.clear();
        finalResult.addAll(mySet);
        /*for (int k=0; k<finalResult.size()-1; k++) {
            for (int i=1; i<finalResult.get(k).size();i++){
                if (finalResult.get(k).get(0).equals(finalResult.get(i).get(0)) && finalResult.get(k).get(1).equals(finalResult.get(i).get(1))
                        && finalResult.get(k).get(2).equals(finalResult.get(i).get(2)) && finalResult.get(k).get(3).equals(finalResult.get(i).get(3))
                        && finalResult.get(k).get(4).equals(finalResult.get(i).get(4)) && finalResult.get(k).get(5).equals(finalResult.get(i).get(5))
                        && finalResult.get(k).get(6).equals(finalResult.get(i).get(6))){
                    finalresult.remove(finalResult.get(k));
                    break;
                    
                }
                    
            }
        } */  
        /*ArrayList<ArrayList<Courses>> finalResult = new ArrayList<>(result);
        boolean contains = false;
        for (int k=0; k<result.size()-1; k++) {
            for (int i=0; i<result.get(k).size() && !contains;i++){
                for (int l=0; l<result.size()-1; l++) {
                    if (result.get(k).contains(result.get(k+1).get(i)))
                        contains = true;
                    else
                        contains = false;
                }
            }
        }*/
        
    return finalResult;
    
    }
}

    

        
    

    
    
