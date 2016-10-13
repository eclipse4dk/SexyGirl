package com.example.administrator.sexygirl;

import java.util.List;

/**
 * 创建者:   Leon
 * 创建时间:  2016/10/11 14:42
 * 描述：    TODO
 */
public class GalleryBean {
    public static final String TAG = "GalleryBean";

    /**
     * status : true
     * total : 951
     * tngou : [{"count":193,"fcount":0,"galleryclass":5,"id":965,"img":"/ext/161008/93ad433c8a718712400cef236adab3f3.jpg","rcount":0,"size":12,"time":1475926279000,"title":"高雅气质美女孙允珠斜搭肩礼服摄影写真"},{"count":171,"fcount":0,"galleryclass":3,"id":964,"img":"/ext/161008/fcd0c0e31c384b2546da654070091101.jpg","rcount":0,"size":12,"time":1475926243000,"title":"腿模Kaylar靓丽红裙长腿丝袜养眼美女"},{"count":289,"fcount":0,"galleryclass":1,"id":963,"img":"/ext/161008/a1056dbbe883a636391b386a438313d9.jpg","rcount":0,"size":20,"time":1475926166000,"title":"OL美女孙允珠性感吊带开叉红裙"},{"count":257,"fcount":0,"galleryclass":3,"id":962,"img":"/ext/161007/cd0f5d1727b1ec585f3be106f0c27700.jpg","rcount":0,"size":10,"time":1475823937000,"title":"极致喷血诱惑性感腿模小雪黑丝长腿高清人体艺术写真照图片"},{"count":168,"fcount":0,"galleryclass":7,"id":961,"img":"/ext/161007/bb3b3ae4caa1fbc1a49ee461b9396b55.jpg","rcount":0,"size":9,"time":1475823835000,"title":"爆乳翘臀美女秘书大胆黑丝吊腿丝袜"},{"count":113,"fcount":0,"galleryclass":3,"id":960,"img":"/ext/161007/44a11ac952e3e58654870fc7209fe111.jpg","rcount":0,"size":7,"time":1475823694000,"title":"穿着白色高跟鞋的极品嫩模美女极致丝袜美腿诱惑"},{"count":521,"fcount":0,"galleryclass":1,"id":959,"img":"/ext/161005/d70a3a2490bb2e84bba61051dcb2684b.jpg","rcount":0,"size":7,"time":1475659542000,"title":"清秀长发美女户外性感露背吊带裙妩媚性感写真"},{"count":322,"fcount":0,"galleryclass":5,"id":958,"img":"/ext/161005/d8991fee68a2149a62f246a974e79230.jpg","rcount":0,"size":9,"time":1475659488000,"title":"大胸美女李妍静性感低胸装私房"},{"count":592,"fcount":0,"galleryclass":4,"id":957,"img":"/ext/160929/95a4b6c26aff1f84a362ace920ed06e2.jpg","rcount":0,"size":22,"time":1475151767000,"title":"长发美女李妍静杏粉裸肩性感低胸长礼裙"},{"count":482,"fcount":0,"galleryclass":1,"id":956,"img":"/ext/160929/78d6d592b9c18552c182b3cccb1c0b3c.jpg","rcount":0,"size":31,"time":1475151452000,"title":"职业白领孙允珠流苏叉腿连衣裙性感"},{"count":506,"fcount":0,"galleryclass":3,"id":955,"img":"/ext/160928/099120d44fcfc0e358c4db4143ab50b1.jpg","rcount":0,"size":9,"time":1475061217000,"title":"极品宅男女神黑丝美腿私房妩媚性感写真卷发美女"},{"count":465,"fcount":0,"galleryclass":1,"id":954,"img":"/ext/160928/0372444674e18bfc99dec2bba8e24f00.jpg","rcount":0,"size":9,"time":1475061163000,"title":"宅男女神紧致魅惑身姿性感酒店写真"},{"count":241,"fcount":0,"galleryclass":4,"id":953,"img":"/ext/160927/3caa34a54fc778a3b7064a430060b0cb.jpg","rcount":0,"size":9,"time":1474976710000,"title":"极品长腿美女模特紧身包裙气质写真卷发美女"},{"count":529,"fcount":0,"galleryclass":5,"id":952,"img":"/ext/160927/dce4c88e736438c2d33da17bf375596d.jpg","rcount":0,"size":9,"time":1474976668000,"title":"性感少妇风情万种撩人"},{"count":1035,"fcount":0,"galleryclass":4,"id":951,"img":"/ext/160923/ab7a2923992749ac33a54281b847512e.jpg","rcount":0,"size":9,"time":1474601069000,"title":"大胸美女李妍静印花短裙美腿酥胸性感"},{"count":399,"fcount":0,"galleryclass":5,"id":950,"img":"/ext/160923/d32b655dd4fad3079bbaf2c2db3522dc.jpg","rcount":0,"size":9,"time":1474601032000,"title":"李妍静深V美腿优雅红裙性感写真"},{"count":888,"fcount":0,"galleryclass":5,"id":949,"img":"/ext/160921/6199ab6553bf459e5860557d6c7d0a15.jpg","rcount":0,"size":9,"time":1474425727000,"title":"大胸美女孙允珠蕾丝上装红色包臀"},{"count":776,"fcount":0,"galleryclass":3,"id":948,"img":"/ext/160921/578ed5603b79999d9b5e275c2a1d7f73.jpg","rcount":0,"size":9,"time":1474425584000,"title":"丝袜美女Sara性感私房美腿"},{"count":577,"fcount":0,"galleryclass":3,"id":947,"img":"/ext/160921/af9e403699032ddacacfc57a129ffc7d.jpg","rcount":0,"size":6,"time":1474425526000,"title":"长腿性感女神美腿翘臀极品性感"},{"count":1647,"fcount":0,"galleryclass":1,"id":946,"img":"/ext/160921/eeb634135dcfc854ce3ae2bd1b36e2ce.jpg","rcount":0,"size":10,"time":1474425208000,"title":"性感大胸美女白领林正允巨乳性感诱人气质卷发美女图片"}]
     */

    private boolean status;
    private int total;
    /**
     * count : 193
     * fcount : 0
     * galleryclass : 5
     * id : 965
     * img : /ext/161008/93ad433c8a718712400cef236adab3f3.jpg
     * rcount : 0
     * size : 12
     * time : 1475926279000
     * title : 高雅气质美女孙允珠斜搭肩礼服摄影写真
     */

    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;
        private int size;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
