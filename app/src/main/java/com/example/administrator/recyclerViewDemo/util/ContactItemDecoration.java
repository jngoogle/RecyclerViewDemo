package com.example.administrator.recyclerViewDemo.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/**
 * Created by Administrator on 2017/11/19 0019.
 */

public class ContactItemDecoration extends RecyclerView.ItemDecoration {

    private Context context;
    private Paint letterPaint;

    public ContactItemDecoration(Context context) {
        this.context = context;
        letterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        letterPaint.setColor(Color.RED);
        letterPaint.setTextSize(UnitUtil.sp2px(context, 16));
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        if (!(layoutManager instanceof LayoutManager)) {
            throw new IllegalArgumentException("invalid layoutManager");
        }

        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            float left = 0;
            float right = child.getLeft() - params.leftMargin;
            float top = child.getTop() - params.topMargin;
            float bottom = child.getBottom() + params.bottomMargin;
            float width = right - left;
            float height = bottom - top;

            drawFirstLetter(c, "A", width, height, letterPaint);
        }

    }


    private void drawFirstLetter(Canvas canvas, String letter, float width, float height, Paint paint) {
        float fontLength = getFontLength(letterPaint, letter);
        float fontHeight = getFontHeight(letterPaint);
        float x = (width - fontLength) / 2;
        float y = (float) ((height - fontHeight) / 2 + getFontLeading(letterPaint) * 1.5);
        canvas.drawText(letter, x, y, letterPaint);

    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        outRect.set(UnitUtil.dip2px(context, 40), 0, 0, 0);
    }

    /**
     * 返回指定笔和指定字符串的长度
     */
    private float getFontLength(Paint paint, String str) {
        return paint.measureText(str);
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

}
