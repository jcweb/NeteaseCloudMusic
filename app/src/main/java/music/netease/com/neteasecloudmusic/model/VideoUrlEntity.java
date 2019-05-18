package music.netease.com.neteasecloudmusic.model;

import java.util.List;

public class VideoUrlEntity {


    /**
     * urls : [{"id":"F4B5CCEF49B6F50D8F5F4BE03C128D13","url":"http://vodkgeyttp9.vod.126.net/cloudmusic/Hb8J0BAY_1600153727_hd.mp4?wsSecret=a97acf244e455b2f17c7d5fffa95a716&wsTime=1557739723&ext=7oj%2FmC%2BYrjDWag9HhYpwANdr%2FQIbQmhbX5oriJddiuREWYGNBGbH%2Brt7hsskiMkq7DR0JtTrOKZbHBHR6NRpb6pTMCgI17VMZ6yxfK299BIX6OXzRRKC8mWWRmatM8WqDKs%2FYAHYHZgfhnq%2Ft2DX9L4Lyido874VchynySFggerC3Eqi11AnZw2XW2NYALR5","size":45787647,"validityTime":1200,"needPay":false,"payInfo":null,"r":480}]
     * code : 200
     */

    private int code;
    private List<UrlsBean> urls;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<UrlsBean> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlsBean> urls) {
        this.urls = urls;
    }

    public static class UrlsBean {
        /**
         * id : F4B5CCEF49B6F50D8F5F4BE03C128D13
         * url : http://vodkgeyttp9.vod.126.net/cloudmusic/Hb8J0BAY_1600153727_hd.mp4?wsSecret=a97acf244e455b2f17c7d5fffa95a716&wsTime=1557739723&ext=7oj%2FmC%2BYrjDWag9HhYpwANdr%2FQIbQmhbX5oriJddiuREWYGNBGbH%2Brt7hsskiMkq7DR0JtTrOKZbHBHR6NRpb6pTMCgI17VMZ6yxfK299BIX6OXzRRKC8mWWRmatM8WqDKs%2FYAHYHZgfhnq%2Ft2DX9L4Lyido874VchynySFggerC3Eqi11AnZw2XW2NYALR5
         * size : 45787647
         * validityTime : 1200
         * needPay : false
         * payInfo : null
         * r : 480
         */

        private String id;
        private String url;
        private int size;
        private int validityTime;
        private boolean needPay;
        private int r;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getValidityTime() {
            return validityTime;
        }

        public void setValidityTime(int validityTime) {
            this.validityTime = validityTime;
        }

        public boolean isNeedPay() {
            return needPay;
        }

        public void setNeedPay(boolean needPay) {
            this.needPay = needPay;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }
    }
}
