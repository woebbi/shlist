package com.woebbi.shlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    private ArrayList<Things> items;
    private RecyclerView recView;


    public RecyclerAdapter(ArrayList<Things> items, RecyclerView recView) {
        this.items = items;
        this.recView = recView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Log.d(TAG, "Element " + position + " set.");

        holder.getrATextViewName().setText(items.get(position).getName());
        holder.getrATextViewAmount().setText(String.valueOf(items.get(position).getAmount()));
        holder.getrAFABAdd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "FABADD clicked.");
                items.get(position).incAmount();
                holder.getrATextViewAmount().setText(String.valueOf(items.get(position).getAmount()));
            }
        });

        holder.getrAFABSub().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "FABSub clicked.");
                items.get(position).decAmount();
                holder.getrATextViewAmount().setText(String.valueOf(items.get(position).getAmount()));
            }
        });

        holder.getrAFABDel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "FABADel clicked.");
                recView.getAdapter().notifyDataSetChanged();
                items.remove(position);

            }
        });

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView rATextViewName, rATextViewAmount; //the Text
        private FloatingActionButton rAFABAdd, rAFABSub, rAFABDel; //the Buttons


        public MyViewHolder(View v) {
            super(v);
            //Connect views(cast) with variables
            rATextViewName = (TextView) v.findViewById(R.id.rVITextViewName);
            rATextViewAmount = (TextView) v.findViewById(R.id.rVITextViewAmount);
            rAFABAdd = (FloatingActionButton) v.findViewById(R.id.rVIFABAdd);
            rAFABSub = (FloatingActionButton) v.findViewById(R.id.rVIFABSub);
            rAFABDel = (FloatingActionButton) v.findViewById(R.id.rVIFABDelete);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }

        //getter
        public FloatingActionButton getrAFABAdd() {
            return rAFABAdd;
        }

        public FloatingActionButton getrAFABSub() {
            return rAFABSub;
        }

        public FloatingActionButton getrAFABDel() {
            return rAFABDel;
        }

        public TextView getrATextViewName() {
            return rATextViewName;
        }

        public TextView getrATextViewAmount() {
            return rATextViewAmount;
        }
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

}
