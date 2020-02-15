package com.khaled.weeksschedule.data;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.khaled.weeksschedule.data.api.WeekDayClient;
import com.khaled.weeksschedule.data.local.WeekDayDB;
import com.khaled.weeksschedule.data.local.WeekDayDao;
import com.khaled.weeksschedule.data.model.WeekDay;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.khaled.weeksschedule.App.isNetworkAvailable;

public class Repository {

    private WeekDayDao dao;

    private CompositeDisposable compositeDisposable;

    private Application application;

    public MutableLiveData<List<WeekDay>> data = new MutableLiveData<>();

    public Repository(Application application, CompositeDisposable compositeDisposable) {
        this.application = application;

        this.compositeDisposable = compositeDisposable;

        WeekDayDB db = WeekDayDB.getDatabase(application);
        dao = db.weekDayDao();
    }

    public void getWeekDays(){

        if (isNetworkAvailable(application)){

            fetchFromAPI();

        }else {

            fetchFromLocalDB();

        }
    }



    /* fetchFromAPI() fetches the data from API,  if the device han network:
     * First: call getWeekDaysFromRepo() to fetch the data from the API
      * Second: call deleteAll() to delete the data from Room
      * Third: call insert() which takes List<WeekDays> and stores it in Room
      * Fourth: fetchFromLocalDB() get the data from Room and store in MutableLiveData<List<WeekDay>>*/

    private void fetchFromAPI() {
        compositeDisposable.add(WeekDayClient.getINSTANCE().getWeekDays().subscribeOn(Schedulers.io())
                .doOnNext(o -> dao.deleteAll()).doOnNext(list -> dao.insert(list))
                .observeOn(AndroidSchedulers.mainThread()).subscribe(list ->
                        fetchFromLocalDB()
                ));
    }

    /* fetchFromLocalDB() get the data from Room and store in MutableLiveData<List<WeekDay>> */
    private void fetchFromLocalDB() {
        compositeDisposable.add(dao.getDays()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> data.setValue(s)));
    }


}