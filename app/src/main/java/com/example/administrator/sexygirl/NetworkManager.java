package com.example.administrator.sexygirl;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.Volley;

public class NetworkManager {
	
	//一个app只维护一个请求队列
	private static RequestQueue mRequestQueue;
	//一个app只维护一个图片加载器
	private static ImageLoader mImageLoader;
	
	private static int CACHE_SIZE = (int) (Runtime.getRuntime().freeMemory() / 4);
	
	
	public static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new ImageLruCache(CACHE_SIZE));
		
	}
	
	public static ImageLoader getImageLoader() {
		return mImageLoader;
	}
	
	/**
	 * 发送网络请求 把请求放到全局的请求队列
	 * @param request
	 */
	public static void sendRequest(Request<?> request) {
		mRequestQueue.add(request);
	}
	
	/**
	 * K 图片的url当做key
	 *
	 * V 值 Bitmap
	 */
	public static class ImageLruCache extends LruCache<String, Bitmap> implements ImageCache{

		/**
		 * 内存缓存的最大空间
		 * @param maxSize
		 */
		public ImageLruCache(int maxSize) {
			super(maxSize);
		}
		
		/**
		 * 获取存入图片大小
		 */
		@Override
		protected int sizeOf(String key, Bitmap value) {
			return value.getRowBytes() * value.getHeight();
		}

		/**
		 * 从LRU缓存里面获取图片
		 * @param url
		 * @return
		 */
		@Override
		public Bitmap getBitmap(String url) {
			return get(url);
		}

		/**
		 * 将网络图片存入lrucache
		 * @param url
		 * @param bitmap
		 */
		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			put(url, bitmap);
		}
		
	}

}
