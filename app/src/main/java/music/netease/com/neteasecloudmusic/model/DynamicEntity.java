package music.netease.com.neteasecloudmusic.model;

import java.util.List;

public class DynamicEntity extends BaseEntity{

    /**
     * actName : null
     * forwardCount : 0
     * lotteryEventData : null
     * user : {"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/gwy7eEuqIiSXXy3aqtJJ0g==/109951164053318540.jpg","accountStatus":0,"gender":0,"city":440600,"birthday":-2209017600000,"userId":118006451,"userType":0,"nickname":"eijnhec","signature":"","description":"","detailDescription":"","avatarImgId":109951164053318540,"backgroundImgId":2002210674180198,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164053318540","backgroundImgIdStr":"2002210674180198","urlAnalyze":false,"avatarImgId_str":"109951164053318540","followeds":0}
     * uuid : 3b60f4041926357f4028b72fdf0aa97c
     * expireTime : 0
     * eventTime : 1557919989084
     * json : {"msg":"测试"}
     * rcmdInfo : null
     * tmplId : 0
     * pics : [{"width":1080,"height":1920,"originUrl":"https://p1.music.126.net/nUfgg3JEm-b00PKqH0diMQ==/109951164076115524.jpg","squareUrl":"https://p1.music.126.net/gNTcqnRDgGOIqN-VB57sUA==/109951164076105895.jpg","rectangleUrl":"https://p1.music.126.net/FSKSxAS_tuOOczcdVJxKUw==/109951164076108763.jpg","pcSquareUrl":"https://p1.music.126.net/Co1oMwe_pxMcjVAJbayTDQ==/109951164076103496.jpg","pcRectangleUrl":"https://p1.music.126.net/NxfCCkGqr3-bEZGc5gsVvA==/109951164076108321.jpg","format":"jpg"}]
     * showTime : 1557919989084
     * actId : 0
     * id : 7010811133
     * type : 35
     * topEvent : false
     * insiteForwardCount : 0
     * info : {"commentThread":{"id":"A_EV_2_7010811133_118006451","resourceInfo":null,"resourceType":2,"commentCount":0,"likedCount":0,"shareCount":0,"hotCount":0,"latestLikedUsers":null,"resourceId":0,"resourceOwnerId":0,"resourceTitle":null},"latestLikedUsers":null,"liked":false,"comments":null,"resourceType":2,"resourceId":7010811133,"commentCount":0,"likedCount":0,"shareCount":0,"threadId":"A_EV_2_7010811133_118006451"}
     */

    private int forwardCount;
    private UserBean user;
    private String uuid;
    private long expireTime;
    private long eventTime;
    private String json;
    private Object rcmdInfo;
    private int tmplId;
    private long showTime;
    private int actId;
    private long id;
    private int type;
    private boolean topEvent;
    private int insiteForwardCount;
    private InfoBean info;
    private List<PicsBean> pics;

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Object getRcmdInfo() {
        return rcmdInfo;
    }

    public void setRcmdInfo(Object rcmdInfo) {
        this.rcmdInfo = rcmdInfo;
    }

    public int getTmplId() {
        return tmplId;
    }

    public void setTmplId(int tmplId) {
        this.tmplId = tmplId;
    }

    public long getShowTime() {
        return showTime;
    }

