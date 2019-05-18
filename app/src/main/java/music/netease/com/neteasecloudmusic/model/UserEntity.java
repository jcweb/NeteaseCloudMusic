package music.netease.com.neteasecloudmusic.model;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private String iconUrl;
    private String nickName;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
