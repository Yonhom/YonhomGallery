package com.xuyonghong.yonhomgallery.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xuyonghong.yonhomgallery.model.ImageBucket;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by xuyonghong on 2017/5/24.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {
    List<ImageBucket> imageAlbums;

    public AlbumsAdapter() {
        imageAlbums = new ArrayList<>();
    }

    public void clear() {
        if (imageAlbums.size() > 0) {
            imageAlbums.clear();
            notifyDataSetChanged();
        }
    }

    public void add(ImageBucket imageBucket) {
        imageAlbums.add(imageBucket);
    }

    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AlbumsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         *
         * @param itemView the item view is the parent view of all the views
         *                 this view holder holds reference to
         */
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
