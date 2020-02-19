package com.woebbi.shlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Things> items;

    private TextView rATextViewName;
    private TextView rATextViewAmount;

    public RecyclerAdapter(ArrayList<Things> items) {
        this.items = items;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView rATextViewName;
        private TextView rATextViewAmount;

        public MyViewHolder(ConstraintLayout v) {
            super(v);
            this.rATextViewName = rATextViewName;
            this.rATextViewAmount = rATextViewAmount;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.rATextViewName.setText(items.get(position).getName());
        holder.rATextViewAmount.setText(items.get(position).getAmount());
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

}
