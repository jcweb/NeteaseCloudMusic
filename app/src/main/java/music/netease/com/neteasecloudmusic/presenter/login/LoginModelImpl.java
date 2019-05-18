package music.netease.com.neteasecloudmusic.presenter.login;

import android.app.Activity;
import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import music.netease.com.neteasecloudmusic.activity.LoginActivity;
import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.LoginModel;
import music.netease.com.neteasecloudmusic.network.OkHttpManager;
import music.netease.com.neteasecloudmusic.utils.Constant;
import music.netease.com.neteasecloudmusic.utils.EncryptUtils;
import music.netease.com.neteasecloudmusic.utils.MD5Utils;
import okhttp3.FormBody;

public class LoginModelImpl extends OkHttpManager implements ILogin<LoginModel> {

    @Override
    public void login(String name, String password, DataCallBack<LoginModel> callBack) {

        String data = "{\"email\":\"13751074578\",\"password\":\"chenJIE584520\"}";
        HashMap parameter = new HashMap<>();
        parameter.put("phone", "13751074578");
        parameter.put("password", MD5Utils.MD5("chenJIE584520"));
        parameter.put("rememberLogin", true);
        requestPost(Constant.BASE_URL_NETEASE + "login/cellphone", parameter, callBack);
    }
}
