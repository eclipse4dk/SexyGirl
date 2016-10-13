package com.example.administrator.sexygirl;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SexyGirlRequest<T> extends JsonRequest<T> {

	private static final String TAG = "SexyGirl";
	
	private Gson mGson;
	
	private Class<T> mClass;

	/**
	 * 
	 * @param method 网络请求的方法 GET POST PUT DELETE
	 * @param url 网络请求url
	 * @param classz 用户要解析成java bean class 对象
	 * @param requestBody 上传的json字符串
	 * @param listener 网络请求成功的回调
	 * @param errorListener 网络请求失败的回调
	 */
	public  SexyGirlRequest(String url, Class<T> classz, Listener listener, ErrorListener errorListener) {
		super(Method.GET, url, null, listener, errorListener);
		mGson = new Gson();
		mClass = classz;
	}

	/**
	 * 在网络请求返回后， 解析网络结果 在子线程调用
	 * 
	 * @return 返回解析后的结果
	 */
	@Override
	protected Response parseNetworkResponse(NetworkResponse response) {
//		Log.d(TAG, "parseNetworkResponse");
		try {
			String result = new String(response.data, PROTOCOL_CHARSET);
//			Log.d(TAG, "parse to string: " + result);
			
//			//将string转换成java bean对象
//			CategoryBean categoryBean = mGson.fromJson(result, CategoryBean.class);
//			Log.d(TAG, "parse to bean: " + categoryBean.data.get(0).children.get(0).title);
			T resultBean = mGson.fromJson(result, mClass);
			//从响应里面解析出缓存相关信息
			Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
			Log.d(TAG, "ttl " + cacheEntry.ttl);
			cacheEntry.ttl = System.currentTimeMillis() +  30 * 60 * 1000;
			return Response.success(resultBean, cacheEntry);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		HashMap<String,String> header = new HashMap<>();
		header.put("apikey", "9cf5aecf1fd1c219a835903acca0f53b");
		return header;
	}
}
