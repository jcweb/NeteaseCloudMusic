package music.netease.com.neteasecloudmusic.model;

import java.util.List;

public class DynamicModel {

    /**
     * code : 200
     * more : true
     * lasttime : 1557919338448
     */

    private int code;
    private boolean more;
    private long lasttime;
    private List<DynamicEntity> event;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public long getLasttime() {
        return lasttime;
    }

    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }

    public List<DynamicEntity> getEvent() {
        return event;
    }

    public void setEvent(List<DynamicEntity> event) {
        this.event = event;
    }


}
