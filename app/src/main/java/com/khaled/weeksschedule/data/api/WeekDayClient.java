package com.khaled.weeksschedule.data.api;


import com.khaled.weeksschedule.data.model.WeekDay;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeekDayClient {

    public static final String BASE_URL = "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/";
    private API postsInterface;

    private static WeekDayClient INSTANCE;

    public WeekDayClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        postsInterface = retrofit.create(API.class);
    }

    public static WeekDayClient getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new WeekDayClient();
        }
        return INSTANCE;
    }

    public Observable<List<WeekDay>> getWeekDays(){
        return postsInterface.getWeekDays();
    }

}
