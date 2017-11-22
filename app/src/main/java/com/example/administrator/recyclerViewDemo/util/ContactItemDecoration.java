package com.example.administrator.recyclerViewDemo.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2017/11/19 0019.
 */

public class ContactItemDecoration extends RecyclerView.ItemDecoration {

    private Context context;
    private Paint letterPaint;
    private List<String> data;

    public ContactItemDecoration(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        letterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        letterPaint.setColor(Color.RED);
        letterPaint.setTextSize(UnitUtil.sp2px(context, 16));
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        }

        for (int i = 0; i < parent.getChildCount(); i++) {
            int position = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() + i;
            View child = parent.getChildAt(i);
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            float left = 0;
            float right = child.getLeft() - params.leftMargin;
            float top = child.getTop() - params.topMargin;
            float bottom = child.getBottom() + params.bottomMargin;
            float width = right - left;
            float height = bottom - (bottom - top) / 2;
            if (position > parent.getChildCount()) {
                return;
            }

            char letter = PinyinUtil.getPinyin(data.get(position).charAt(0) + "");

            if (position == 0) {
                drawFirstLetter(c, letter, width, height, letterPaint);
            } else {
                // 上一个 item 的首字母
                char preLetter = PinyinUtil.getPinyin(data.get(position - 1).charAt(0) + "");
                if (letter != preLetter) {
                    drawFirstLetter(c, letter, width, height, letterPaint);
                }
            }
        }
    }

    private void drawFirstLetter(Canvas canvas, char letter, float width, float height, Paint paint) {
        float fontLength = getFontLength(letterPaint, letter);
        float fontHeight = getFontHeight(letterPaint);
        float x = (width - fontLength) / 2;
        float y = height - fontHeight / 2 + getFontLeading(paint);
        canvas.drawText(String.valueOf(letter), x, y, letterPaint);
    }

    /**
     * 返回指定笔和指定字符串的长度
     */
    private float getFontLength(Paint paint, char str) {
        return paint.measureText(String.valueOf(str));
    }

    /**
     * 返回指定笔的文字高度
     */
    private float getFontHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    /**
     * 返回指定笔离文字顶部的基准距离
     */
    private float getFontLeading(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.leading - fm.ascent;
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        outRect.set(UnitUtil.dip2px(context, 40), 0, 0, 0);
    }

}
