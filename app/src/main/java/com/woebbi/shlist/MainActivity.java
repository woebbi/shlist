 package com.woebbi.shlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
     private Toolbar mAToolbar;
     private FloatingActionButton mAFAB;
     private EditText mAEditText;

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

        for (int i = 0; i <= 1; i++) {
            Things temp;
            temp = new Things("abc" + i, i);
            items.add(temp);
        }

        //Connect Views/IDs with Variables
        mAToolbar = findViewById(R.id.mAToolbar);
        mARecyclerView = findViewById(R.id.mARecyclerView);
        mAFAB = findViewById(R.id.mAFAB);

        mAEditText = findViewById(R.id.mAEditText);
        //CHeck if enter key on softkeyboard was pressen and if then add text and do it
        mAEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                Log.d(TAG, "drinne.");
                if (actionId == EditorInfo.IME_ACTION_GO || event.getKeyCode() == KeyEvent.KEYCODE_NUMPAD_ENTER || event.getKeyCode() == KeyEvent.KEYCODE_ENTER || event.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {
                    Log.d(TAG, "FABPED.");
                    Things temp = null;
                    temp = new Things(mAEditText.getText().toString(), 0);
                    items.add(temp);
                    mAEditText.setEnabled(false);
                    mAEditText.setText("");
                    mAEditText.clearFocus();
                    mAEditText.setVisibility(View.INVISIBLE);
                    mARecyclerViewAdapter.notifyDataSetChanged();
                    handled = true;
                }
                return handled;

            }
        });

        //disable Edit Text
        mAEditText.setEnabled(false);
        mAEditText.setVisibility(View.INVISIBLE);


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
         Log.d(TAG, mAEditText.isEnabled() + " ");
         switch (v.getId()) {
             case R.id.mAFAB:
                 if (mAEditText.isEnabled()) {
                     Log.d(TAG, "FABPED.");
                     Things temp = null;
                     temp = new Things(mAEditText.getText().toString(), 0);
                     items.add(temp);
                     mAEditText.setEnabled(false);
                     mAEditText.setText("");
                     mAEditText.clearFocus();

                     mAEditText.setVisibility(View.INVISIBLE);
                     mARecyclerViewAdapter.notifyDataSetChanged();
                 } else {
                     mAEditText.setFocusableInTouchMode(true);
                     mAEditText.setEnabled(true);
                     mAEditText.setVisibility(View.VISIBLE);
                     mAEditText.requestFocus();
                     InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                     imm.showSoftInput(mAEditText, InputMethodManager.SHOW_FORCED);
                 }
                 break;
             default:
                 Log.d(TAG, mAEditText.isEnabled() + " ");
                 break;
         }
     }

     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         //mARecyclerViewAdapter.notifyDataSetChanged();
     }


 }