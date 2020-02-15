package com.khaled.weeksschedule.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.khaled.weeksschedule.data.model.WeekDay;
import com.khaled.weeksschedule.view.adapter.WeekDaysAdapter;
import com.khaled.weeksschedule.viewmodel.WeekDaysViewModel;
import com.khaled.weeksschedule.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WeekDaysViewModel weekDaysViewModel;
    private RecyclerView mRecyclerView;
    private WeekDaysAdapter weekDaysAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        weekDaysViewModel = new ViewModelProvider(this)
                .get(WeekDaysViewModel.class);

        showProgress();

        weekDaysViewModel.getWeekDaysFromRepo();

        getData();

    }

    private void init(){
        mRecyclerView = findViewById(R.id.recycler);
        mProgressBar = findViewById(R.id.progress_bar);

        weekDaysAdapter = new WeekDaysAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(weekDaysAdapter);
    }

    private void getData(){
        weekDaysViewModel.listMutableLiveData.observe(this, new Observer<List<WeekDay>>() {
            @Override
            public void onChanged(List<WeekDay> weekDays) {
                hideProgress();
                weekDaysAdapter.setList(weekDays);
            }
        });
    }

    private void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
