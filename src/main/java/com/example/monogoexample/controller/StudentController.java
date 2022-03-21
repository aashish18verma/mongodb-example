package com.example.monogoexample.controller;

import com.example.monogoexample.entity.Student;
import com.example.monogoexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/get-by-id/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/student-by-name/{name}")
    public List<Student> studentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/student-by-name-and-email")
    public List<Student> studentByNameAndEmail(@RequestParam String name,
                                               @RequestParam String email)
    {
        return studentService.studentbyNameAndEmail(name,email);
    }

    @GetMapping("/student-by-name-or-email")
    public List<Student> studentByNameOrEmail(@RequestParam String name,
                                               @RequestParam String email)
    {
        return studentService.studentbyNameOrEmail(name,email);
    }

    @GetMapping("/allWithPagination")
    public Page<Student> getAllWithPagination(@RequestParam int pageNo,
                                              @RequestParam int pageSize){
        return studentService.geetAllWithPagination(pageNo,pageSize);
    }

    @GetMapping("all-with-sorting")
    public List<Student> allWithSorting(){
        return studentService.allWithSorting();
    }

   /* @GetMapping("byDepartmentName")
    public List<Student> findByDepartmentName(@RequestParam String deptName){
        return studentService.byDepartmentName(deptName);
    }*/

   /* @GetMapping("/bySubjectName")
    public List<Student> byStudentName(@RequestParam String subName){
        return studentService.bySubjectName(subName);
    }
*/
    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email){
        return studentService.emailLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartWith(@RequestParam String name) {
        return studentService.nameStartsWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String deptId){
        return studentService.byDepartmentId(deptId);
    }

}
