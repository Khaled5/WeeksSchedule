package com.khaled.weeksschedule.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.khaled.weeksschedule.data.model.WeekDay;

import java.util.List;
import io.reactivex.Observable;

@Dao
public interface WeekDayDao {

    @Query("SELECT * From week ORDER BY week_day ASC")
    Observable<List<WeekDay>> getDays();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<WeekDay> word);

    @Query("DELETE FROM week")
    void deleteAll();

}
