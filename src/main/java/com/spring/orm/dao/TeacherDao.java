package com.spring.orm.dao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Teacher;

public class TeacherDao {
	
	//to declare HibernateTemplate
	private HibernateTemplate  hibernateTemplate;
	
	//save teacher
   @Transactional
	public int insert(Teacher teacher) {
	//insert
  Integer i =(Integer) this.hibernateTemplate.save(teacher);
	return i;
}
   //get the single data(object)
   
   public Teacher getTeacher(int teacherId) 
   {
	   Teacher teacher =
			   this.hibernateTemplate.get(Teacher.class, teacherId );
	   return teacher;
   }
   
   //get all teacher(all rows)
   public List<Teacher> getAllTeachers()
   {
	   List<Teacher> teachers=this.hibernateTemplate.loadAll(Teacher.class);
	   return teachers;
   }
   
   //deleting the data
   @Transactional
   public void deleteTeacher(int teacherId) 
   {
	   Teacher teacher=this.hibernateTemplate.get(Teacher.class,teacherId);
	   this.hibernateTemplate.delete(teacher);
	   
   }
   
   //updating data...
   @Transactional
   public void updateTeacher(Teacher teacher) 
   {
	  this.hibernateTemplate.update(teacher); 
   }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
