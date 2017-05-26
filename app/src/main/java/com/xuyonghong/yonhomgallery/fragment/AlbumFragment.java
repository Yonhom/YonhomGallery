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
import com.xuyonghong.yonhomgallery.util.MediaManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xuyonghong on 2017/5/23.
 */

public class AlbumFragment extends Fragment {

    @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.ablums_recycler_view) RecyclerView albumsView;

    private AlbumsAdapter albumsAdapter;

    public static int recycler_view_columns_count = 3;

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

        albumsAdapter = new AlbumsAdapter();
        albumsView.setAdapter(albumsAdapter);
        albumsView.setLayoutManager(new GridLayoutManager(getActivity(), recycler_view_columns_count)); // 默认设置3列
        
        displayAlbums();

        return view;

    }

    private void displayAlbums() {
        albumsAdapter.clear();

        //把在io线程获取的图片信息更新到adapter中
        MediaManager.getImageBucketListWithObservable(getContext())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(imageBucket -> { // onNext subscriber
                            albumsAdapter.add(imageBucket);
                        },
                        error -> {},  // onError subcriber
                        () -> {  // onComplete subscriber

                });
    }


}
