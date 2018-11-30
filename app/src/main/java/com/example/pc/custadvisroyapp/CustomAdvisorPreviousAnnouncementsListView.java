package com.example.pc.custadvisroyapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdvisorPreviousAnnouncementsListView extends ArrayAdapter<String> {

    private String[] date;
    private String[] title;
    private String[] description;


    private Activity context;
    Bitmap bitmap;

    public CustomAdvisorPreviousAnnouncementsListView(Activity context,String[] date,String[] title,String[] description) {
        super(context, R.layout.layoutadvisorpreviousannouncements,title);
        this.context=context;
        this.date=date;
        this.title=title;
        this.description=description;

    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        CustomAdvisorPreviousAnnouncementsListView.ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layoutstudentannouncements,null,true);
            viewHolder=new CustomAdvisorPreviousAnnouncementsListView.ViewHolder(r);
            r.setTag(viewHolder);




        }
        else {
            viewHolder=(CustomAdvisorPreviousAnnouncementsListView.ViewHolder)r.getTag();


        }

        //      viewHolder.tvw1.setText(date[position]);
        viewHolder.tvw2.setText(title[position]);
        viewHolder.tvw3.setText(description[position]);







        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;



        ViewHolder(View v){
            //      tvw1=(TextView)v.findViewById(R.id.tvDate);
            tvw2=(TextView)v.findViewById(R.id.tvTitle);
            tvw3=(TextView)v.findViewById(R.id.tvDescription);


        }

    }



}
