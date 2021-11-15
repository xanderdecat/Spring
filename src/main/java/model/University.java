/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import db.StudentDAO;

import java.util.ArrayList;

/**
 *
 * @author fgailly
 */
public class University {

  private static University university = new University();

  public ArrayList<Student> getStudents() {
    StudentDAO studentDAO = new StudentDAO();
    return studentDAO.getStudents();
  }
  
  public void addStudent(Student student) {
    StudentDAO studentDAO = new StudentDAO();
    studentDAO.save(student);

  }

  public void deleteStudent(Student student){
    System.out.println("DELETE STUDENT" + student.getName());
    StudentDAO studentDAO = new StudentDAO();
    studentDAO.deleteStudent(student);

  }
  
  
  
}
