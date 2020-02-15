package com.khaled.weeksschedule.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.khaled.weeksschedule.data.model.WeekDay;
import com.khaled.weeksschedule.R;

import java.util.ArrayList;
import java.util.List;

public class WeekDaysAdapter extends RecyclerView.Adapter<WeekDaysAdapter.WeekDaysViewHolder> {

    private List<WeekDay> weekDays = new ArrayList<>();

    @NonNull
    @Override
    public WeekDaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WeekDaysViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.week_day_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeekDaysViewHolder holder, int position) {
        holder.tvName.setText(weekDays.get(position).getName());
        holder.tvTeacher.setText(weekDays.get(position).getTeacher());
        holder.tvPlace.setText(weekDays.get(position).getPlace());
        holder.tvDesc.setText(weekDays.get(position).getDescription());
        holder.tvWeekDay.setText(weekDays.get(position).getWeekDay()+"");
        holder.tvStartTime.setText(weekDays.get(position).getStartTime());
        holder.tvEndTime.setText(weekDays.get(position).getEndTime());


    }

    @Override
    public int getItemCount() {
        return weekDays.size();
    }

    public void setList(List<WeekDay> weekDays) {
        this.weekDays = weekDays;
        notifyDataSetChanged();
    }

    public class WeekDaysViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvTeacher,tvPlace,tvDesc,tvWeekDay,tvStartTime,tvEndTime;

        public WeekDaysViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            tvTeacher = itemView.findViewById(R.id.teacher);
            tvPlace = itemView.findViewById(R.id.place);
            tvDesc = itemView.findViewById(R.id.description);
            tvWeekDay = itemView.findViewById(R.id.week_day);
            tvStartTime = itemView.findViewById(R.id.start_time);
            tvEndTime = itemView.findViewById(R.id.end_time);

        }
    }
}
