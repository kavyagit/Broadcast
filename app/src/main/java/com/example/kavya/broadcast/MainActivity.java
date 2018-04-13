package com.example.kavya.broadcast;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
private TextView text;
RecyclerView.LayoutManager layoutManager;
private ArrayList<incomingNumber>arrayList=new ArrayList <>();
private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerView);
        text     =    (TextView)findViewById(R.id.recyclerView);
        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        readFromDb();

    }
    private void readFromDb()
    {
        arrayList.clear();
          DBHelper Helper=new DBHelper(this);
        SQLiteDatabase database= Helper.getWritableDatabase();
        Cursor cursor =Helper.readNumber(database);
        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext())

            {
                String number;
                int id;
                number = cursor.getString(cursor.getColumnIndex(DBcontract.Incoming_Number));
                id = cursor.getInt(cursor.getColumnIndex("id"));
                arrayList.add(new incomingNumber(id, number));
            }
            cursor.close();
            Helper.close();
           adapter.notifyDataSetChanged();
           recyclerView.setVisibility(recyclerView.VISIBLE);
            text.setVisibility(recyclerView.GONE);}

        }





    }

