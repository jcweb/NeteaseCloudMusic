package music.netease.com.neteasecloudmusic.utils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author timpkins
 * json解析工具
 */
public class JsonUtils {
    //私有化构造方法
    private JsonUtils() {
    }

    //实例化出JSONObject
    public static JSONObject createJSONObject(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //实例化出JSONArray对象
    public static JSONArray createJSONArray(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return jsonArray;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取数据
    public static <T> T getParam(String origin, Class clazz) {
        try {
//            JSONObject jsonObject = new JSONObject(origin);
            Gson gson = new Gson();
            return (T) gson.fromJson(origin,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取数据
    public static <T> List<T> getParamList(String str, Class<T> clzz, String name) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            String data = jsonObject.getString(name);
            Object o = jsonObject.get(name);
            List<T> dataList = new ArrayList<>();
            Gson gson = new Gson();
            if (o instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) o;
                for (int i = 0; i < jsonArray.length(); i++) {
                    Object o1 = jsonArray.get(i);
                    if (o1 instanceof JSONObject) {
                        dataList.add(gson.fromJson(o1.toString(), clzz));
                    }
                }
            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取数据
    public static <T> List<T> getParamList(String str,Class<T> clzz) {
        try {
            JSONArray  jsonArray= new JSONArray(str);
            List<T> dataList = new ArrayList<>();
            Gson gson = new Gson();
                for (int i = 0; i < jsonArray.length(); i++) {
                    Object o1 = jsonArray.get(i);
                    if (o1 instanceof JSONObject) {
                        dataList.add(gson.fromJson(o1.toString(), clzz));
                    }
            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> getParamList(JSONArray jsonArray, Class<T> clzz) {
        try {
            List<T> dataList = new ArrayList<>();
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                Object o = jsonArray.get(i);
                if (o instanceof JSONObject) {
                    dataList.add(gson.fromJson(o.toString(), clzz));
                }
            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
