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

public class CustomCSStudentsListView extends ArrayAdapter<String> {

    private String[] regNo;
    private String[] name;
    private String[] phone;
    private String[] cgpa;
    private String[] chr;
    private Activity context;
    Bitmap bitmap;

    public CustomCSStudentsListView(Activity context,String[] regNo,String[] name,String[] phone,String[] cgpa,String[] chr) {
        super(context, R.layout.layoutcsstudents,regNo);
        this.context=context;
        this.regNo=regNo;
        this.name=name;
        this.phone=phone;
        this.cgpa=cgpa;
        this.chr=chr;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        CustomCSStudentsListView.ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layoutcsstudents,null,true);
            viewHolder=new CustomCSStudentsListView.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(CustomCSStudentsListView.ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(regNo[position]);
        viewHolder.tvw2.setText(name[position]);
        viewHolder.tvw3.setText(phone[position]);
        viewHolder.tvw4.setText(cgpa[position]);
   //     viewHolder.tvw5.setText(chr[position]);

        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;
        TextView tvw5;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvRegNo);
            tvw2=(TextView)v.findViewById(R.id.tvName);
            tvw3=(TextView)v.findViewById(R.id.tvPhone);
            tvw4=(TextView)v.findViewById(R.id.tvCGPA);
      //      tvw5=(TextView)v.findViewById(R.id.tvCHr);
        }

    }


}
