  package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.TeacherDao;
import com.spring.orm.entities.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//to load configfile
    	 
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        TeacherDao teacherDao =context.getBean("teacherDao", TeacherDao.class);
        //Teacher teacher = new Teacher(123, "Rabin Budhathoki", "Kathmandu");
       // int r=teacherDao.insert(teacher);
        //System.out.println("done"+r );
        
        //to get input from user
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         boolean go=true;
         
        while(go) {
        System.out.println("Press 1 for add new teacher");
        System.out.println("Press 2 for display all teachers");
        System.out.println("Press 3 for get detail of single teacher");
        System.out.println("Press 4 for delete teacher");
        System.out.println("press 5 for update teacher");
        System.out.println("Press 6 for exit");
        
        try {
        	 int input=Integer.parseInt(br.readLine());
        // if(input==1) 
       // 	{
        		//add a new teacher
        //	}else if(input==2)
        //	{
        //		//display
       // 	}
        	 
        	 switch(input) {
        	 
        	 case 1:
        		 // add a teacher
        		 //taking inputs from users
        		 System.out.println("Enter user id:");
        		 int uId=Integer.parseInt(br.readLine());
        		 
        		 System.out.println("Enter user name :");
        		 String uName= br.readLine();
        		
        		 System.out.println("Enter user address");
        		 String uAddress= br.readLine();
        		 
        		 //creating teacher object and setting values
        		 Teacher t = new Teacher();
        		 t.setTeacherId(uId);
        		 t.setTeacherName(uName);
        		 t.setTeacherAddress(uAddress);
        		 
        		 //saving teacher object to database by calling insert of teacher dao
        		 int r=teacherDao.insert(t);
        		 System.out.println(r + " Teacher added");
        		 System.out.println("*************************");
        		 System.out.println();
        		 
        		 break;
        		 
        	 case 2:
        		 //display all teacher
        		  System.out.println("*****************");
        		 List<Teacher> allTeacher = teacherDao.getAllTeachers();
        		 for(Teacher tr:allTeacher) 
        		 {
        			System.out.println("Id :"+tr.getTeacherId());
        			System.out.println("Name :"+tr.getTeacherName());
        			System.out.println("Address :"+tr.getTeacherAddress());
        			System.out.println("___________________________");
        		 }
        		 System.out.println("*********************************");
        		 break;
        	 case 3:
        		 //get single teacher  data
        		 System.out.println("Enter user id:");
        		 int userId=Integer.parseInt(br.readLine());
        		 Teacher teacher=teacherDao.getTeacher(userId);
        		 System.out.println("Id :"+teacher.getTeacherId());
     			 System.out.println("Name :"+teacher.getTeacherName());
     			 System.out.println("Address :"+teacher.getTeacherAddress());
     			 System.out.println("___________________________");
        		 break;
        	 case 4:
        		 //delete teacher 
        		 System.out.println("Enter user id:");
        		 int id=Integer.parseInt(br.readLine());
        		 teacherDao.deleteTeacher(id);
        		 System.out.println("Teacher deleted..");
        		 break;
        	 case 5:
        		 // update teacher
        		 System.out.println("Enter user id which you want to update:");
        		     int tr=Integer.parseInt(br.readLine());
        		     
        		     System.out.println("Enter new teacher name");
        		     String c=br.readLine();
        		     
        		     System.out.println("Enter new teacher address:");
        		     String a1=br.readLine();
        		     
        		     Teacher  tr1= new Teacher();
        		     
        		     tr1.setTeacherName(c);
        		     tr1.setTeacherAddress(a1);
        		     tr1.setTeacherId(tr);
        		     teacherDao.updateTeacher(tr1);
        		     System.out.println("Teacher updated successfully!!");
        	
        		 break;
        	 case 6:
        		 //exit
        		 go=false;
        		 break;
        	 }
        	
        }catch(Exception e) {
        	System.out.println("Invalid  input try with another one !!!");
        	System.out.println(e.getMessage());
        }
    }
     
     System.out.println("Thankyou for using my application");
     System.out.println("See you soon !!!");
}
}
