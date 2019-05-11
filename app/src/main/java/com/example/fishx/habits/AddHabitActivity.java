package com.example.fishx.habits;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

public class AddHabitActivity extends AppCompatActivity {
    //ArrayAdapter<String> lAdapterHabits;

    Context context = this;
    ListView listView;
    String mTitle[]=new String[]{};
    int images[]={};
    List<habitAdapter> list;
    SQLiteAdapter db = new SQLiteAdapter(context);

    ArrayAdapter<String> lAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        db.contentAdd(new habitAdapter("deneme",3 , 2,1,3));
        listele();
        /*MyAdapter adapter = new MyAdapter(this,mTitle,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
         */

    }
    //DENEME =========================

    public void listele(){
        listView=findViewById(R.id.listview);

        // db.contentAdd(new listAdapter("xddddd amllll sadgasdas sadfasdgasdjn sagjsadgkjasd dsags","2019","3","12","15","34","0"));
        // db.contentAdd(new listAdapter("xddddd amllll","2018","3","12","15","34","0"));

        list = db.getContents();


        List<String> listContent = new ArrayList<>();
        for(int i = 0; i <list.size() ; i++){
            listContent.add(i,list.get(i).getHabit());

        }
        // List<String> listInts = new ArrayList<>();
        // for(int i = 0; i <list.size() ; i++){
        //     listInts.add(i,list.get(i).getYil());

        // }
        lAdapter = new ArrayAdapter<String>(context,R.layout.row,R.id.baslik,listContent);
        listView.setAdapter(lAdapter);
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,toDoInfoActivity.class);
                intent.putExtra("todo",list.get(position).getId());
                Log.i("id=",String.valueOf(list.get(position).getId()));
                startActivityForResult(intent,1);
            }
        });*/
    }








    //DENEME =========================
    /*
    public void Back(View view){

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }


    public class MyAdapter extends ArrayAdapter<String> {

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



    */
}
