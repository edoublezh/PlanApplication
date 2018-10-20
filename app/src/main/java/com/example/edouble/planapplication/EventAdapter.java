package com.example.edouble.planapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edouble.planapplication.db.Event;

import org.litepal.LitePal;
import org.litepal.exceptions.DataSupportException;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{

    private List<Eventlist> mEventlist;

    private Resources mResource;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder{

        View eventView;
        TextView eventlistname;
        TextView eventlistdate;
        TextView eventlistleftday;
        TextView eventlistnote;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventView=itemView;
            eventlistname=itemView.findViewById(R.id.eventitemname);
            eventlistdate=itemView.findViewById(R.id.eventitemdate);
            eventlistleftday=itemView.findViewById(R.id.eventitemleftday);
            eventlistnote=itemView.findViewById(R.id.eventitemnote);
        }
    }
    public EventAdapter(List<Eventlist> eventList,Context context){
        mEventlist=eventList;
        mContext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.event_item,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Eventlist eventlist=mEventlist.get(i);
        final long a=eventlist.getId();
        //设置单元格格式
        //mResource = (Resources)getBaseContext().getResources();
        //mContext
        switch (eventlist.getEventlistcolor()){
            case 0:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.darkorchid));
                break;
            case 1:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.seagreen));
                break;
            case 2:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.royalblue));
                break;
            case 3:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.gold));
                break;
            case 4:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.saddlebrown));
                break;
            case 5:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.darkred));
                break;
            case 6:
                viewHolder.eventlistname.setTextColor(mContext.getResources().getColor(R.color.darkorange));
                break;
        }

        viewHolder.eventlistname.setText(eventlist.getEventlistname());
        viewHolder.eventlistdate.setText(eventlist.getEventlistdate());
        viewHolder.eventlistleftday.setText(eventlist.getLeftday()+"");
        viewHolder.eventlistnote.setText(eventlist.getEventlistnote());

        //viewHolder.itemView.setTag(i);
        viewHolder.eventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                //显示点击了什么
//                int position=holder.getAdapterPosition();
//                Eventlist eventlist=mEventlist.get(position);
//                Toast.makeText(v.getContext(),"点击了"+eventlist.getEventlistname(),Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu=new PopupMenu(mContext,v);
                popupMenu.getMenuInflater().inflate(R.menu.eventselect,popupMenu.getMenu());
                popupMenu.show();
                //popMenu的点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.editevent:
                                //Toast.makeText(mContext,"1",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(mContext,EditeventActivity.class);
                                ((Activity)mContext).startActivity(intent);
                                break;
                            case R.id.deleteevent:
                                //getState((Integer) v.getTag());
                                LitePal.delete(Event.class,a);
                                mEventlist.remove(eventlist);
                                notifyDataSetChanged();
                                break;
                        }
                        return true;

                    }
                });

            }//设置点击事件
        });
    }

    @Override
    public int getItemCount() {
        return mEventlist.size();
    }
}
