package com.khaled.weeksschedule.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.khaled.weeksschedule.data.Repository;
import com.khaled.weeksschedule.data.model.WeekDay;
import com.khaled.weeksschedule.data.api.WeekDayClient;
import com.khaled.weeksschedule.data.local.WeekDayDB;
import com.khaled.weeksschedule.data.local.WeekDayDao;

import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.khaled.weeksschedule.App.isNetworkAvailable;

public class WeekDaysViewModel extends AndroidViewModel {

    public MutableLiveData<List<WeekDay>> listMutableLiveData = new MutableLiveData<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private Repository repository;

    public WeekDaysViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository(application,compositeDisposable);
        repository.getWeekDays();
    }


    public void getWeekDaysFromRepo(){
        listMutableLiveData = repository.data;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