    public void setShowTime(long showTime) {
        this.showTime = showTime;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isTopEvent() {
        return topEvent;
    }

    public void setTopEvent(boolean topEvent) {
        this.topEvent = topEvent;
    }

    public int getInsiteForwardCount() {
        return insiteForwardCount;
    }

    public void setInsiteForwardCount(int insiteForwardCount) {
        this.insiteForwardCount = insiteForwardCount;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<PicsBean> getPics() {
        return pics;
    }

    public void setPics(List<PicsBean> pics) {
        this.pics = pics;
    }

    public static class UserBean {
        /**
         * defaultAvatar : false
         * province : 440000
         * authStatus : 0
         * followed : false
         * avatarUrl : http://p1.music.126.net/gwy7eEuqIiSXXy3aqtJJ0g==/109951164053318540.jpg
         * accountStatus : 0
         * gender : 0
         * city : 440600
         * birthday : -2209017600000
         * userId : 118006451
         * userType : 0
         * nickname : eijnhec
         * signature :
         * description :
         * detailDescription :
         * avatarImgId : 109951164053318540
         * backgroundImgId : 2002210674180198
         * backgroundUrl : http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg
         * authority : 0
         * mutual : false
         * expertTags : null
         * experts : null
         * djStatus : 10
         * vipType : 0
         * remarkName : null
         * avatarImgIdStr : 109951164053318540
         * backgroundImgIdStr : 2002210674180198
         * urlAnalyze : false
         * avatarImgId_str : 109951164053318540
         * followeds : 0
         */

        private boolean defaultAvatar;
        private int province;
        private int authStatus;
        private boolean followed;
        private String avatarUrl;
        private int accountStatus;
        private int gender;
        private int city;
        private long birthday;
        private long userId;
        private int userType;
        private String nickname;
        private String signature;
        private String description;
        private String detailDescription;
        private long avatarImgId;
        private long backgroundImgId;
        private String backgroundUrl;
        private int authority;
        private boolean mutual;
        private Object expertTags;
        private Object experts;
        private int djStatus;
        private int vipType;
        private Object remarkName;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private boolean urlAnalyze;
        private String avatarImgId_str;
        private int followeds;

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public Object getExperts() {
            return experts;
        }

        public void setExperts(Object experts) {
            this.experts = experts;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public boolean isUrlAnalyze() {
            return urlAnalyze;
        }

        public void setUrlAnalyze(boolean urlAnalyze) {
            this.urlAnalyze = urlAnalyze;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }
    }

    public static class InfoBean {
        /**
         * commentThread : {"id":"A_EV_2_7010811133_118006451","resourceInfo":null,"resourceType":2,"commentCount":0,"likedCount":0,"shareCount":0,"hotCount":0,"latestLikedUsers":null,"resourceId":0,"resourceOwnerId":0,"resourceTitle":null}
         * latestLikedUsers : null
         * liked : false
         * comments : null
         * resourceType : 2
         * resourceId : 7010811133
         * commentCount : 0
         * likedCount : 0
         * shareCount : 0
         * threadId : A_EV_2_7010811133_118006451
         */

        private CommentThreadBean commentThread;
        private Object latestLikedUsers;
        private boolean liked;
        private Object comments;
        private int resourceType;
        private long resourceId;
        private int commentCount;
        private int likedCount;
        private int shareCount;
        private String threadId;

        public CommentThreadBean getCommentThread() {
            return commentThread;
        }

        public void setCommentThread(CommentThreadBean commentThread) {
            this.commentThread = commentThread;
        }

        public Object getLatestLikedUsers() {
            return latestLikedUsers;
        }

        public void setLatestLikedUsers(Object latestLikedUsers) {
            this.latestLikedUsers = latestLikedUsers;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public Object getComments() {
            return comments;
        }

        public void setComments(Object comments) {
            this.comments = comments;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public long getResourceId() {
            return resourceId;
        }

        public void setResourceId(long String) {
            this.resourceId = resourceId;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getThreadId() {
            return threadId;
        }

        public void setThreadId(String threadId) {
            this.threadId = threadId;
        }

        public static class CommentThreadBean {
            /**
             * id : A_EV_2_7010811133_118006451
             * resourceInfo : null
             * resourceType : 2
             * commentCount : 0
             * likedCount : 0
             * shareCount : 0
             * hotCount : 0
             * latestLikedUsers : null
             * resourceId : 0
             * resourceOwnerId : 0
             * resourceTitle : null
             */

            private String id;
            private Object resourceInfo;
            private int resourceType;
            private int commentCount;
            private int likedCount;
            private int shareCount;
            private int hotCount;
            private Object latestLikedUsers;
            private long resourceId;
            private int resourceOwnerId;
            private Object resourceTitle;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Object getResourceInfo() {
                return resourceInfo;
            }

            public void setResourceInfo(Object resourceInfo) {
                this.resourceInfo = resourceInfo;
            }

            public int getResourceType() {
                return resourceType;
            }

            public void setResourceType(int resourceType) {
                this.resourceType = resourceType;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public int getLikedCount() {
                return likedCount;
            }

            public void setLikedCount(int likedCount) {
                this.likedCount = likedCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getHotCount() {
                return hotCount;
            }

            public void setHotCount(int hotCount) {
                this.hotCount = hotCount;
            }

            public Object getLatestLikedUsers() {
                return latestLikedUsers;
            }

            public void setLatestLikedUsers(Object latestLikedUsers) {
                this.latestLikedUsers = latestLikedUsers;
            }

            public long getResourceId() {
                return resourceId;
            }

            public void setResourceId(long resourceId) {
                this.resourceId = resourceId;
            }

            public int getResourceOwnerId() {
                return resourceOwnerId;
            }

            public void setResourceOwnerId(int resourceOwnerId) {
                this.resourceOwnerId = resourceOwnerId;
            }

            public Object getResourceTitle() {
                return resourceTitle;
            }

            public void setResourceTitle(Object resourceTitle) {
                this.resourceTitle = resourceTitle;
            }
        }
    }

    public static class PicsBean {
        /**
         * width : 1080
         * height : 1920
         * originUrl : https://p1.music.126.net/nUfgg3JEm-b00PKqH0diMQ==/109951164076115524.jpg
         * squareUrl : https://p1.music.126.net/gNTcqnRDgGOIqN-VB57sUA==/109951164076105895.jpg
         * rectangleUrl : https://p1.music.126.net/FSKSxAS_tuOOczcdVJxKUw==/109951164076108763.jpg
         * pcSquareUrl : https://p1.music.126.net/Co1oMwe_pxMcjVAJbayTDQ==/109951164076103496.jpg
         * pcRectangleUrl : https://p1.music.126.net/NxfCCkGqr3-bEZGc5gsVvA==/109951164076108321.jpg
         * format : jpg
         */

        private int width;
        private int height;
        private String originUrl;
        private String squareUrl;
        private String rectangleUrl;
        private String pcSquareUrl;
        private String pcRectangleUrl;
        private String format;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getOriginUrl() {
            return originUrl;
        }

        public void setOriginUrl(String originUrl) {
            this.originUrl = originUrl;
        }

        public String getSquareUrl() {
            return squareUrl;
        }

        public void setSquareUrl(String squareUrl) {
            this.squareUrl = squareUrl;
        }

        public String getRectangleUrl() {
            return rectangleUrl;
        }

        public void setRectangleUrl(String rectangleUrl) {
            this.rectangleUrl = rectangleUrl;
        }

        public String getPcSquareUrl() {
            return pcSquareUrl;
        }

        public void setPcSquareUrl(String pcSquareUrl) {
            this.pcSquareUrl = pcSquareUrl;
        }

        public String getPcRectangleUrl() {
            return pcRectangleUrl;
        }

        public void setPcRectangleUrl(String pcRectangleUrl) {
            this.pcRectangleUrl = pcRectangleUrl;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }
}
