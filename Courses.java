/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleit;

/**
 *
 * @author Hassan
 */
public class Courses {
    private String name;
    private String instructor;
    private String time;
    private String day;
    
    Courses(String name, String instructor, String time, String day){
        this.name = name;
        this.instructor = instructor;
        this.time = time;
        this.day = day;
    }
    
    public String getDay (){
        return day;
    }
    
    public String getTime (){
        return time;
    }
    
    public String getName (){
        return name;
    }
    
    public void setName(){
        this.name = null;
    }
    
    public String getInstructor (){
        return instructor;
    }
    
    public boolean equals(Courses b){
        boolean result = false;
        if (this.getClass().equals(b.getClass()) && this.getTime().equals(b.getTime()) &&
                this.getInstructor().equals(b.getInstructor()) && this.getDay().equals(b.getDay()))
            result = true;
        
        return result;
    }
}
        
