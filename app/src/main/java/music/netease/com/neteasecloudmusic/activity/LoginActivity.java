package music.netease.com.neteasecloudmusic.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import music.netease.com.neteasecloudmusic.R;
import music.netease.com.neteasecloudmusic.callback.DataCallBack;
import music.netease.com.neteasecloudmusic.model.LoginModel;
import music.netease.com.neteasecloudmusic.model.UserEntity;
import music.netease.com.neteasecloudmusic.presenter.login.LoginModelImpl;
import music.netease.com.neteasecloudmusic.utils.PermisionUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = LoginActivity.class.getName();
    private TextView etName, etPassword;
    private TextView btnLogin;
    private String strName, strPassword;
    private LoginModelImpl loginModel;
    //文件名称
    String fileName = "test.txt";

    //写入和读出的数据信息
    String content = "demo";
    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netease_login);
        loginModel = new LoginModelImpl();
        initView();
        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
        writeFileData(fileName,  content); // 写入文件
        write("test");
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }

    }

    public void initView() {
        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        strName = "13751074578";
        strPassword = "chenJIE584520";
        Log.d("当前时间：", System.currentTimeMillis() + "");
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            strName = TextUtils.isEmpty(etName.getText().toString()) ? strName : etName.getText().toString();
            strPassword = TextUtils.isEmpty(etPassword.getText().toString()) ? strPassword : etPassword.getText().toString();

            loginModel.login(strName, strPassword, new DataCallBack<LoginModel>() {
                @Override
                public void requestBefore() {

                }

                @Override
                public void requestSuccess(final LoginModel data) {
                    Log.d(TAG, "data:" + data.getLoginType());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity entity = new UserEntity();
                            entity.setIconUrl(data.getProfile().getAvatarUrl());
                            entity.setNickName(data.getProfile().getNickname());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("user", entity);
                            startActivity(intent);
                        }
                    });
                }

                @Override
                public void requestError(String msg) {
                    Log.d(TAG, "error:" + msg);
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }

    public void writeFileData(String filename, String content){

        try {

            FileOutputStream fos = this.openFileOutput(filename, MODE_PRIVATE);//获得FileOutputStream

            //将要写入的字符串转换为byte数组

            byte[]  bytes = content.getBytes();

            fos.write(bytes);//将byte数组写入文件

            fos.close();//关闭文件输出流

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(String content) {
        try {
            //判断实际是否有SD卡，且应用程序是否有读写SD卡的能力，有则返回true
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                // 获取SD卡的目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                String path = "/test/";
                File dir = new File(sdCardDir + path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File targetFile = new File(sdCardDir.getCanonicalPath() + path+"aaa.txt");
                //使用RandomAccessFile是在原有的文件基础之上追加内容，
                //而使用outputstream则是要先清空内容再写入
                RandomAccessFile raf = new RandomAccessFile(targetFile, "rw");
                //光标移到原始文件最后，再执行写入
                raf.seek(targetFile.length());
                raf.write(content.getBytes());
                raf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
