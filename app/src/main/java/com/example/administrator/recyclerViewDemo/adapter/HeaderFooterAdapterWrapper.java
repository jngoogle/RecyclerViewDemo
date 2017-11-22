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
    private static final int FOOTER_ITEM_TYPE = 20000;
    private static final int NORMAL_ITEM_TYPE = 30000;

    private View headerView;
    private View footerView;

    /**
     *
     * @param context
     * @param resId  列表 item 的布局，注意不是 header 或 footer 的布局
     */
    public HeaderFooterAdapterWrapper(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headerView != null && viewType == HEADER_ITEM_TYPE) {
            return new MyViewHolder(parent.getContext(), headerView);
        }
        if (footerView != null && viewType == FOOTER_ITEM_TYPE) {
            return new MyViewHolder(parent.getContext(), footerView);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (HEADER_ITEM_TYPE == getItemViewType(position)) {
            return;
        }
        if (FOOTER_ITEM_TYPE == getItemViewType(position)) {
            return;
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        boolean hasHeaderView = headerView == null ? false : true;
        boolean hasFooterView = footerView == null ? false : true;

        if (!hasHeaderView || !hasFooterView) {
            if (!hasHeaderView && !hasFooterView) {
                return super.getItemCount();
            } else {
                return super.getItemCount() + 1;
            }
        }

        return super.getItemCount() + 2;// 有header和footer
    }

    @Override
    public int getItemViewType(int position) {
        if (headerView == null) {
            return NORMAL_ITEM_TYPE;
        }
        if (footerView == null) {
            return NORMAL_ITEM_TYPE;
        }
        if (position == 0) {
            return HEADER_ITEM_TYPE;
        }
        if (position == super.getItemCount() + 1) {
            return FOOTER_ITEM_TYPE;
        }
        return NORMAL_ITEM_TYPE;
    }

    public void addHeaderView(View headerView) {
        this.headerView = headerView;
        notifyItemInserted(0);
    }

    public void addFooterView(View footerView) {
        this.footerView = footerView;
        notifyItemInserted(super.getItemCount() - 1);
    }
}
