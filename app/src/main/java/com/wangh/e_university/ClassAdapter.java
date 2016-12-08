package com.wangh.e_university;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by wangh on 2016/8/2.
 */
public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassHolder> {
    private final String[] WEEK={"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
    private final LayoutInflater layoutInflater;
    private final Context context;
    private ArrayList<ClassItem> classes=new ArrayList<ClassItem>();
    private ArrayList<Boolean> isDate=new ArrayList<>();

    public void addClass(ClassItem classItem){
        classes.add(classItem);
        isDate.add(classItem.isDate());
    }

    public ClassAdapter(Context context){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public ClassHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ClassHolder classHolder= new ClassHolder(layoutInflater.inflate(R.layout.class_item,parent,false));
        return classHolder;
    }

    @Override
    public void onBindViewHolder(ClassHolder holder, int position) {
        ClassItem aClass=classes.get(position);
//        Log.d("onBindViewHolder",aClass.toString());
        if(isDate.get(position)){
            setDateItem(holder,classes.get(position));
            Log.d("onBindViewHolder date",classes.get(position).toString());
        }else{
            setClassItem(holder,classes.get(position));
            Log.d("onBindViewHolder class",classes.get(position).toString());
        }
    }

    private void setDateItem(ClassHolder holder,ClassItem aClass){
        String timeText=aClass.getMonth()+"月"+aClass.getDay()+"日 "+WEEK[aClass.getDate()];
        holder.classLocation.setText(timeText);
        holder.classLocation.setTextColor(context.getResources().getColor(R.color.black));
        holder.classTitle.setVisibility(View.GONE);
        holder.classTime.setVisibility(View.INVISIBLE);
        holder.cardView.setPadding(0,0,0,0);
        holder.cardView.removeView(holder.classTitle);
        holder.cardView.removeView(holder.classTime);
        holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.white));
    }

    private void setClassItem(ClassHolder holder,ClassItem aClass){
        holder.classTime.setText(aClass.getClassTime());
        holder.classTitle.setText(aClass.getClassTitle());
        holder.classLocation.setText(aClass.getClassLocation());
        holder.classTitle.setVisibility(View.VISIBLE);
        holder.classTime.setVisibility(View.VISIBLE);
        holder.classLocation.setTextColor(context.getResources().getColor(R.color.white));
        holder.classTitle.getPaint().setFakeBoldText(true);
        switch (aClass.getColorID()){
            case 0:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor0)); break;
            case 1:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor1)); break;
            case 2:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor2)); break;
            case 3:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor3)); break;
            case 4:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor4)); break;
            case 5:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor5)); break;
            case 6:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor6)); break;
            case 7:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor7)); break;
            case 8:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor8)); break;
            case 9:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor9)); break;
            case 10:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor10)); break;
            case 11:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor11)); break;
            case 12:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor12)); break;
            case 13:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor13)); break;
            case 14:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor14)); break;
            case 15:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor15)); break;
            case 16:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor16)); break;
            case 17:holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.classColor17)); break;
        }
        if(aClass.isPassed()){
            holder.classBlock.setBackgroundColor(context.getResources().getColor(R.color.grey));
        }
    }

    @Override
    public int getItemCount() {
        return classes==null?0:classes.size();
    }

    public static class ClassHolder extends RecyclerView.ViewHolder{
        TextView classTitle;
        TextView classLocation;
        TextView classTime;
        CardView cardView;
        LinearLayout classBlock;

        ClassHolder(View view){
            super(view);
            cardView=(CardView)view.findViewById(R.id.card);
            classTitle=(TextView)view.findViewById(R.id.classTitle);
            classLocation=(TextView)view.findViewById(R.id.classLocation);
            classTime=(TextView)view.findViewById(R.id.classTime);
            classBlock=(LinearLayout)view.findViewById(R.id.classBlock);
        }

    }
}