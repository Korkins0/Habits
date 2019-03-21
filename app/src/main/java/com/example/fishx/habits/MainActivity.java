package com.example.fishx.habits;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int x=0;
    PointsGraphSeries<DataPoint> pointSeries;
    LineGraphSeries<DataPoint> lineSeries;
    GraphView graph;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> habitNames;

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



}
