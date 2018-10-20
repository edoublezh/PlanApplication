package com.example.edouble.planapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import org.litepal.LitePal;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private Home_Fragment hfFragment;
    private Subject_Fragment sfFragment;
    private Plan_Fragment pfFragment;
    private Event_Fragment efFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);

        toolbar.setTitle("主页");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int menuItemId=menuItem.getItemId();
                if (menuItemId==R.id.add){
                    switch (menuItem.getItemId()){
                        case R.id.add:
                            final String[] items=new String[]{"课程","计划","事件"};
                            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("选择增加内容");
                            builder.setItems(items, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    Toast.makeText(MainActivity.this,"你选择了"+items[i],Toast.LENGTH_LONG).show();
                                    switch (i){
                                        case 0:
                                            Intent intentlesson=new Intent(MainActivity.this,AddclassesActivity.class);
                                            startActivity(intentlesson);
                                            break;
                                        case 1:
                                            Intent intentplan=new Intent(MainActivity.this,AddplansActivity.class);
                                            startActivity(intentplan);
                                            break;
                                        case 2:
                                            Intent intentevent=new Intent(MainActivity.this,AddeventsActivity.class);
                                            startActivity(intentevent);
                                            break;
                                        default:
                                            break;
                                    }

                                }
                            });
                            builder.create().show();
                            break;
                        default:
                    }
                }
                return true;
            }
        });


        //实例化Fragment
        hfFragment=new Home_Fragment();
        sfFragment=new Subject_Fragment();
        pfFragment=new Plan_Fragment();
        efFragment=new Event_Fragment();


        //把Subject_Fragment添加到Activity中，记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,hfFragment).commitAllowingStateLoss();

        //BottomNavigation
        mOnNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,hfFragment).commitAllowingStateLoss();
                        return true;
                    case R.id.navigation_class:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,sfFragment).commitAllowingStateLoss();
                        return true;
                    case R.id.navigation_plan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,pfFragment).commitAllowingStateLoss();
                        return true;
                    case R.id.navigation_event:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,efFragment).commitAllowingStateLoss();
                        return true;
                }
                return false;
            }
        };

        BottomNavigationView navigation = findViewById(R.id.navigation);
    //        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

//    @Override
//    protected void onStart() {
//
//        super.onStart();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titleitem,menu);
        return true;
    }
}


