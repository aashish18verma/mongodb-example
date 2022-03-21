package com.example.monogoexample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    @Field(name="mail")
    private String email;

    @DBRef
    private Department department;

    @DBRef
    private List<Subject> subjects;

    @Transient
    private double percentage;

    public double getPercentage(){
        if(subjects!= null && subjects.size()>0){
         int total=0;
         for(Subject subject: subjects){
             total+=subject.getMarksObtained();
         }
         return total/ getSubjects().size();
        }
        return 0.00;
    }

    public Student(String id, Department department) {
        this.id = id;
        this.department = department;
    }

    @PersistenceConstructor
    public Student(String id, String name, String email, Department department, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }

}
