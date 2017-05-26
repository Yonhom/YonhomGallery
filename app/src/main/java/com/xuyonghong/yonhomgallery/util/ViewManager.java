package com.xuyonghong.yonhomgallery.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by xuyonghong on 2017/5/26.
 */

public class ViewManager {
    /**
     * replace the container's child view with the fragment's view
     * @param fragment the fragment to replace the old view
     */
    public static void loadFragment(FragmentActivity activity, Fragment fragment, int containerID) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //noinspection ResourceType
        fragmentTransaction.replace(containerID,
                fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
}
