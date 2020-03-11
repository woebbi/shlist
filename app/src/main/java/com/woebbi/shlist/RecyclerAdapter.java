package com.woebbi.shlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        //SET Content
        holder.getrATextViewName().setText(items.get(position).getName());
        holder.getrAEditTextName().setText(items.get(position).getName());
        holder.getrATextViewAmount().setText(String.valueOf(items.get(position).getAmount()));


        //Each FAB Gets a CLICK
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
                items.remove(position);
                recView.getAdapter().notifyDataSetChanged(); //This refresehes the RECYCVIEW!

            }
        });

        holder.getrAEditTextName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "FABADel clicked.");
                items.get(position).setName(holder.getrAEditTextName().getText().toString());
                //holder.getrATextViewName().setText(holder.getrAEditTextName().getText());


                recView.getAdapter().notifyDataSetChanged(); //This refresehes the RECYCVIEW!

            }
        });

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView rATextViewName, rATextViewAmount; //the Text
        private FloatingActionButton rAFABAdd, rAFABSub, rAFABDel; //the Buttons
        private EditText rAEditTextName;

        public MyViewHolder(View v) {
            super(v);
            //Connect views(cast) with variables
            rATextViewName = (TextView) v.findViewById(R.id.rVITextViewName);
            rATextViewAmount = (TextView) v.findViewById(R.id.rVITextViewAmount);
            rAFABAdd = (FloatingActionButton) v.findViewById(R.id.rVIFABAdd);
            rAFABSub = (FloatingActionButton) v.findViewById(R.id.rVIFABSub);
            rAFABDel = (FloatingActionButton) v.findViewById(R.id.rVIFABDelete);
            rAEditTextName = (EditText) v.findViewById(R.id.rVIEditTextName);
            //Just some debug thing!
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Add:" + rAFABAdd.getWidth() + "x" + rAFABAdd.getHeight() + "Sub:" + rAFABSub.getWidth() + "x" + rAFABSub.getHeight() + "Del:" + rAFABDel.getWidth() + "x" + rAFABDel.getHeight());
                    if (rAFABAdd.isOrWillBeHidden()) {
                        Log.d(TAG, "Show");
                        rAFABAdd.setVisibility(View.VISIBLE);
                        rAFABSub.setVisibility(View.VISIBLE);
                        rAFABDel.setVisibility(View.VISIBLE);
                        rAEditTextName.setVisibility(View.VISIBLE);
                        rATextViewName.setVisibility(View.INVISIBLE);

                    } else {
                        Log.d(TAG, "Hide");
                        rAFABAdd.setVisibility(View.INVISIBLE);
                        rAFABSub.setVisibility(View.INVISIBLE);
                        rAFABDel.setVisibility(View.INVISIBLE);
                        rAEditTextName.setVisibility(View.INVISIBLE);
                        rATextViewName.setVisibility(View.VISIBLE);

                    }
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

        public TextView getrAEditTextName() {
            return rAEditTextName;
        }
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

}
