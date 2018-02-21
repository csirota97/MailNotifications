package com.example.craigsirota.mailnotifications;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class ListActivity extends AppCompatActivity {

    ListView listView;
    String[] states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_main);

        listView = (ListView) findViewById(R.id.listView);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
        }

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(ListActivity.this,
                android.R.layout.simple_list_item_1,
                states);
        listView.setAdapter(mAdapter);
    }
}