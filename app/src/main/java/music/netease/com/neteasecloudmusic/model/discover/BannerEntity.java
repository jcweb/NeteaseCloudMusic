package music.netease.com.neteasecloudmusic.model.discover;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

public class BannerEntity extends SimpleBannerInfo {
    /**
     * pic : http://p1.music.126.net/zFeNbxl1ZWLUPpJVt4ayEA==/109951164078764516.jpg
     * targetId : 1365657862
     * adid : null
     * targetType : 1
     * titleColor : red
     * typeTitle : 独家
     * url : null
     * adurlV2 : null
     * exclusive : false
     * monitorImpress : null
     * monitorClick : null
     * monitorType : null
     * monitorImpressList : []
     * monitorClickList : []
     * monitorBlackList : null
     * extMonitor : null
     * extMonitorInfo : null
     * adSource : null
     * adLocation : null
     * encodeId : 1365657862
     * program : null
     * event : null
     * video : null
     * song : {"name":"Lovebird (Remix)","id":1365657862,"pst":0,"t":0,"ar":[{"id":92526,"name":"Far East Movement","tns":[],"alias":[]},{"id":1047015,"name":"张艺兴","tns":[],"alias":[]}],"alia":[],"pop":0,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":79164184,"name":"Lovebird (Remix)","picUrl":"http://p1.music.126.net/IfcW6N5vKzF8AyD40esCiw==/109951164079562852.jpg","tns":[],"pic_str":"109951164079562852","pic":109951164079562850},"dt":173333,"h":{"br":320000,"fid":0,"size":6936076,"vd":-62145},"m":{"br":192000,"fid":0,"size":4161663,"vd":-59563},"l":{"br":128000,"fid":0,"size":2774457,"vd":-57936},"a":null,"cd":"01","no":2,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"rtype":0,"rurl":null,"mst":9,"cp":1405820,"mv":0,"publishTime":0,"privilege":{"id":1365657862,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":68,"preSell":false}}
     * bannerId : 1558016318919884
     * alg : null
     * scm : 1.music-homepage.homepage_banner_force.banner.446418.1967632607.null
     * requestId :
     * showAdTag : true
     * pid : null
     */

    private String pic;
    private long targetId;
    private Object adid;
    private int targetType;
    private String titleColor;
    private String typeTitle;
    private Object url;
    private Object adurlV2;
    private boolean exclusive;
    private Object monitorImpress;
    private Object monitorClick;
    private Object monitorType;
    private Object monitorBlackList;
    private Object extMonitor;
    private Object extMonitorInfo;
    private Object adSource;
    private Object adLocation;
    private String encodeId;
    private Object program;
    private Object event;
    private Object video;
    private SongBean song;
    private String bannerId;
    private Object alg;
    private String scm;
    private String requestId;
    private boolean showAdTag;
    private Object pid;
    private List<?> monitorImpressList;
    private List<?> monitorClickList;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public Object getAdid() {
        return adid;
    }

    public void setAdid(Object adid) {
        this.adid = adid;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getAdurlV2() {
        return adurlV2;
    }

    public void setAdurlV2(Object adurlV2) {
        this.adurlV2 = adurlV2;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Object getMonitorImpress() {
        return monitorImpress;
    }

    public void setMonitorImpress(Object monitorImpress) {
        this.monitorImpress = monitorImpress;
    }

    public Object getMonitorClick() {
        return monitorClick;
    }

    public void setMonitorClick(Object monitorClick) {
        this.monitorClick = monitorClick;
    }

    public Object getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Object monitorType) {
        this.monitorType = monitorType;
    }

    public Object getMonitorBlackList() {
        return monitorBlackList;
    }

    public void setMonitorBlackList(Object monitorBlackList) {
        this.monitorBlackList = monitorBlackList;
    }

    public Object getExtMonitor() {
        return extMonitor;
    }

    public void setExtMonitor(Object extMonitor) {
        this.extMonitor = extMonitor;
    }

    public Object getExtMonitorInfo() {
        return extMonitorInfo;
    }

    public void setExtMonitorInfo(Object extMonitorInfo) {
        this.extMonitorInfo = extMonitorInfo;
    }

    public Object getAdSource() {
        return adSource;
    }

    public void setAdSource(Object adSource) {
        this.adSource = adSource;
    }

    public Object getAdLocation() {
        return adLocation;
    }

    public void setAdLocation(Object adLocation) {
        this.adLocation = adLocation;
    }

    public String getEncodeId() {
        return encodeId;
    }

    public void setEncodeId(String encodeId) {
        this.encodeId = encodeId;
    }

    public Object getProgram() {
        return program;
    }

    public void setProgram(Object program) {
        this.program = program;
    }

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = video;
    }

