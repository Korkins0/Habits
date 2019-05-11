package com.example.fishx.habits;

import android.content.Context;

import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class inputActivity extends AppCompatActivity {
    float rating = 3.5f;
//cacac
    Context context = this;
    SQLiteDatabase db1;
SQLiteAdapter db = new SQLiteAdapter(context);
    List<habitAdapter> datelist;
    private RadioButton check;
    private RatingBar scoreBar;
    private TextView mnthTxt,scoreTxt;
    CompactCalendarView compactCalendar;
    CaldroidFragment caldroidFragment = new CaldroidFragment();
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        final ActionBar actionbar = getSupportActionBar();
        actionbar.hide();


        //date veritabanına ekleniyor.

        //Güne verilen puanların ortalamasını alıp texte ve ratinge yazdırmak.
        scoreBar = (RatingBar)findViewById(R.id.scoreInfo);
        scoreTxt = findViewById(R.id.scoreTxt);

        scoreBar.setRating(rating);
        scoreTxt.setText(""+scoreBar.getRating());

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
        try {
            checkDates();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //takvim bitti.
    }
    public void radioCtrl(View v){

        Resources res = getResources();
        Calendar mcurrentTime = Calendar.getInstance();
        int year = mcurrentTime.get(Calendar.YEAR);//Güncel Yılı alıyoruz
        int month = mcurrentTime.get(Calendar.MONTH)+1;//Güncel Ayı alıyoruz
        int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);//Güncel Günü alıyoruz
        String sDate1=day +"/"+month + "/"+ year;
        Log.i("datexd" , "anenisikm"+sDate1);
        db.dateAdd(new habitAdapter(sDate1));
        try {
            checkDates();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        caldroidFragment.refreshView();
    }
    public void checkDates() throws ParseException {
        datelist = db.getDates();
        Resources res = getResources();

        List<String> listContent1 = new ArrayList<>();
        for(int i = 0; i <datelist.size() ; i++){
            listContent1.add(i,datelist.get(i).getDate());

        }
        Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.ic_launcher_background, null);
        String[] dates = new String[listContent1.size()];
        for (int i = 0; i < listContent1.size(); i++) {
            dates[i] = listContent1.get(i);
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dates[i]);
            caldroidFragment.setBackgroundDrawableForDate(drawable,date1);
            Log.i("bakbuna","girdi");
        }



        caldroidFragment.refreshView();



    }


}
