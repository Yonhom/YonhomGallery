package com.xuyonghong.yonhomgallery.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.xuyonghong.yonhomgallery.model.ImageBucket;
import com.xuyonghong.yonhomgallery.model.ImageItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * 获取媒体内容帮助类
 * Created by xuyonghong on 2017/5/25.
 */

public class MediaManager {

    public static final Uri EXTERNAL_CONTENT_URL = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    /**
     * 获取本地图片集（一般在子线程(io线程)中执行）
     * @param context
     * @return
     */
    public static List<ImageBucket> getImageBucketList(Context context) {
        // HashMap作为图片容器，以相册为键值对对图片进行分类
        HashMap<String, ImageBucket> imageBuckets = new HashMap<>();

        //新建查询列键值
        String[] columns = new String[] {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.BUCKET_ID,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        };

        // 新建查询 : 按照最后修改的事件倒序排列
        Cursor cursor = context.getContentResolver().query(
                EXTERNAL_CONTENT_URL,
                columns, null, null,
                MediaStore.Images.Media.DATE_MODIFIED + " desc");

        if (cursor.moveToFirst()) {
            int indexPhotoID = cursor.getColumnIndexOrThrow(columns[0]);
            int indexPhotoPath = cursor.getColumnIndexOrThrow(columns[1]);
            int indexBucketID = cursor.getColumnIndexOrThrow(columns[2]);
            int indexBucketDisplay = cursor.getColumnIndexOrThrow(columns[3]);
            do {
                String id = cursor.getString(indexPhotoID);
                String path = cursor.getString(indexPhotoPath);
                String bucketID = cursor.getString(indexBucketID);
                String bucketDisplayName = cursor.getString(indexBucketDisplay);

                // 获取相册
                ImageBucket bucket = imageBuckets.get(bucketID);
                if (bucket == null) {
                    bucket = new ImageBucket();
                    bucket.setImageList(new ArrayList<ImageItem>());
                    bucket.setBucketName(bucketDisplayName);
                    imageBuckets.put(bucketID, bucket);
                }

                // 更新相册
                ImageItem image = new ImageItem();
                image.setImageId(id);
                image.setImagePath(path);
                image.setBucket(bucket);
                bucket.getImageList().add(image);
            } while (cursor.moveToNext());
        }

        cursor.close();

        // HashMap转List
        List<ImageBucket> tmpList = new ArrayList<>();
        Iterator<Map.Entry<String, ImageBucket>> iterator
                = imageBuckets.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ImageBucket> entry = iterator.next();
            tmpList.add(entry.getValue());
        }


        return tmpList;
    }

    /**
     * 使用RXJava获取图片库中的图集（注意把线程调到io线程）
     * @param context
     * @return
     */
    public static Observable<ImageBucket> getImageBucketListWithObservable(Context context) {
        Observable<ImageBucket> observable = Observable.create(bucketEmitter -> {
            try {
                List<ImageBucket> imageBucketList = getImageBucketList(context);
                Iterator<ImageBucket> iterator = imageBucketList.iterator();
                while (iterator.hasNext()) {
                    bucketEmitter.onNext(iterator.next());
                }
                bucketEmitter.onComplete();
            } catch (Exception e) {
                bucketEmitter.onError(e);
            }
        });

        return observable;
    }
}
