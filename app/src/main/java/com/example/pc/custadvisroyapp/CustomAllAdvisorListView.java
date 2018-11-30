package com.example.pc.custadvisroyapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAllAdvisorListView extends ArrayAdapter<String> {

    private String[] AdvisorName;
    private String[] NoOfStudents;
    private String[] FirstStudent;
    private String[] LastStudent;

    private Activity context;
    Bitmap bitmap;

    public CustomAllAdvisorListView(Activity context,String[] AdvisorName,String[] NoOfStudents,String[] FirstStudent,String[] LastStudent) {
        super(context, R.layout.layoutalladvisors,AdvisorName);
        this.context=context;
        this.AdvisorName=AdvisorName;
        this.NoOfStudents=NoOfStudents;
        this.FirstStudent=FirstStudent;
        this.LastStudent=LastStudent;

    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        CustomAllAdvisorListView.ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layoutalladvisors,null,true);
            viewHolder=new CustomAllAdvisorListView.ViewHolder(r);
            r.setTag(viewHolder);


            }

        else {
            viewHolder=(CustomAllAdvisorListView.ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(AdvisorName[position]);
        viewHolder.tvw2.setText(NoOfStudents[position]);
        viewHolder.tvw3.setText(FirstStudent[position]);
        viewHolder.tvw4.setText(LastStudent[position]);





        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;


        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvAdvisorName);
            tvw2=(TextView)v.findViewById(R.id.tvNoOfStudents);
            tvw3=(TextView)v.findViewById(R.id.tvFirstStudent);
            tvw4=(TextView)v.findViewById(R.id.tvLastStudent);

        }

    }



}