package com.example.fishx.habits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddHabitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
    }


    public void Back(View view){

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

}
