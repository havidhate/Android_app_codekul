package com.example.masterspinnerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ExampleAdapter adapter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        tv = findViewById(R.id.tv);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem("Name: Yash Charpe","Mobile: 9307719398","Age: 19"));
        exampleList.add(new ExampleItem("Name: Atul Kale","Mobile: 8968483594","Age: 45"));
        exampleList.add(new ExampleItem("Name: Ram Kumar","Mobile: 8945679249","Age: 54"));
        exampleList.add(new ExampleItem("Name: John Stewart","Mobile: 7858981536","Age: 36"));
        exampleList.add(new ExampleItem("Name: Kumar Sanu","Mobile: 7569156498","Age: 60"));
        exampleList.add(new ExampleItem("Name: Farhan Sheikh","Mobile: 7205565792","Age: 43"));
        exampleList.add(new ExampleItem("Name: Gary Snow","Mobile: 7265489836","Age: 27"));
        exampleList.add(new ExampleItem("Name: Monu Goyat","Mobile: 9445681898","Age: 50"));

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListner(new ExampleAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"Clicked"+position+" Name: "+exampleList.get(position).getName(),Toast.LENGTH_SHORT).show();
                tv.setText("Name: "+exampleList.get(position).getName()+"\n Mobile No: "+exampleList.get(position).getMobile()+"\n Age: "+exampleList.get(position).getAge());
            }
        });

    }
}