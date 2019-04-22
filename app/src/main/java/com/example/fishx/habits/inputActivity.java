package com.example.fishx.habits;

import android.content.Context;

import android.graphics.Color;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class inputActivity extends AppCompatActivity {
    float rating = 3.5f;

    private RadioButton check;
    private RatingBar scoreBar;
    private TextView mnthTxt,scoreTxt;
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        final ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        check = findViewById(R.id.radioButton);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast.makeText(context,"siexddd",Toast.LENGTH_SHORT).show();



            }
        });

        //Güne verilen puanların ortalamasını alıp texte ve ratinge yazdırmak.
        scoreBar = (RatingBar)findViewById(R.id.scoreInfo);
        scoreTxt = findViewById(R.id.scoreTxt);

        scoreBar.setRating(rating);
        scoreTxt.setText(""+scoreBar.getRating());

        mnthTxt = findViewById(R.id.monthText);

        //Burada puan ortalaması işlemi bitiyor.

        //Deneme takvimi yapılandırması başladı ========Güzel bi takvim deil ========
        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);


        //deneme eventi ekleniyor.
        Event ev1 = new Event(Color.RED,1555862825000L,"siexd");
        compactCalendar.addEvent(ev1);


        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override

            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                if(dateClicked.toString().compareTo("Sat Apr 20 19:00:00 AST 2019")==0)
                    Toast.makeText(context,"siexddd",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context,"nooooo",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                mnthTxt.setText(dateFormatMonth.format(firstDayOfNewMonth));

            }
        });
        //takvim bitti.
    }

}
