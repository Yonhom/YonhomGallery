package com.xuyonghong.yonhomgallery.adapter;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xuyonghong.yonhomgallery.R;
import com.xuyonghong.yonhomgallery.model.ImageBucket;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuyonghong on 2017/5/24.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {
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
    public AlbumsAdapter.AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card_view, null);
        AlbumViewHolder holder = new AlbumViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AlbumsAdapter.AlbumViewHolder holder, int position) {
        ImageBucket imageBucket = imageAlbums.get(position);
        String imagePath = imageBucket.getImageList().get(0).getImagePath();
        holder.albumCoverView.setImageURI(Uri.parse(imagePath));
    }

    @Override
    public int getItemCount() {
        return imageAlbums.size();
    }



    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.album_card_view)
        CardView albumCardView;
        @BindView(R.id.album_cover_view)
        ImageView albumCoverView;

        /**
         *
         * @param itemView the item view is the parent view of all the views
         *                 this view holder holds reference to
         */
        public AlbumViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
