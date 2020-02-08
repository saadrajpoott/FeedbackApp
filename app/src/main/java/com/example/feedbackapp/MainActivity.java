package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.feedbackapp.FeedbackList.FeedbackData;
import com.example.feedbackapp.FeedbackList.FeedbackListAdapter;
import com.example.feedbackapp.SQLite.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText fullname_edittext;
    private EditText email_edittext;
    private EditText phone_edittext;
    private EditText feedback_edittext;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        fullname_edittext = findViewById(R.id.fullname_edittext);
        email_edittext = findViewById(R.id.email_edittext);
        phone_edittext = findViewById(R.id.phone_edittext);
        feedback_edittext = findViewById(R.id.feedback_edittext);
        feedback_edittext.setVerticalScrollBarEnabled(true);
        feedback_edittext.setMovementMethod(new ScrollingMovementMethod());

        databaseHelper = new DatabaseHelper(this);
    }

    public void addFeedback(View view) {
        if( fullname_edittext.getText().toString().equals("") ||
            email_edittext.getText().toString().equals("") ||
            phone_edittext.getText().toString().equals("") ||
            feedback_edittext.getText().toString().equals("")
        ){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean isInserted = databaseHelper.insertData(
                    fullname_edittext.getText().toString(),
                    email_edittext.getText().toString(),
                    phone_edittext.getText().toString(),
                    feedback_edittext.getText().toString()
            );

            if(isInserted) {
                fullname_edittext.setText("");
                email_edittext.setText("");
                phone_edittext.setText("");
                feedback_edittext.setText("");
                Toast.makeText(this, "Feedback Added", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Feedback not Added", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void seeFeedback(View view) {
        startActivity(new Intent(this, FeedbackRecyclerView.class));

    }
}
