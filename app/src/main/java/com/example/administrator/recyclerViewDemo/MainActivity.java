package com.example.administrator.recyclerViewDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myapplication.R;
import com.example.administrator.recyclerViewDemo.adapter.MyAdapter;
import com.example.administrator.recyclerViewDemo.util.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listRv;
    private MyAdapter myAdapter;
    private ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(i + "");
        }

        myAdapter = new MyAdapter(this, R.layout.layout_list_item);
        myAdapter.setDataList(dataList);
        listRv = findViewById(R.id.rv_list);
        listRv.setLayoutManager(new LinearLayoutManager(this));
        listRv.setAdapter(myAdapter);
        listRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
    }
}
