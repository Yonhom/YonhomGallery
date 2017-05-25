package com.xuyonghong.yonhomgallery.model;

import java.util.List;

/**
 * 照片集
 * Created by xuyonghong on 2017/5/25.
 */

public class ImageBucket {
    private String bucketName;
    private List<ImageItem> imageList;
    private List<ImageItem> selectedImageList;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public List<ImageItem> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageItem> imageList) {
        this.imageList = imageList;
    }

    public List<ImageItem> getSelectedImageList() {
        return selectedImageList;
    }

    public void setSelectedImageList(List<ImageItem> selectedImageList) {
        this.selectedImageList = selectedImageList;
    }
}
