package com.example.android.disaster_ready;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        //ListView mListView = (ListView) findViewById(R.id.listView);
        //ItemArrayAdapter adapter = new ItemArrayAdapter(this, R.layout.view_adapter_layout, itemList);
        //mListView.setAdapter(adapter);
    }

    public void addClick(View view)
    {
        EditText addedItem = findViewById(R.id.enterItemText);
        String text = addedItem.getText().toString();

        Item item = new Item(text);
//        itemList.add(item);
        addItem(item);
        addedItem.setText("");


        Toast toast = Toast.makeText(this, text + " added", Toast.LENGTH_LONG);
        toast.show();
    }

    public void addItem(Item item)
    {
        itemList.add(item);
        ListView mListView = (ListView) findViewById(R.id.listView);
        ItemArrayAdapter adapter = new ItemArrayAdapter(this, R.layout.view_adapter_layout, itemList);
        mListView.setAdapter(adapter);
    }
}
