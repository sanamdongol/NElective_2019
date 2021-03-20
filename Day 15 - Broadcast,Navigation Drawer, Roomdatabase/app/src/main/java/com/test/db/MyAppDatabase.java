package com.test.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();

}