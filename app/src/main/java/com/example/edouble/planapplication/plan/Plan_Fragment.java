package com.example.edouble.planapplication.plan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.edouble.planapplication.R;
import com.example.edouble.planapplication.db.Plan;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class Plan_Fragment extends Fragment {
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private List<Planitem> planitem=new ArrayList<>();

    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.plan_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LitePal.getDatabase();
        planitem.clear();
        initData();

        RecyclerView recyclerView=view.findViewById(R.id.planview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        PlanAdapter adapter=new PlanAdapter(planitem,getContext());
        recyclerView.setAdapter(adapter);


    }
    private void initData(){
        List<Plan> plans=LitePal.findAll(Plan.class);

        for (Plan plan:plans){
            String planbegindate=plan.getPlanbeginyear()+"年"+plan.getPlanbeginmonth()+"月"+plan.getPlanbeginday()+"日";
            String planbegintime=String.format("%02d:%02d",plan.getPlanbeginhour(),plan.getPlanbeginminute());
            String planenddate=plan.getPlanendyear()+"年"+plan.getPlanendmonth()+"月"+plan.getPlanendday()+"日";
            String planendtime=String.format("%02d:%02d",plan.getPlanendhour(),plan.getPlanendminute());

            Planitem list=new Planitem(plan.getPlanname(),planbegindate,planbegintime,planenddate,planendtime,plan.getPlancolor(),plan.getPlanfrequ(),plan.getId(),plan.getPlannote());
            planitem.add(list);
        }
    }
}
