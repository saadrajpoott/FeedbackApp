package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.feedbackapp.FeedbackList.FeedbackData;
import com.example.feedbackapp.FeedbackList.FeedbackListAdapter;
import com.example.feedbackapp.SQLite.DatabaseHelper;

import java.util.ArrayList;

public class FeedbackRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private ArrayList<FeedbackData> feedbackDataArrayList;
    private FeedbackListAdapter feedbackListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_recycler_view);

        databaseHelper = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        feedbackDataArrayList = new ArrayList<>();
        feedbackListAdapter = new FeedbackListAdapter(this, feedbackDataArrayList);
        recyclerView.setAdapter(feedbackListAdapter);

        fillData();
    }

    private void fillData(){
        feedbackDataArrayList.clear();
        Cursor result =  databaseHelper.getAllData();
        if(result.getCount() == 0){
            Toast.makeText(this, "No Feedbacks available", Toast.LENGTH_SHORT).show();
        }
        while(result.moveToNext()){
            feedbackDataArrayList.add(new FeedbackData(
                    result.getString(0),
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        feedbackListAdapter.notifyDataSetChanged();
    }


}
