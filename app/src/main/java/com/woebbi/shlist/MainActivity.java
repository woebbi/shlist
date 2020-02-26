 package com.woebbi.shlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener  {
    private Toolbar mAToolbar;
    private FloatingActionButton mAFAB;

    private RecyclerView mARecyclerView;
    private RecyclerView.Adapter mARecyclerViewAdapter;
    private RecyclerView.LayoutManager mARecyclerViewLayoutManager;

    private SharedPreferences sp;

    private ArrayList<Things> items = new ArrayList<Things>();

     private static final String TAG = "RecyclerAdapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0;i<=1;i++){
            Things temp;
            temp = new Things("abc"+i, i);
            items.add(temp);
        }

        //Connect Views/IDs with Variables
        mAToolbar = findViewById(R.id.mAToolbar);
        mARecyclerView = findViewById(R.id.mARecyclerView);
        mAFAB = findViewById(R.id.mAFAB);

        //Onclickistener
        mAFAB.setOnClickListener(this);

        //RecyclerVie layout und adapter
        mARecyclerViewLayoutManager = new LinearLayoutManager(this);
        mARecyclerView.setLayoutManager(mARecyclerViewLayoutManager);

        mARecyclerViewAdapter = new RecyclerAdapter(items, mARecyclerView);
        mARecyclerView.setAdapter(mARecyclerViewAdapter);
        }

     @Override
     public void onClick(View v) {
         switch (v.getId()) {
             case R.id.mAFAB:
                 Context context = getApplicationContext();
                 //CharSequence text = (String) v.getId();
                 int duration = Toast.LENGTH_SHORT;


                 Log.d(TAG, "FABPED.");
                 Things temp = null;
                 Random rand = new Random();
                 rand.nextInt(20);
                 temp = new Things("buhuhu", rand.nextInt(20));
                 items.add(temp);
                 mARecyclerView.refreshDrawableState();
                 Toast toast = Toast.makeText(context, String.valueOf(items.size()), duration);
                 toast.show();
             default:
                 mARecyclerViewAdapter.notifyDataSetChanged();
                 break;
         }
     }

     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         mARecyclerViewAdapter.notifyDataSetChanged();
     }
 }