package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    public void addStudent(Student student);

    @Query("select * from Student")
    List<Student> getAllStudent();

    @Delete
    public void deleteStudent(Student student);

    @Update
    public void updateStudent(Student student);


}
