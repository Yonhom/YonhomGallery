package com.xuyonghong.yonhomgallery.view.themeable;

import com.xuyonghong.yonhomgallery.util.ThemeHelper;

/**
 * view主题可操作化接口
 * whoever implementing this interface has the activity to have its
 * theme changed
 * Created by xuyonghong on 2017/5/23.
 */

public interface Themeable {
    void refreshTheme(ThemeHelper helper);
}
