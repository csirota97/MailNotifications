package com.example.craigsirota.mailnotifications;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TableRow;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

public class Main2Activity extends AppCompatActivity {

    ListView l1;
    static String num;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Cursor c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        l1 = (ListView) findViewById(R.id.list1);


        startManagingCursor(c);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};

        for (int i = 0; i < from.length; i++) {
            System.out.println(from[i]);
        }

        int[] to = {android.R.id.text1, android.R.id.text2};

        System.out.println("-------------------------------");
        for (int i = 0; i < from.length; i++) {
            System.out.println(to[i]);
        }

        final SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, c, from, to);
        l1.setAdapter(sca);
        l1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        l1.setClickable(true);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View v, int position, long l) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);

             //   TableRow tableRow = (TableRow) (l1.getItemAtPosition(position));

             //   String project = ((TextView) tableRow.findViewById(R.id.)).getText().toString();
             //   String workRequest = ((TextView) tableRow.findViewById(R.id.work_request)).getText().toString();

                System.out.println("\n-----------------------------------\n\n"+l1.getItemAtPosition(position).toString());
              //  for (int i = 0; i < sca.getCursor().getColumnNames().length; i++) {
              //      System.out.println(sca.getCursor().getColumnNames()[5]);
              //  }

             //   String str = l1.getItemAtPosition(position);

                intent.putExtra("Number", l1.getItemAtPosition(position).toString() );
                startActivity(intent);
            }
        });
    }

    void getNum(View v) {
        System.out.println("121");
    }
}
