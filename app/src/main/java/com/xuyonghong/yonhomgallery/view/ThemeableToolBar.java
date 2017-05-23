package com.xuyonghong.yonhomgallery.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.xuyonghong.yonhomgallery.util.ThemeHelper;
import com.xuyonghong.yonhomgallery.view.themeable.Themeable;

/**
 * just a normal Toolbar, plus the ability to have its theme changed
 * Created by xuyonghong on 2017/5/23.
 */

public class ThemeableToolBar extends Toolbar implements Themeable {

    public ThemeableToolBar(Context context) {
        super(context);
    }

    public ThemeableToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeableToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme(ThemeHelper helper) {
        // TODO: use the theme helper to get the theme you want and set them to the toolbar
    }
}
