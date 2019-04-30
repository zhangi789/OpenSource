package com.dnxc.cn.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dnxc.cn.R;

import java.io.File;

/**
 * @author 张海洋
 * @Date on 2019/04/18.
 * @org 上海..科技有限公司
 * @describe
 */
public class GlideUtil {


    private static final String TAG = GlideUtil.class.getSimpleName();

    private GlideUtil() {
    }

    public static void init(Context context) {
    }

    /**
     * 普通裁剪
     *
     * @param context
     * @param imageView
     * @param url       网址
     */
    public static void displayImage(Context context, ImageView imageView, String url) {
        GlideApp.with(context)
                .load(url)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, File file) {
        GlideApp.with(context)
                .load(file)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Drawable drawable) {
        GlideApp.with(context)
                .load(drawable)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Integer id) {
        GlideApp.with(context)
                .load(id)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Bitmap bitmap) {
        GlideApp.with(context)
                .load(bitmap)
                .into(imageView);

    }

    public static void displayImage(Context context, ImageView imageView, Uri uri) {
        displayImage(context, imageView, uri, 0);
    }

    /**
     * 普通裁剪  加占位符
     *
     * @param context
     * @param imageView
     * @param url
     * @param placeholder
     */
    public static void displayImage(Context context, ImageView imageView, String url, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)    //加载错误之后的错误图
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();

        GlideApp.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, File file, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)    //加载错误之后的错误图
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();

        GlideApp.with(context)
                .load(file)
                .apply(options)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Drawable drawable, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)    //加载错误之后的错误图
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();

        GlideApp.with(context)
                .load(drawable)
                .apply(options)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Integer id, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)    //加载错误之后的错误图
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();

        GlideApp.with(context)
                .load(id)
                .apply(options)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Bitmap bitmap, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)    //加载错误之后的错误图
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();

        GlideApp.with(context)
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }

    public static void displayImage(Context context, ImageView imageView, Uri uri, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)    //加载错误之后的错误图
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .centerCrop();

        GlideApp.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }


    /**
     * 裁剪成圆形
     *
     * @param context
     * @param imageView
     * @param url
     * @param placeholder 占位符和错误符一致  默认为0
     */
    public static void displayImageCircleCrop(Context context, ImageView imageView, String url, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, File file, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(file)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Uri uri, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Drawable drawable, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(drawable)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Integer id, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(id)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Bitmap bitmap, int placeholder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }


    /**
     * 裁剪成圆形
     *
     * @param context
     * @param imageView
     * @param url
     * @param placeholder 占位符和错误符不一致  默认为0
     * @param errorHolder
     */
    public static void displayImageCircleCrop(Context context, ImageView imageView, String url, int placeholder, int errorHolder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, File file, int placeholder, int errorHolder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(file)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Drawable drawable, int placeholder, int errorHolder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(drawable)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Integer id, int placeholder, int errorHolder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(id)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Bitmap bitmap, int placeholder, int errorHolder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }

    public static void displayImageCircleCrop(Context context, ImageView imageView, Uri uri, int placeholder, int errorHolder) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = RequestOptions.circleCropTransform()
                .placeholder(placeholder)
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        GlideApp.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }


    /**
     * 裁剪成圆角矩形
     *
     * @param context
     * @param imageView
     * @param url
     * @param placeholder 占位符和错误符一致  默认为0
     */
    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, String url, int placeholder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, File file, int placeholder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(file)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Drawable drawable, int placeholder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(drawable)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Integer id, int placeholder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(id)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Bitmap bitmap, int placeholder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Uri uri, int placeholder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }


    /**
     * 裁剪成圆角矩形
     *
     * @param context
     * @param imageView
     * @param url
     * @param placeholder 占位符和错误符不一致  默认为0
     */
    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, String url, int placeholder, int errorHolder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, File file, int placeholder, int errorHolder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(file)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Drawable drawable, int placeholder, int errorHolder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(drawable)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Integer id, int placeholder, int errorHolder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(id)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Bitmap bitmap, int placeholder, int errorHolder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void displayImageRoundedRectangleCrop(Context context, ImageView imageView, Uri uri, int placeholder, int errorHolder, int roundingRadius) {
        if (context == null || imageView == null) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .transforms(new CenterCrop(), new RoundedCorners(roundingRadius))
                .placeholder(placeholder)    //加载成功之前占位图
                .error(errorHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存;  //加载错误之后的错误图
        GlideApp.with(context)
                .load(uri)
                .apply(options)
                .into(imageView);
    }


}
