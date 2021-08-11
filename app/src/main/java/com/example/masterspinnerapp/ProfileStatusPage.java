package com.example.masterspinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProfileStatusPage extends AppCompatActivity {

    private TableLayout tableId;
    private Button checkInBtn;
    private Button checkOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_status_page);


        checkInBtn = findViewById(R.id.checkInBtn);
        checkOutBtn = findViewById(R.id.checkOutBtn);


        tableId = findViewById(R.id.tableId);

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        checkInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TableRow tr = new TableRow(getApplicationContext());


                TextView tv1 = new TextView(getApplicationContext());
                tv1.setText("      "+formattedDate+"     ");
                tv1.setGravity(Gravity.CENTER);
                tr.addView(tv1);

            }
        });


        /*for(int i=0;i<10;i++)
        {
            TableRow tr = new TableRow(this);


            TextView tv1 = new TextView(this);
            tv1.setText("      "+(i+1)+"-07-2021     ");
            tv1.setGravity(Gravity.CENTER);



            TextView tv2 = new TextView(this);
            tv2.setText("      "+(i+1)+":10:20     ");
            tv2.setGravity(Gravity.CENTER);



            TextView tv3 = new TextView(this);
            tv3.setText("      "+(i+1)+":10:20     ");
            tv3.setGravity(Gravity.CENTER);


            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);

            tableId.addView(tr);

        }*/
    }
}