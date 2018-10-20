package com.example.edouble.planapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.edouble.planapplication.db.Event;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Home_Fragment extends Fragment{

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private List<Eventlist> eventlist=new ArrayList<>();

    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LitePal.getDatabase();
        eventlist.clear();
        initData();
//        initView();
        RecyclerView recyclerView=view.findViewById(R.id.eventslistview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        EventAdapter adapter=new EventAdapter(eventlist,getContext());
        recyclerView.setAdapter(adapter);


    }
    private void initData(){

        List<Event> events= LitePal.findAll(Event.class);

        int num=1;
        for (Event event:events) {
//Date date = new Date(System.currentTimeMillis());//获取当前日期
            Calendar calendar=Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            String nowdate = year+"-"+month+"-"+day; //当前日期

            String  date= event.getEventyear() + "-" + event.getEventmonth() + "-" + event.getEventday(); //第一个日期
//算两个日期间隔多少天
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date1 = format.parse(date);
                Date date2 = format.parse(nowdate);
                int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
                Eventlist list = new Eventlist(event.getEventname(), a, event.getEventcolor(), event.getEventyear() + "年" + event.getEventmonth() + "月" + event.getEventday() + "日", event.getEventnote(),event.getId());

                eventlist.add(list);
            }
            catch (Exception ex){

            }
        }

    }
}
