package com.example.masterspinnerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList ;
    private OnItemClickListner mListner;

    public interface OnItemClickListner{
        void onItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner listner)
    {
        mListner = listner;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTv,mobileTv,ageTv;

        public ExampleViewHolder(View itemView,OnItemClickListner listner) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            mobileTv = itemView.findViewById(R.id.mobileTv);
            ageTv = itemView.findViewById(R.id.ageTv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner!=null)
                    {
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            listner.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public ExampleAdapter (ArrayList<ExampleItem> exampleList)
    {
        mExampleList = exampleList;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v,mListner);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleAdapter.ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.nameTv.setText(currentItem.getName());
        holder.ageTv.setText(currentItem.getAge());
        holder.mobileTv.setText(currentItem.getMobile());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
