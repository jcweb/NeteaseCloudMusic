package music.netease.com.neteasecloudmusic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private String resultCode;
    private String resultDesc;

    public String getResultCode() {
        return resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
