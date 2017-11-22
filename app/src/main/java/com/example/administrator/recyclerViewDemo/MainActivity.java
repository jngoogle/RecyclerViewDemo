package com.example.administrator.recyclerViewDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.recyclerViewDemo.adapter.HeaderFooterAdapterWrapper;
import com.example.administrator.recyclerViewDemo.adapter.MyAdapter;
import com.example.administrator.recyclerViewDemo.util.ContactItemDecoration;
import com.example.administrator.recyclerViewDemo.util.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listRv;
    private MyAdapter myAdapter;
    private HeaderFooterAdapterWrapper adapterWrapper;
    private ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        dataList.add("天");
        dataList.add("天是的");
        dataList.add("天是");
        dataList.add("天啊啊");
        dataList.add("跑");
        dataList.add("走");
        dataList.add("二");
        dataList.add("小");
        dataList.add("人");
        dataList.add("打");
        dataList.add("非");
        dataList.add("唱");
        dataList.add("识破");
        dataList.add("事情");
        dataList.add("珊瑚");
        dataList.add("啦啦啦");
        dataList.add("他");
        dataList.add("他玩");
        dataList.add("他是");
        dataList.add("香梨");
        dataList.add("稀疏");

//        myAdapter = new MyAdapter(this, R.layout.layout_list_item);
//        myAdapter.setDataList(dataList);
        adapterWrapper = new HeaderFooterAdapterWrapper(this, R.layout.layout_list_item);
        adapterWrapper.setDataList(dataList);
        View headerView = LayoutInflater.from(this).inflate(R.layout.layout_list_item_header, listRv, false);
        View footerView = LayoutInflater.from(this).inflate(R.layout.layout_list_item_footer, listRv, false);
        adapterWrapper.addHeaderView(headerView);
        adapterWrapper.addFooterView(footerView);

        listRv = findViewById(R.id.rv_list);
        listRv.setLayoutManager(new LinearLayoutManager(this));
        listRv.setAdapter(adapterWrapper);
//        listRv.setAdapter(myAdapter);
        listRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        listRv.addItemDecoration(new ContactItemDecoration(this, dataList));
    }
}
