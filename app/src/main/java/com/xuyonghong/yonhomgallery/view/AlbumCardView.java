package com.xuyonghong.yonhomgallery.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by xuyonghong on 2017/5/26.
 */

public class AlbumCardView extends CardView {
    public AlbumCardView(Context context) {
        super(context);
    }

    public AlbumCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlbumCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int measuredWidth = 0;
        int measuredHeight = 0;

        if (widthMode == MeasureSpec.EXACTLY) {
            measuredWidth = widthSize;
        }

        measuredHeight = measuredWidth;

        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
