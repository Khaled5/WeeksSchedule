package com.khaled.weeksschedule.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.khaled.weeksschedule.data.model.WeekDay;

@Database(entities = {WeekDay.class},version = 2,exportSchema = false)
public abstract class WeekDayDB extends RoomDatabase {

    public abstract WeekDayDao weekDayDao();

    private static volatile WeekDayDB INSTANCE;


    public static WeekDayDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WeekDayDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeekDayDB.class,"week")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
