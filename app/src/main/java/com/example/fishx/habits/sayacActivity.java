package com.example.fishx.habits;

import android.app.AlertDialog;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.roomorama.caldroid.CaldroidFragment;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class sayacActivity extends AppCompatActivity {
    float rating = 3.72f;
    //cacac
    Context context = this;
    Intent intent;
    habitAdapter selectedToDo;
    private RadioButton check;
    private RatingBar scoreBar;
    private TextView mnthTxt,scoreTxt;
    CompactCalendarView compactCalendar;
    SQLiteAdapter db = new SQLiteAdapter(context);
    CaldroidFragment caldroidFragment = new CaldroidFragment();
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayac);
        final ActionBar actionbar = getSupportActionBar();
        actionbar.hide();


        intent = getIntent();
        int id = intent.getIntExtra("todo",1);


        Log.i("gelenid", String.valueOf(id));
        selectedToDo = db.contentRead(id);
        //Güne verilen puanların ortalamasını alıp texte ve ratinge yazdırmak.
        scoreBar = (RatingBar)findViewById(R.id.scoreInfo);
        scoreTxt = findViewById(R.id.scoreTxt);

        scoreBar.setRating(rating);
        scoreTxt.setText(""+scoreBar.getRating());

        //mnthTxt = findViewById(R.id.monthText);

        //Burada puan ortalaması işlemi bitiyor.


        //=============================YENİ TAKVİM===============================
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendarLayout, caldroidFragment);
        t.commit();
        t.show(caldroidFragment);

        Resources res = getResources();

        Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.ic_launcher_background, null);
        caldroidFragment.setBackgroundDrawableForDate(drawable,tomorrow);

        caldroidFragment.refreshView();

        //takvim bitti.
    }
    public void radioCtrl(View v){
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        Resources res = getResources();
        Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.ic_launcher_background, null);
        caldroidFragment.setBackgroundDrawableForDate(drawable,today);
        caldroidFragment.refreshView();
    }
    public void btnSil(View v){

        new AlertDialog.Builder(this)
                .setMessage("Silmek istediğinize emin misiniz?")
                .setCancelable(false)
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        db.deletetoDo(selectedToDo);
                        sayacActivity.this.finish();
                    }
                })
                .setNegativeButton("İptal", null)
                .show();
    }


}
