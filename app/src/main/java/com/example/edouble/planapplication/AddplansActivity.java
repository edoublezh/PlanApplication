package com.example.edouble.planapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class AddplansActivity extends AppCompatActivity {

    private TextView planname;
    private TextView planbegindate;
    private TextView planbegintime;
    private TextView planenddate;
    private TextView planendtime;

    private Spinner plancolor;
    private Spinner planfre;

    private TextView plannote;

    private int colornum;
    private int frenum;//频率

    //现在时间
    private int nowyear;
    private int nowmonth;
    private int nowday;
    //计划开始时间
    private int beginyear;
    private int beginmonth;
    private int beginday;
    //计划结束时间
    private int endyear;
    private int endmonth;
    private int endday;
    //
    private int newyear;
    private int newmonth;
    private int newday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplans);

        //Toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("添加计划");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        planname=findViewById(R.id.planname);
        planbegindate=findViewById(R.id.planbegindate);
        planbegintime=findViewById(R.id.planbegintime);
        planenddate=findViewById(R.id.planenddate);
        planendtime=findViewById(R.id.planendtime);
        plannote=findViewById(R.id.plannote);
        plancolor=findViewById(R.id.plancolor);
        planfre=findViewById(R.id.planfre);

        //spinner设置
        //颜色
        SpinnerAdapter coloradapter=null;
        coloradapter= ArrayAdapter.createFromResource(this,R.array.eventcolors,android.R.layout.simple_spinner_dropdown_item);
        plancolor.setAdapter(coloradapter);
        //频率
        SpinnerAdapter freadapter=null;
        freadapter=ArrayAdapter.createFromResource(this,R.array.planfre,android.R.layout.simple_spinner_dropdown_item);
        planfre.setAdapter(freadapter);

        //颜色选择
        plancolor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView textView=(TextView)view;
                //Toast.makeText(AddeventsActivity.this,((TextView) view).getText().toString(),Toast.LENGTH_SHORT).show();

                switch (textView.getText().toString()){
                    case "紫色":
                        colornum=0;
                        break;
                    case "绿色":
                        colornum=1;
                        break;
                    case "蓝色":
                        colornum=2;
                        break;
                    case "黄色":
                        colornum=3;
                        break;
                    case "褐色":
                        colornum=4;
                        break;
                    case "红色":
                        colornum=5;
                        break;
                    case "橙色":
                        colornum=6;
                        break;

                }//颜色判断
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //频率选择
        planfre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //TextView textView=(TextView)view;
                //Toast.makeText(AddeventsActivity.this,((TextView) view).getText().toString(),Toast.LENGTH_SHORT).show();

                switch (view.getId()){
                    case 0:
                        frenum=0;
                        break;
                    case 1:
                        frenum=1;
                        break;
                    case 2:
                        frenum=2;
                        break;
                    case 3:
                        frenum=3;
                        break;
                    case 4:
                        frenum=4;
                        break;
                    case 5:
                        frenum=5;
                        break;
                    case 6:
                        frenum=6;
                        break;

                }//颜色判断
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

         final Calendar calendar=Calendar.getInstance();
         //获取现在时间
         nowyear=calendar.get(Calendar.YEAR);
         nowmonth=calendar.get(Calendar.MONTH)+1;
         nowday=calendar.get(Calendar.DAY_OF_MONTH);

         planbegindate.setText(String.format("%d年%d月%d日",nowyear,nowmonth,nowday));
         planbegindate.setInputType(InputType.TYPE_NULL);
         planbegindate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
             @Override
             public void onFocusChange(View v, boolean hasFocus) {
                 if (hasFocus){
                     showbeginDatePickerDialog();
                 }
             }
         });
         planbegindate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showbeginDatePickerDialog();

                 //beginyear=newyear;
                 //beginmonth=newmonth;
                 //beginday=newday;
             }
         });

         planenddate.setText(String.format("%d年%d月%d日",nowyear,nowmonth,nowday));
         planenddate.setInputType(InputType.TYPE_NULL);
         planenddate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    showendDatePickerDialog();
                }
            }
        });
        planenddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showendDatePickerDialog();

                //endyear=newyear;
                //endmonth=newmonth;
                //endday=newday;
            }
        });





    }

    private void showbeginDatePickerDialog(){
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub

                beginyear=year;
                beginmonth=monthOfYear+1;
                beginday=dayOfMonth;
                planbegindate.setText(beginyear+"年"+beginmonth+"月"+beginday+"日");
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void showendDatePickerDialog(){
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub

                endyear=year;
                endmonth=monthOfYear+1;
                endday=dayOfMonth;
                planenddate.setText(endyear+"年"+endmonth+"月"+endday+"日");
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }
}
