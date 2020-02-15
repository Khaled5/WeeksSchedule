package com.khaled.weeksschedule.data.api;


import com.khaled.weeksschedule.data.model.WeekDay;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface API {

    @GET("1/")
    Observable<List<WeekDay>> getWeekDays();

}
