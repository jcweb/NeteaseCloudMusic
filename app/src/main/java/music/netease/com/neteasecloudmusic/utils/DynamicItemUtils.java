package music.netease.com.neteasecloudmusic.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import music.netease.com.neteasecloudmusic.model.dynamic.DynamicMsgEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicMusicEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicTabEntity;
import music.netease.com.neteasecloudmusic.model.dynamic.DynamicVideoEntity;

/*判断json里面的数据是music还是video，还是string*/
public class DynamicItemUtils {

    /**
     * 将JSON字符串转换成指定的用户返回值类型
     *
     * @param jsonData
     * @return
     * @throws JSONException
     */
    public static <T> T parsedynamicJson(String jsonData) {
        //声明结果对象
        T result = null;
        try {
            JSONObject object = new JSONObject(jsonData);
            result = (T) new Gson().fromJson(jsonData, DynamicMusicEntity.class);

            if (result == null) {
                result = (T) new Gson().fromJson(jsonData, DynamicVideoEntity.class);
            }

            if (result == null) {
                result = (T) new Gson().fromJson(jsonData, DynamicMsgEntity.class);
            }

            if (result == null) {
                return (T) new Gson().fromJson(jsonData, DynamicTabEntity.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
