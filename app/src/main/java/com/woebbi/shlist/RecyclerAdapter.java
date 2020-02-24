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

    //private TextView rATextViewName;
    //private TextView rATextViewAmount;

    public RecyclerAdapter(ArrayList<Things> items) {
        this.items = items;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView rATextViewName, rATextViewAmount;
        private FloatingActionButton rAFABAdd, rAFABSub,rAFABDel;


        public MyViewHolder(View v) {
            super(v);
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

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.rATextViewName.setText(items.get(position).getName());
        //holder.rATextViewAmount.setText(items.get(position).getAmount());
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        holder.getrATextViewName().setText(items.get(position).getName());
        holder.getrATextViewAmount().setText(String.valueOf(items.get(position).getAmount()));
        /*holder.getrAFABAdd().set
        holder.getrAFABAdd().setText(items.get(position).toString());
        holder.getrAFABSub().setText(items.get(position).toString());
        holder.getrAFABDel().setText(items.get(position).toString());*/



    }

    @Override
    public int getItemCount() {

        return items.size();
    }

}
