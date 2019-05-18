package music.netease.com.neteasecloudmusic.network;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.JsonIOException;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.TypeInfo;
import music.netease.com.neteasecloudmusic.utils.EncryptUtils;
import music.netease.com.neteasecloudmusic.utils.ReqClassUtils;
import music.netease.com.neteasecloudmusic.utils.ReqJsonUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AbsRequest {

    private static final String TAG = "AbsRequest";

    protected OkHttpClient httpClient;

    /*
     * url:请求的地址
     * body：表单
     * callback：回调
     * */
    protected void requestPost(String url, HashMap parameter, final DataCallBack dataCallBack) {
        JSONObject jsonObject = new JSONObject(parameter);
        Map<String, String> map = EncryptUtils.encrypt(jsonObject.toString());
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            builder.add(key, value);
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder().url(url).headers(getHeaders()).post(formBody).build();
        Call call = httpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "错误信息：" + e.getMessage());
                dataCallBack.requestError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Log.d(TAG, "返回的结果：" + result);
                if (!TextUtils.isEmpty(result)) {
                    try {
                        TypeInfo typeInfo = ReqClassUtils.getCallbackGenericType(dataCallBack.getClass());
                        dataCallBack.requestSuccess(ReqJsonUtils.parseHttpResult(typeInfo, result));
                    } catch (JsonIOException e) {
                        e.printStackTrace();
                    }
                }
                Headers headers = response.headers();
//                List<String> cookies = headers.values("SET-COOKIE");
//                String session = cookies.get(0);
//                Log.d(TAG,"cookie:"+cookies.size()+"\n session:"+session);
//                getCookie();
            }
        });
    }

    private void getCookie() {
        httpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url, cookies);
                        cookieStore.put(HttpUrl.parse("http://192.168.31.231:8080/shiro-2"), cookies);
                        for (Cookie cookie : cookies) {
                            Log.d("cookie", "cookie Name:" + cookie.name());
                            Log.d("cookie", "cookie Path:" + cookie.path());
                        }
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(HttpUrl.parse("http://music.163.com/weapi/login/cellphone?"));
                        if (cookies == null) {
                            Log.d("cookie", "没加载到cookie");
                        }
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .build();
        RequestBody formBody = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "admin")
                .build();

    }

    protected Headers getHeaders() {
        Headers headers = null;
        okhttp3.Headers.Builder headersbuilder = new okhttp3.Headers.Builder();
        Map<String, String> headersParams = new HashMap<>();

//        headersParams.put("Referer", "https://music.163.com");
//        headersParams.put("Origin", "https://music.163.com");
//        headersParams.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
//        headersParams.put("Content-Type", "application/x-www-form-urlencoded");
        headersParams.put("Cookie", setCookie());
//        headersParams.put("set-cookie","093bd68f3c378c205ad7bfae54577152e65c9584e722925392d5c08a7af08f66a54947c93ebddc59d57f7bf87d14b57a7955a739ab43dce1");
//        headersParams.put("connection","keep-alive");
//        headersParams.put("vary","Accept-Encoding");
//        headersParams.put("cache-control","no-store, no-cache");
//        headersParams.put("expires","Thu, 01 Jan 1970 00:00:00 GMT");
//        headersParams.put("ccess-Control-Allow-Headers","X-Requested-With");
//        headersParams.put("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        headersParams.put("Content-Type", "application/json;charset=utf-8");
        if (headersParams != null) {
            Iterator<String> iterator = headersParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                headersbuilder.add(key, headersParams.get(key));
                Log.d("get http", "get_headers===" + key + "====" + headersParams.get(key));
            }
        }
        headers = headersbuilder.build();

        return headers;

    }

    private String setCookie() {
        Map cookie = new HashMap<>();
        cookie.put("__remember_me", "true");
        cookie.put("os", "pc");
        cookie.put("MUSIC_U", "093bd68f3c378c205ad7bfae54577152916269d37758d4a59b44f6efc1b07b2871e4ebbcb4b1d567c7520351bdcdf06a58b2e601810d53ba");
        cookie.put("MUSIC_FU", "b116405db92da4250cfc4fae09dfd4fac173d215684d533f75042c72f8d8404b");
        cookie.put("__csrf", "65508bd5993e61af820a85dd2866ba5b");
        return cookie.toString();
    }
}
