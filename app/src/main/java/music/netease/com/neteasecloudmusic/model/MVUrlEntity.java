package music.netease.com.neteasecloudmusic.model;

public class MVUrlEntity {

    /**
     * code : 200
     * data : {"id":5341010,"url":"http://vodkgeyttp8.vod.126.net/cloudmusic/ITQ0ITAxMTAgMCAxMSAhIQ==/mv/5341010/9fec8e9666370082b2347f54c045eef9.mp4?wsSecret=fb58efe40159362990d05c6c92f91510&wsTime=1557729091","r":1080,"size":90709735,"md5":"","code":200,"expi":3600,"fee":0,"mvFee":0,"st":0,"msg":""}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5341010
         * url : http://vodkgeyttp8.vod.126.net/cloudmusic/ITQ0ITAxMTAgMCAxMSAhIQ==/mv/5341010/9fec8e9666370082b2347f54c045eef9.mp4?wsSecret=fb58efe40159362990d05c6c92f91510&wsTime=1557729091
         * r : 1080
         * size : 90709735
         * md5 :
         * code : 200
         * expi : 3600
         * fee : 0
         * mvFee : 0
         * st : 0
         * msg :
         */

        private String id;
        private String url;
        private int r;
        private int size;
        private String md5;
        private int code;
        private int expi;
        private int fee;
        private int mvFee;
        private int st;
        private String msg;

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

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getExpi() {
            return expi;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getMvFee() {
            return mvFee;
        }

        public void setMvFee(int mvFee) {
            this.mvFee = mvFee;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
