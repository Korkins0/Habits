package com.example.fishx.habits;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AddHabitActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[]=new String[]{};
    int images[]={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        listView=findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this,mTitle,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    public void Back(View view){

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }


    public class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        int rImg[];

        MyAdapter(Context context,String title[],int imgs[]){
            super(context,R.layout.row,R.id.TextView1,title);
            this.context=context;
            this.rTitle=title;
            this.rImg=imgs;


        }


        @NonNull
        @Override
        public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.TextView1);

            images.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);


            return row;
        }
    }



}
