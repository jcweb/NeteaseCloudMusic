package music.netease.com.neteasecloudmusic.model.dynamic;

import java.util.List;

public class DynamicMVEntity {

    /**
     * msg : fukin my 男神[爱心][爱心][爱心][爱心][爱心][爱心][爱心]
     * mv : {"id":5268109,"name":"Untitled 2(live@The Tonight Show Starring Jimmy Fallon)","status":1,"artist":{"name":"Kendrick Lamar","id":37995,"picId":0,"img1v1Id":18686200114669622,"briefDesc":"","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"},"artistName":"Kendrick Lamar","imgurl":"http://p3.music.126.net/pDMTb9WJqHpdknZm3elliA==/3284241236401125.jpg","imgurl16v9":"http://p3.music.126.net/nrizJ9QWe8nv2o3yKO9VoQ==/3396391422471084.jpg","artists":[{"id":37995,"name":"Kendrick Lamar"}],"urlInfo":null,"price":0,"duration":305000,"playCount":74320,"height":720,"width":0}
     */

    private String msg;
    private MvBean mv;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MvBean getMv() {
        return mv;
    }

    public void setMv(MvBean mv) {
        this.mv = mv;
    }

    public static class MvBean {
        /**
         * id : 5268109
         * name : Untitled 2(live@The Tonight Show Starring Jimmy Fallon)
         * status : 1
         * artist : {"name":"Kendrick Lamar","id":37995,"picId":0,"img1v1Id":18686200114669622,"briefDesc":"","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}
         * artistName : Kendrick Lamar
         * imgurl : http://p3.music.126.net/pDMTb9WJqHpdknZm3elliA==/3284241236401125.jpg
         * imgurl16v9 : http://p3.music.126.net/nrizJ9QWe8nv2o3yKO9VoQ==/3396391422471084.jpg
         * artists : [{"id":37995,"name":"Kendrick Lamar"}]
         * urlInfo : null
         * price : 0
         * duration : 305000
         * playCount : 74320
         * height : 720
         * width : 0
         */

        private long id;
        private String name;
        private int status;
        private ArtistBean artist;
        private String artistName;
        private String imgurl;
        private String imgurl16v9;
        private Object urlInfo;
        private int price;
        private int duration;
        private int playCount;
        private int height;
        private int width;
        private List<ArtistsBean> artists;

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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public ArtistBean getArtist() {
            return artist;
        }

        public void setArtist(ArtistBean artist) {
            this.artist = artist;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getImgurl16v9() {
            return imgurl16v9;
        }

        public void setImgurl16v9(String imgurl16v9) {
            this.imgurl16v9 = imgurl16v9;
        }

        public Object getUrlInfo() {
            return urlInfo;
        }

        public void setUrlInfo(Object urlInfo) {
            this.urlInfo = urlInfo;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
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

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public static class ArtistBean {
            /**
             * name : Kendrick Lamar
             * id : 37995
             * picId : 0
             * img1v1Id : 18686200114669622
             * briefDesc :
             * picUrl : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * img1v1Url : http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * albumSize : 0
             * alias : []
             * trans :
             * musicSize : 0
             * topicPerson : 0
             * img1v1Id_str : 18686200114669622
             */

            private String name;
            private int id;
            private long picId;
            private long img1v1Id;
            private String briefDesc;
            private String picUrl;
            private String img1v1Url;
            private int albumSize;
            private String trans;
            private long musicSize;
            private int topicPerson;
            private String img1v1Id_str;
            private List<?> alias;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public long getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(long img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public long getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(long musicSize) {
                this.musicSize = musicSize;
            }

            public int getTopicPerson() {
                return topicPerson;
            }

            public void setTopicPerson(int topicPerson) {
                this.topicPerson = topicPerson;
            }

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }

        public static class ArtistsBean {
            /**
             * id : 37995
             * name : Kendrick Lamar
             */

            private int id;
            private String name;

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
        }
    }
}
