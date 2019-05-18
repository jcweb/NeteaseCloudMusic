package music.netease.com.neteasecloudmusic.model.dynamic;

/*粉丝信息，加载头部需要用到*/
public class RcmdInfoEntity {

    /**
     * reason : 优质动态推荐
     * alg : locationE
     * type : 1
     * scene : social
     * userReason : 2935粉丝
     */

    private String reason;
    private String alg;
    private int type;
    private String scene;
    private String userReason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getUserReason() {
        return userReason;
    }

    public void setUserReason(String userReason) {
        this.userReason = userReason;
    }
}
