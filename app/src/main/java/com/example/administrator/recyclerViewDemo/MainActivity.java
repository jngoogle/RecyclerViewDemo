package com.example.administrator.recyclerViewDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.recyclerViewDemo.adapter.MyAdapter;
import com.example.administrator.recyclerViewDemo.util.ContactItemDecoration;
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
        dataList.add("二");
        dataList.add("小");
        dataList.add("人");
        dataList.add("打");
        dataList.add("天");
        dataList.add("跑");
        dataList.add("走");
        dataList.add("非");
        dataList.add("唱");


        myAdapter = new MyAdapter(this, R.layout.layout_list_item);
        myAdapter.setDataList(dataList);
        listRv = findViewById(R.id.rv_list);
        listRv.setLayoutManager(new LinearLayoutManager(this));
        listRv.setAdapter(myAdapter);
        listRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        listRv.addItemDecoration(new ContactItemDecoration(this, dataList));
    }
}
