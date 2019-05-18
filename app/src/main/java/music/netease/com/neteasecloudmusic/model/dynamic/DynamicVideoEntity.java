package music.netease.com.neteasecloudmusic.model.dynamic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DynamicVideoEntity {

    /**
     * msg : 霸气九尾和须佐能乎完美结合，太帅了吧！
     * video : {"vid":0,"coverUrl":"http://p3.music.126.net/qgxlKtAsikTXFkEY6AFmzQ==/109951163942569240.jpg","duration":215,"playTime":41185,"height":720,"width":1280,"size":25436259,"state":1,"coverType":0,"urlInfo":null,"videoId":"025F600A1A2B2A9106703006BED35437","threadId":null,"title":"【火影忍者】九尾 须佐能乎 鸣人 佐助VS大筒木桃式","description":null,"creator":{"defaultAvatar":false,"province":510000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/7oStaqQ9KAi6yByE_WRnEg==/109951164070589780.jpg","accountStatus":0,"gender":1,"city":510100,"birthday":872006400000,"userId":1632875089,"userType":4,"nickname":"没有牌面儿的小無名","signature":"生亦何欢 死亦何苦","description":"","detailDescription":"","avatarImgId":109951164070589780,"backgroundImgId":109951164070599514,"backgroundUrl":"http://p1.music.126.net/VzyirqhhAMjobD-D6f51dw==/109951164070599514.jpg","authority":0,"mutual":false,"expertTags":null,"experts":{"2":"音乐|生活图文达人"},"djStatus":10,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951164070589780","backgroundImgIdStr":"109951164070599514","avatarImgId_str":"109951164070589780"},"videoStatus":0,"resolutions":[{"resolution":0,"size":25436259},{"resolution":0,"size":39037727},{"resolution":0,"size":51524209}],"durationms":215000}
     */

    private String msg;
    private VideoBean video;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public static class VideoBean {
        /**
         * vid : 0
         * coverUrl : http://p3.music.126.net/qgxlKtAsikTXFkEY6AFmzQ==/109951163942569240.jpg
         * duration : 215
         * playTime : 41185
         * height : 720
         * width : 1280
         * size : 25436259
         * state : 1
         * coverType : 0
         * urlInfo : null
         * videoId : 025F600A1A2B2A9106703006BED35437
         * threadId : null
         * title : 【火影忍者】九尾 须佐能乎 鸣人 佐助VS大筒木桃式
         * description : null
         * creator : {"defaultAvatar":false,"province":510000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/7oStaqQ9KAi6yByE_WRnEg==/109951164070589780.jpg","accountStatus":0,"gender":1,"city":510100,"birthday":872006400000,"userId":1632875089,"userType":4,"nickname":"没有牌面儿的小無名","signature":"生亦何欢 死亦何苦","description":"","detailDescription":"","avatarImgId":109951164070589780,"backgroundImgId":109951164070599514,"backgroundUrl":"http://p1.music.126.net/VzyirqhhAMjobD-D6f51dw==/109951164070599514.jpg","authority":0,"mutual":false,"expertTags":null,"experts":{"2":"音乐|生活图文达人"},"djStatus":10,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951164070589780","backgroundImgIdStr":"109951164070599514","avatarImgId_str":"109951164070589780"}
         * videoStatus : 0
         * resolutions : [{"resolution":0,"size":25436259},{"resolution":0,"size":39037727},{"resolution":0,"size":51524209}]
         * durationms : 215000
         */

        private int vid;
        private String coverUrl;
        private int duration;
        private int playTime;
        private int height;
        private int width;
        private int size;
        private int state;
        private int coverType;
        private Object urlInfo;
        private String videoId;
        private Object threadId;
        private String title;
        private Object description;
        private CreatorBean creator;
        private int videoStatus;
        private int durationms;
        private List<ResolutionsBean> resolutions;

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void setPlayTime(int playTime) {
            this.playTime = playTime;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getCoverType() {
            return coverType;
        }

        public void setCoverType(int coverType) {
            this.coverType = coverType;
        }

        public Object getUrlInfo() {
            return urlInfo;
        }

        public void setUrlInfo(Object urlInfo) {
            this.urlInfo = urlInfo;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public Object getThreadId() {
            return threadId;
        }

        public void setThreadId(Object threadId) {
            this.threadId = threadId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public int getVideoStatus() {
            return videoStatus;
        }

        public void setVideoStatus(int videoStatus) {
            this.videoStatus = videoStatus;
        }

        public int getDurationms() {
            return durationms;
        }

        public void setDurationms(int durationms) {
            this.durationms = durationms;
        }

        public List<ResolutionsBean> getResolutions() {
            return resolutions;
        }

        public void setResolutions(List<ResolutionsBean> resolutions) {
            this.resolutions = resolutions;
        }

        public static class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 510000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/7oStaqQ9KAi6yByE_WRnEg==/109951164070589780.jpg
             * accountStatus : 0
             * gender : 1
             * city : 510100
             * birthday : 872006400000
             * userId : 1632875089
             * userType : 4
             * nickname : 没有牌面儿的小無名
             * signature : 生亦何欢 死亦何苦
             * description :
             * detailDescription :
             * avatarImgId : 109951164070589780
             * backgroundImgId : 109951164070599514
             * backgroundUrl : http://p1.music.126.net/VzyirqhhAMjobD-D6f51dw==/109951164070599514.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : {"2":"音乐|生活图文达人"}
             * djStatus : 10
             * vipType : 11
             * remarkName : null
             * avatarImgIdStr : 109951164070589780
             * backgroundImgIdStr : 109951164070599514
             * avatarImgId_str : 109951164070589780
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
            private int userId;
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
            private ExpertsBean experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private String avatarImgId_str;

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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
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

            public ExpertsBean getExperts() {
                return experts;
            }

            public void setExperts(ExpertsBean experts) {
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

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }

            public static class ExpertsBean {
                /**
                 * 2 : 音乐|生活图文达人
                 */

                @SerializedName("2")
                private String _$2;

                public String get_$2() {
                    return _$2;
                }

                public void set_$2(String _$2) {
                    this._$2 = _$2;
                }
            }
        }

        public static class ResolutionsBean {
            /**
             * resolution : 0
             * size : 25436259
             */

            private int resolution;
            private long size;

            public int getResolution() {
                return resolution;
            }

            public void setResolution(int resolution) {
                this.resolution = resolution;
            }

            public long getSize() {
                return size;
            }

            public void setSize(long size) {
                this.size = size;
            }
        }
    }
}
