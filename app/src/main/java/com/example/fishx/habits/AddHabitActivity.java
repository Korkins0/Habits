package com.example.fishx.habits;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddHabitActivity extends AppCompatActivity {
    //ArrayAdapter<String> lAdapterHabits;

    Context context = this;
    ListView listView1;
    ArrayList<habitAdapter> habitList;
    String mTitle[]=new String[]{"Kitap Okuma","Erken Yatma","Sigara Bırakma"};
    int images[]={R.drawable.bookicon,R.drawable.sleepicon,R.drawable.nocig};
    SQLiteAdapter db = new SQLiteAdapter(context);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        //db.contentAdd(new habitAdapter("deneme",3 , 2,1,3));
        //listeleDb();
        listView1=findViewById(R.id.listview1);
        MyAdapter adapter = new MyAdapter(this,mTitle,images);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                if (position==0){
                    if(db.hasObject("Kitap Okuma","habitContentDB","content")){
                        Toast.makeText(context,"You already have this habit in you list",3);
                    }
                    else{
                        db.contentAdd(new habitAdapter("Kitap Okuma",0 , 0,0,0));
                    }
                }
                if (position==1){
                    if(db.hasObject("Erken Yatma","habitContentDB","content")){
                        Toast.makeText(getApplicationContext(), "You already have this habit in you list", Toast.LENGTH_LONG).show();

                    }
                    else{
                        db.contentAdd(new habitAdapter("Kitap Okuma",0 , 0,0,0));
                    }
                }
                if (position==2){
                    if(true){
                        Toast.makeText(context,"You already have this habit in you list",3);
                    }
                    else{
                        db.contentAdd(new habitAdapter("Kitap Okuma",0 , 0,0,0));
                    }
                }

            }
        });


    }
    //DENEME =========================










    //DENEME =========================

    public void Back(View view){

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

    public class MyAdapter extends ArrayAdapter<String> {

        //String name[];
        Context context;
        String rTitle[];
        int rImg[];

        MyAdapter(Context context,String title[],int imgs[]){
            super(context,R.layout.row,R.id.baslik,title);
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
            TextView myTitle=row.findViewById(R.id.baslik);


            images.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);


            return row;
        }
    }

}
