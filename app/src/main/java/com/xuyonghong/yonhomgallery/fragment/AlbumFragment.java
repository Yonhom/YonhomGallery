package com.xuyonghong.yonhomgallery.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuyonghong.yonhomgallery.R;
import com.xuyonghong.yonhomgallery.adapter.AlbumsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuyonghong on 2017/5/23.
 */

public class AlbumFragment extends Fragment {

    @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.ablums_recycler_view) RecyclerView albumsView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // this view is supposed to be add to the activity's view hierarchy, so it cant be signed a parent here
        View view = inflater.inflate(R.layout.album_fragment, null);
        ButterKnife.bind(this, view);

        albumsView.setAdapter(new AlbumsAdapter());
        albumsView.setLayoutManager(new GridLayoutManager(getActivity(), 3)); // 默认设置3列

        return view;

    }


}
