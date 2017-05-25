package com.xuyonghong.yonhomgallery.model;

/**
 * 单张图片
 * Created by xuyonghong on 2017/5/25.
 */

public class ImageItem {
    /**
     * image id
     */
    private String imageId;
    /**
     * image path
     */
    private String imagePath;
    /**
     * image selection status
     */
    private boolean isSelected = false;
    /**
     * reference of the album the current image is in
     */
    private ImageBucket bucket;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ImageBucket getBucket() {
        return bucket;
    }

    public void setBucket(ImageBucket bucket) {
        this.bucket = bucket;
    }
}