    public SongBean getSong() {
        return song;
    }

    public void setSong(SongBean song) {
        this.song = song;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public Object getAlg() {
        return alg;
    }

    public void setAlg(Object alg) {
        this.alg = alg;
    }

    public String getScm() {
        return scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isShowAdTag() {
        return showAdTag;
    }

    public void setShowAdTag(boolean showAdTag) {
        this.showAdTag = showAdTag;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public List<?> getMonitorImpressList() {
        return monitorImpressList;
    }

    public void setMonitorImpressList(List<?> monitorImpressList) {
        this.monitorImpressList = monitorImpressList;
    }

    public List<?> getMonitorClickList() {
        return monitorClickList;
    }

    public void setMonitorClickList(List<?> monitorClickList) {
        this.monitorClickList = monitorClickList;
    }

    public static class SongBean {
        /**
         * name : Lovebird (Remix)
         * id : 1365657862
         * pst : 0
         * t : 0
         * ar : [{"id":92526,"name":"Far East Movement","tns":[],"alias":[]},{"id":1047015,"name":"张艺兴","tns":[],"alias":[]}]
         * alia : []
         * pop : 0
         * st : 0
         * rt :
         * fee : 8
         * v : 6
         * crbt : null
         * cf :
         * al : {"id":79164184,"name":"Lovebird (Remix)","picUrl":"http://p1.music.126.net/IfcW6N5vKzF8AyD40esCiw==/109951164079562852.jpg","tns":[],"pic_str":"109951164079562852","pic":109951164079562850}
         * dt : 173333
         * h : {"br":320000,"fid":0,"size":6936076,"vd":-62145}
         * m : {"br":192000,"fid":0,"size":4161663,"vd":-59563}
         * l : {"br":128000,"fid":0,"size":2774457,"vd":-57936}
         * a : null
         * cd : 01
         * no : 2
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * djId : 0
         * copyright : 0
         * s_id : 0
         * rtype : 0
         * rurl : null
         * mst : 9
         * cp : 1405820
         * mv : 0
         * publishTime : 0
         * privilege : {"id":1365657862,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":68,"preSell":false}
         */

        private String name;
        private long id;
        private int pst;
        private int t;
        private int pop;
        private int st;
        private String rt;
        private int fee;
        private int v;
        private Object crbt;
        private String cf;
        private AlBean al;
        private int dt;
        private HBean h;
        private MBean m;
        private LBean l;
        private Object a;
        private String cd;
        private int no;
        private Object rtUrl;
        private int ftype;
        private int djId;
        private int copyright;
        private int s_id;
        private int rtype;
        private Object rurl;
        private int mst;
        private int cp;
        private int mv;
        private int publishTime;
        private PrivilegeBean privilege;
        private List<ArBean> ar;
        private List<?> alia;
        private List<?> rtUrls;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getPst() {
            return pst;
        }

        public void setPst(int pst) {
            this.pst = pst;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        public int getPop() {
            return pop;
        }

        public void setPop(int pop) {
            this.pop = pop;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public String getRt() {
            return rt;
        }

        public void setRt(String rt) {
            this.rt = rt;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public Object getCrbt() {
            return crbt;
        }

        public void setCrbt(Object crbt) {
            this.crbt = crbt;
        }

        public String getCf() {
            return cf;
        }

        public void setCf(String cf) {
            this.cf = cf;
        }

        public AlBean getAl() {
            return al;
        }

        public void setAl(AlBean al) {
            this.al = al;
        }

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public HBean getH() {
            return h;
        }

        public void setH(HBean h) {
            this.h = h;
        }

        public MBean getM() {
            return m;
        }

        public void setM(MBean m) {
            this.m = m;
        }

        public LBean getL() {
            return l;
        }

        public void setL(LBean l) {
            this.l = l;
        }

        public Object getA() {
            return a;
        }

        public void setA(Object a) {
            this.a = a;
        }

        public String getCd() {
            return cd;
        }

        public void setCd(String cd) {
            this.cd = cd;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Object getRtUrl() {
            return rtUrl;
        }

        public void setRtUrl(Object rtUrl) {
            this.rtUrl = rtUrl;
        }

        public int getFtype() {
            return ftype;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
        }

        public int getDjId() {
            return djId;
        }

        public void setDjId(int djId) {
            this.djId = djId;
        }

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public int getS_id() {
            return s_id;
        }

        public void setS_id(int s_id) {
            this.s_id = s_id;
        }

        public int getRtype() {
            return rtype;
        }

        public void setRtype(int rtype) {
            this.rtype = rtype;
        }

        public Object getRurl() {
            return rurl;
        }

        public void setRurl(Object rurl) {
            this.rurl = rurl;
        }

        public int getMst() {
            return mst;
        }

        public void setMst(int mst) {
            this.mst = mst;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getMv() {
            return mv;
        }

        public void setMv(int mv) {
            this.mv = mv;
        }

        public int getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(int publishTime) {
            this.publishTime = publishTime;
        }

        public PrivilegeBean getPrivilege() {
            return privilege;
        }

        public void setPrivilege(PrivilegeBean privilege) {
            this.privilege = privilege;
        }

        public List<ArBean> getAr() {
            return ar;
        }

        public void setAr(List<ArBean> ar) {
            this.ar = ar;
        }

        public List<?> getAlia() {
            return alia;
        }

        public void setAlia(List<?> alia) {
            this.alia = alia;
        }

        public List<?> getRtUrls() {
            return rtUrls;
        }

        public void setRtUrls(List<?> rtUrls) {
            this.rtUrls = rtUrls;
        }

        public static class AlBean {
            /**
             * id : 79164184
             * name : Lovebird (Remix)
             * picUrl : http://p1.music.126.net/IfcW6N5vKzF8AyD40esCiw==/109951164079562852.jpg
             * tns : []
             * pic_str : 109951164079562852
             * pic : 109951164079562850
             */

            private long id;
            private String name;
            private String picUrl;
            private String pic_str;
            private long pic;
            private List<?> tns;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getPic_str() {
                return pic_str;
            }

            public void setPic_str(String pic_str) {
                this.pic_str = pic_str;
            }

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public List<?> getTns() {
                return tns;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }
        }

        public static class HBean {
            /**
             * br : 320000
             * fid : 0
             * size : 6936076
             * vd : -62145
             */

            private long br;
            private int fid;
            private int size;
            private int vd;

            public long getBr() {
                return br;
            }

            public void setBr(long br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }
        }

        public static class MBean {
            /**
             * br : 192000
             * fid : 0
             * size : 4161663
             * vd : -59563
             */

            private long br;
            private int fid;
            private int size;
            private int vd;

            public long getBr() {
                return br;
            }

            public void setBr(long br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }
        }

        public static class LBean {
            /**
             * br : 128000
             * fid : 0
             * size : 2774457
             * vd : -57936
             */

            private int br;
            private int fid;
            private int size;
            private int vd;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }
        }

        public static class PrivilegeBean {
            /**
             * id : 1365657862
             * fee : 8
             * payed : 0
             * st : 0
             * pl : 128000
             * dl : 0
             * sp : 7
             * cp : 1
             * subp : 1
             * cs : false
             * maxbr : 999000
             * fl : 128000
             * toast : false
             * flag : 68
             * preSell : false
             */

            private long id;
            private int fee;
            private int payed;
            private int st;
            private int pl;
            private int dl;
            private int sp;
            private int cp;
            private int subp;
            private boolean cs;
            private int maxbr;
            private int fl;
            private boolean toast;
            private int flag;
            private boolean preSell;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getPayed() {
                return payed;
            }

            public void setPayed(int payed) {
                this.payed = payed;
            }

            public int getSt() {
                return st;
            }

            public void setSt(int st) {
                this.st = st;
            }

            public int getPl() {
                return pl;
            }

            public void setPl(int pl) {
                this.pl = pl;
            }

            public int getDl() {
                return dl;
            }

            public void setDl(int dl) {
                this.dl = dl;
            }

            public int getSp() {
                return sp;
            }

            public void setSp(int sp) {
                this.sp = sp;
            }

            public int getCp() {
                return cp;
            }

            public void setCp(int cp) {
                this.cp = cp;
            }

            public int getSubp() {
                return subp;
            }

            public void setSubp(int subp) {
                this.subp = subp;
            }

            public boolean isCs() {
                return cs;
            }

            public void setCs(boolean cs) {
                this.cs = cs;
            }

            public int getMaxbr() {
                return maxbr;
            }

            public void setMaxbr(int maxbr) {
                this.maxbr = maxbr;
            }

            public int getFl() {
                return fl;
            }

            public void setFl(int fl) {
                this.fl = fl;
            }

            public boolean isToast() {
                return toast;
            }

            public void setToast(boolean toast) {
                this.toast = toast;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public boolean isPreSell() {
                return preSell;
            }

            public void setPreSell(boolean preSell) {
                this.preSell = preSell;
            }
        }

        public static class ArBean {
            /**
             * id : 92526
             * name : Far East Movement
             * tns : []
             * alias : []
             */

            private int id;
            private String name;
            private List<?> tns;
            private List<?> alias;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<?> getTns() {
                return tns;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
