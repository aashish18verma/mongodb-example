package com.example.monogoexample.service;

import com.example.monogoexample.entity.Student;
import com.example.monogoexample.repository.DepartmentRepository;
import com.example.monogoexample.repository.StudentRepository;
import com.example.monogoexample.repository.SubjectRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
      if(student.getDepartment()!=null){
          departmentRepository.save(student.getDepartment());
      }
      if(student.getSubjects()!=null && student.getSubjects().size()>0){
          subjectRepository.saveAll(student.getSubjects());
      }

       return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
         studentRepository.deleteById(id);
         return "Student deleted";
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getByName(name);
    }

    public List<Student> studentbyNameAndEmail(String name, String email) {
        return  studentRepository.findByNameAndEmail(name,email);
    }

    public List<Student> studentbyNameOrEmail(String name, String email) {
        return  studentRepository.findByNameOrEmail(name,email);
    }

    public Page<Student> geetAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return studentRepository.findAll(pageable);
    }

    public List<Student> allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return studentRepository.findAll(sort);
    }

    /*public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }*/

    public List<Student> emailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
