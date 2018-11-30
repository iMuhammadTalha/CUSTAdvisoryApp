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

public class CustomUnApproveAdvisorsListView extends ArrayAdapter<String> {

    private String[] Name;
    private String[] Designation;
    private String[] Department;
    private String[] Phone;
    private String[] Email;

    private Activity context;
    Bitmap bitmap;

    public CustomUnApproveAdvisorsListView(Activity context,String[] Name,String[] Designation,String[] Department,String[] Phone,String[] Email) {
        super(context, R.layout.layoutunapproveadvisors,Name);
        this.context=context;
        this.Name=Name;
        this.Designation=Designation;
        this.Department=Department;
        this.Phone=Phone;
        this.Email=Email;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layoutunapproveadvisors,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(Name[position]);
        viewHolder.tvw2.setText(Designation[position]);
        viewHolder.tvw3.setText(Department[position]);
        viewHolder.tvw4.setText(Phone[position]);
        viewHolder.tvw5.setText(Email[position]);

        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;
        TextView tvw5;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvName);
            tvw2=(TextView)v.findViewById(R.id.tvDesignation);
            tvw3=(TextView)v.findViewById(R.id.tvDepartment);
            tvw4=(TextView)v.findViewById(R.id.tvPhone);
            tvw5=(TextView)v.findViewById(R.id.tvEmail);
        }

    }



}