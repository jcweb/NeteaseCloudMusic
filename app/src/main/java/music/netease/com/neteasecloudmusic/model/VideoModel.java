package music.netease.com.neteasecloudmusic.model;

import java.util.List;

public class VideoModel {

    /**
     * code : 200
     * data : [{"type":1,"title":"霍比特人3:五军之战删减内容，《Star Sky》超燃配乐！","durationms":336022,"creator":[{"userId":81543567,"userName":"听乐府"}],"playTime":1740475,"coverUrl":"http://p3.music.126.net/cOaWrZ9XkVTtxEVETF_fsg==/109951163573518202.jpg","vid":"F4B5CCEF49B6F50D8F5F4BE03C128D13","aliaName":null,"transName":null,"alg":null,"markTypes":[109]},{"type":1,"title":"Maroon 5 美国之声现场献唱热单《Sugar》，骚当还是那么骚气！","durationms":281798,"creator":[{"userId":509042699,"userName":"音乐树洞"}],"playTime":298775,"coverUrl":"http://p4.music.126.net/n4xgDFzJIZSayrQU6hXVIA==/109951163572629720.jpg","vid":"98A8C6AB6BEFB31CC14CE9ECC78C8AA0","aliaName":null,"transName":null,"alg":null,"markTypes":[]},{"type":0,"title":"See You Again（翻唱）","durationms":309000,"creator":[{"userId":783418,"userName":"Against the Current"}],"playTime":758390,"coverUrl":"http://p3.music.126.net/f-8IFLcRsQLiTjM8DlL0bQ==/7816428162706572.jpg","vid":"417182","aliaName":"","transName":"","alg":null,"markTypes":null},{"type":0,"title":"We Can't Stop","durationms":270000,"creator":[{"userId":29709,"userName":"Boyce Avenue"},{"userId":908180,"userName":"Bea Miller"}],"playTime":2645550,"coverUrl":"http://p4.music.126.net/WHAEMytmYQ4zJ59X5RfDsw==/1393081244780048.jpg","vid":"5341010","aliaName":"","transName":"","alg":null,"markTypes":null},{"type":0,"title":"I Just Wanna Run","durationms":225000,"creator":[{"userId":103121,"userName":"The Downtown Fiction"}],"playTime":3930778,"coverUrl":"http://p4.music.126.net/5I91DlYcMxAu4hFFwYcszQ==/1419469513697830.jpg","vid":"5293276","aliaName":null,"transName":null,"alg":null,"markTypes":null},{"type":0,"title":"Here With You","durationms":231000,"creator":[{"userId":28727,"userName":"Asher Book"}],"playTime":4701933,"coverUrl":"http://p4.music.126.net/LdvAmULKBegAnZVDfEQq7w==/3272146609728028.jpg","vid":"508081","aliaName":"","transName":"","alg":null,"markTypes":null}]
     * hasMore : false
     * count : 6
     */

    private int code;
    private boolean hasMore;
    private int count;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 1
         * title : 霍比特人3:五军之战删减内容，《Star Sky》超燃配乐！
         * durationms : 336022
         * creator : [{"userId":81543567,"userName":"听乐府"}]
         * playTime : 1740475
         * coverUrl : http://p3.music.126.net/cOaWrZ9XkVTtxEVETF_fsg==/109951163573518202.jpg
         * vid : F4B5CCEF49B6F50D8F5F4BE03C128D13
         * aliaName : null
         * transName : null
         * alg : null
         * markTypes : [109]
         */

        private int type;
        private String title;
        private int durationms;
        private int playTime;
        private String coverUrl;
        private String vid;
        private List<CreatorBean> creator;
        private List<Integer> markTypes;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDurationms() {
            return durationms;
        }

        public void setDurationms(int durationms) {
            this.durationms = durationms;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void setPlayTime(int playTime) {
            this.playTime = playTime;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public List<CreatorBean> getCreator() {
            return creator;
        }

        public void setCreator(List<CreatorBean> creator) {
            this.creator = creator;
        }

        public List<Integer> getMarkTypes() {
            return markTypes;
        }

        public void setMarkTypes(List<Integer> markTypes) {
            this.markTypes = markTypes;
        }

        public static class CreatorBean {
            /**
             * userId : 81543567
             * userName : 听乐府
             */

            private int userId;
            private String userName;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }
        }
    }
}
