 package com.woebbi.shlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener  {
    private Toolbar mAToolbar;
    private FloatingActionButton mAFAB;

    private RecyclerView mARecyclerView;
    private RecyclerView.Adapter mARecyclerViewAdapter;
    private RecyclerView.LayoutManager mARecyclerViewLayoutManager;

    private SharedPreferences sp;

    private ArrayList<Things> items = new ArrayList<Things>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0;i<=10;i++){
            Things temp = null;
            temp = new Things("abc"+i, i);
            items.add(temp);
        }

        //Connect Views/IDs with Variables
        mAToolbar = findViewById(R.id.mAToolbar);
        mARecyclerView = findViewById(R.id.mARecyclerView);
        mAFAB = findViewById(R.id.mAFAB);

        //RecyclerVie layout und adapter
        mARecyclerViewLayoutManager = new LinearLayoutManager(this);
        mARecyclerView.setLayoutManager(mARecyclerViewLayoutManager);

        mARecyclerViewAdapter = new RecyclerAdapter(items);
        mARecyclerView.setAdapter(mARecyclerViewAdapter);
        mARecyclerView.addOnItemTouchListener();



        }
                /*
        mAAdapter = new RecyclerAdapter(getResources().getStringArray(R.array.menuMenu));
        mARecyclerView.setAdapter(mAAdapter);

                 */



     @Override
     public void onClick(View v) {
         v.getId();
         Context context = getApplicationContext();
         //CharSequence text = (String) v.getId();
         int duration = Toast.LENGTH_SHORT;

         Toast toast = Toast.makeText(context, v.getTooltipText(), duration);
         toast.show();


     }

     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

     }
 }