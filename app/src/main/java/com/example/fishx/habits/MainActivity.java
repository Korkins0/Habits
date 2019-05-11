package com.example.fishx.habits;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    //aktivite değiştirmek
    int x=0;

    PointsGraphSeries<DataPoint> pointSeries;
    LineGraphSeries<DataPoint> lineSeries;

    GraphView graph;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> habitNames;
    ArrayAdapter<String> lAdapterHabits;
    Context context = this;

    List<Habit> habitCons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graph = (GraphView) findViewById(R.id.graph);
        lineSeries = new LineGraphSeries<>();
        pointSeries = new PointsGraphSeries<>();
        listView = findViewById(R.id.listview);
        habitNames = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,habitNames);
        graphMake();


        ArrayList<Integer> xDatas = new ArrayList<Integer>();



        button = (Button)findViewById(R.id.changeActiv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInput();
            }
        });

    }
    public void openActivityInput(){
        Intent intent = new Intent(this,inputActivity.class);
        startActivity(intent);
    }

    /*public void sayi(View view){

            lineSeries.appendData(new DataPoint(x,1),true,10000);
            pointSeries.appendData(new DataPoint(x,1),true,10000);
            x++;
            graph.addSeries(lineSeries);
            graph.addSeries(pointSeries);

    }*/



    public void graphMake(){
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(5);
        graph.getGridLabelRenderer().setNumHorizontalLabels(4);
        graph.getGridLabelRenderer().setNumVerticalLabels(10);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_habit,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.add_habit){

           Intent intent = new Intent(getApplicationContext(),AddHabitActivity.class);
           startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}





