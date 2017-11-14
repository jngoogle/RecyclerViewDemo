package com.example.administrator.recyclerViewDemo.adapter;

import android.content.Context;

import com.example.administrator.myapplication.R;

/**
 * Created by jngoogle on 2017/11/14.
 */

public class MyAdapter extends CommonRecyclerAdapter<String> {

    public MyAdapter(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public void bindData(MyViewHolder holder, int position, String itemData) {
        holder.setText(R.id.tv_id, itemData);
    }
}
