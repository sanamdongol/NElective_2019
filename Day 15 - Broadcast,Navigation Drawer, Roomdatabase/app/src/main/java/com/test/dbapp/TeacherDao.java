package com.test.dbapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeacherDao {
    @Insert
    void addTeacher(Teacher teacher);

    @Query("select * from Teacher")
    List<Teacher> getAllTeachers();

    @Delete
    void deleteTeacher(Teacher teacher);

    @Update
    void updateTeacher(Teacher teacher);

}
