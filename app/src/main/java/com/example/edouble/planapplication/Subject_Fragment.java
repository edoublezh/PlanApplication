package com.example.edouble.planapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuangfei.timetable.TimetableView;
import com.zhuangfei.timetable.view.WeekView;

public class Subject_Fragment extends Fragment {

    private TextView mTextview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.subject_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TimetableView mTimetableView;
        WeekView mWeekView;

//        mTextview=view.findViewById(R.id.testword);
    }
}
