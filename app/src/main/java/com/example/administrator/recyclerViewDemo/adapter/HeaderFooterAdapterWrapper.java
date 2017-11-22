package com.example.administrator.recyclerViewDemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jngoogle on 2017/11/21.
 */

public class HeaderFooterAdapterWrapper extends MyAdapter {
    private static final int HEADER_ITEM_TYPE = 10000;
    //    private static final int FOOTER_ITEM_TYPE = 20000;
    private static final int NORMAL_ITEM_TYPE = 30000;

    private Context context;
    private int resId;
    private View headerView;

    public HeaderFooterAdapterWrapper(Context context, int resId) {
        super(context, resId);
        this.context = context;
        this.resId = resId;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headerView != null && viewType == HEADER_ITEM_TYPE) {
            return new MyViewHolder(parent.getContext(), headerView);
        }

        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (HEADER_ITEM_TYPE == getItemViewType(position)) {
            return;
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        if (headerView == null) {
            return super.getItemCount();
        } else {
            return super.getItemCount() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (headerView == null) {
            return NORMAL_ITEM_TYPE;
        }

        if (position == 0) {
            return HEADER_ITEM_TYPE;
        }

        return NORMAL_ITEM_TYPE;
    }

    public void addHeaderView(View headerView) {
        this.headerView = headerView;
        notifyItemInserted(0);
    }
}
