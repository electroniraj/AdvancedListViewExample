package com.example.niraj.advancedlistviewexample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int[] imag = {R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background};
    String [] texts = {
            ("Apple"),
        ("Ball"),
        ("Cat"),
        ("Dog"),
        ("Elephant"),
        ("Fish"),
        ("Ginger"),
        ("Hen"),
        ("Iron"),
        ("Jacket"),
        ("Kite"),
        ("Lion")};

    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);

       listAdapter = new ListAdapter(MainActivity.this,texts,imag);

       listView.setAdapter(listAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(),texts[position],Toast.LENGTH_SHORT).show();
           }
       });


        registerForContextMenu(listView);


    }


    @Override
    public void onCreateContextMenu(
            ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.edit:

            case R.id.delete:
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
                default:
                    return super.onContextItemSelected(item);
        }


    }
}
