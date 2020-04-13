package com.zy.coolbicycle.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/13
 */
public class RoadBookBean extends BasePageBean<RoadBookBean.DataBean.ListBean> {

    /**
     * status : 0
     * data : {"cateList":[{"cateId":28,"cateName":"美骑100"},{"cateId":41,"cateName":"千里达"},{"cateId":1,"cateName":"广州市"},{"cateId":39,"cateName":"拉萨市"},{"cateId":7,"cateName":"深圳市"},{"cateId":29,"cateName":"北京市"},{"cateId":2,"cateName":"青岛市"},{"cateId":3,"cateName":"呼和浩特市"},{"cateId":9,"cateName":"东莞市"},{"cateId":40,"cateName":"珠海市"},{"cateId":4,"cateName":"合肥市"},{"cateId":5,"cateName":"重庆市"},{"cateId":19,"cateName":"莱芜市"},{"cateId":13,"cateName":"九江市"},{"cateId":24,"cateName":"福州市"},{"cateId":11,"cateName":"朝阳市"},{"cateId":12,"cateName":"哈尔滨市"},{"cateId":14,"cateName":"厦门市"},{"cateId":16,"cateName":"孝感市"},{"cateId":20,"cateName":"南京市"},{"cateId":27,"cateName":"玉林市"},{"cateId":17,"cateName":"黄石市"},{"cateId":18,"cateName":"宁波市"},{"cateId":21,"cateName":"金昌市"},{"cateId":6,"cateName":"平凉市"},{"cateId":22,"cateName":"铜仁市"},{"cateId":23,"cateName":"大理白族自治州"},{"cateId":30,"cateName":"上海"},{"cateId":31,"cateName":"银川市"},{"cateId":32,"cateName":"铁岭市"},{"cateId":33,"cateName":"石家庄市"},{"cateId":34,"cateName":"廊坊市"},{"cateId":35,"cateName":"成都市"},{"cateId":36,"cateName":"常州市"},{"cateId":37,"cateName":"苏州市"},{"cateId":38,"cateName":"无锡市"}],"list":[{"title":"美骑100武汉站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201706/22/303c43f97aafbd728c6e6b74957dbe8c.jpg","via":"花世界景区-九康大桥-武汉花世界","routeId":229,"totalDis":88000,"totalTime":30600,"hotStar":5,"shapeTypeStr":"基本平路","tags":["泊油路","景区","休闲"],"roadbookNum":2},{"title":"2018美骑100广州站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201804/18/fe636deb496ed68bf9a9ddd4c8056b20.jpg","via":"华辉度假村→花卉大道→X286→Y641→下亮桥/一签→G106国道→X376→S252→黄坑桥/二签→G240→连江口镇/三签→X377→X292→S292/四签→G106→S354→四九镇/二签→S354→G105→华辉度假村/终点","routeId":234,"totalDis":185000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"低难度爬坡","tags":["泊油路","景区","休闲"],"roadbookNum":3},{"title":"美骑100海口站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201706/13/a01a9b8213bb69ca609d0d1187dc008a.jpg","via":"琼山区双创广场-冯白驹故居-琼山区双创广场","routeId":228,"totalDis":100000,"totalTime":28800,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路"],"roadbookNum":2},{"title":"2018美骑100挑战者营地·脉动炽能量北京站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201806/26/a60bc55066e51f52041ee5eeb8235c2b.jpg","via":"【永定河自行车公园】右转→7KM处大堤路右转→700米左转→20KM处X002左堤路左转→22KM处X009右转→28KM处X001公韩路左转→38KM处G107国道【签到/补给/折返点】→原路返回→【永定河自行车公园】","routeId":241,"totalDis":80000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"基本平路","tags":["泊油路","水泥路","休闲"],"roadbookNum":3},{"title":"美骑100成都站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201707/13/71fec4edcdeaa491d177553ed10d398c.jpg","via":"双流万达广场-姐妹农庄-双流万达广场","routeId":232,"totalDis":90000,"totalTime":28800,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路","美食","景区","休闲"],"roadbookNum":2},{"title":"美骑100大连站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201707/13/8099d60ec69f508420d83d682ef48a66.jpg","via":"大连天地-北海镇-大连天地","routeId":230,"totalDis":88000,"totalTime":30600,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路","景区","休闲"],"roadbookNum":2},{"title":"2018美骑100挑战者营地·脉动炽能量沈阳站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201806/26/90b3bb183496d3432f82efc409b38943.jpg","via":"","routeId":266,"totalDis":100000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"基本平路","tags":["泊油路","水泥路","美食","休闲"],"roadbookNum":3},{"title":"2018美骑100西安站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201805/03/d4a87eec9bf08c2056c79c27d5e04464.jpg","via":"【汉长城未央宫遗址/起点】→邓六路→丰景路→西三环→北三环→草滩八路→无名路→草滩七路→河堤路→【50km签到补给点/一签】→堤顶路→【75km补水点】→堤顶路→【100km折返签到补给点/二签】→堤顶路→【125km补水点】→堤顶路→【150km签到补给点/三签】→河堤路→草滩七路→无名路→草滩八路→无名路→场部路→丰产路→邓六路→【汉长城未央宫遗址/终点】","routeId":236,"totalDis":200000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路","水泥路"],"roadbookNum":4},{"title":"美骑100天津站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201707/13/c286fdae487285029e0e06dd6189e360.jpg","via":"东丽湖-海津大桥-东丽湖","routeId":231,"totalDis":88000,"totalTime":30600,"hotStar":5,"shapeTypeStr":"基本平路","tags":["水泥路","景区","休闲"],"roadbookNum":2},{"title":"2018美骑100太原站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201805/03/c31cf31a6f84628083de5c661eb5695d.jpg","via":"【南内环街189号·崐崘域/起点】→体育西路→并州南路→长风街→长风东街→东山森林公园→【台骀山/补给点25KM】→307国道→龙城森林公园→【茶坊庙/补给点39km】→后沟村→卧虎山路（右拐不下隧道）→阳兴大道→新兰路→【中北大学/补给点74KM】→滨河东路→南内环街→【南内环街189号·崐崘域/终点】","routeId":235,"totalDis":100000,"totalTime":28800,"hotStar":5,"shapeTypeStr":"低难度爬坡","tags":["泊油路","水泥路"],"roadbookNum":2}],"pages":2,"count":16}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public List getItemDatas() {
        return data.list;
    }

    public static class DataBean {
        /**
         * cateList : [{"cateId":28,"cateName":"美骑100"},{"cateId":41,"cateName":"千里达"},{"cateId":1,"cateName":"广州市"},{"cateId":39,"cateName":"拉萨市"},{"cateId":7,"cateName":"深圳市"},{"cateId":29,"cateName":"北京市"},{"cateId":2,"cateName":"青岛市"},{"cateId":3,"cateName":"呼和浩特市"},{"cateId":9,"cateName":"东莞市"},{"cateId":40,"cateName":"珠海市"},{"cateId":4,"cateName":"合肥市"},{"cateId":5,"cateName":"重庆市"},{"cateId":19,"cateName":"莱芜市"},{"cateId":13,"cateName":"九江市"},{"cateId":24,"cateName":"福州市"},{"cateId":11,"cateName":"朝阳市"},{"cateId":12,"cateName":"哈尔滨市"},{"cateId":14,"cateName":"厦门市"},{"cateId":16,"cateName":"孝感市"},{"cateId":20,"cateName":"南京市"},{"cateId":27,"cateName":"玉林市"},{"cateId":17,"cateName":"黄石市"},{"cateId":18,"cateName":"宁波市"},{"cateId":21,"cateName":"金昌市"},{"cateId":6,"cateName":"平凉市"},{"cateId":22,"cateName":"铜仁市"},{"cateId":23,"cateName":"大理白族自治州"},{"cateId":30,"cateName":"上海"},{"cateId":31,"cateName":"银川市"},{"cateId":32,"cateName":"铁岭市"},{"cateId":33,"cateName":"石家庄市"},{"cateId":34,"cateName":"廊坊市"},{"cateId":35,"cateName":"成都市"},{"cateId":36,"cateName":"常州市"},{"cateId":37,"cateName":"苏州市"},{"cateId":38,"cateName":"无锡市"}]
         * list : [{"title":"美骑100武汉站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201706/22/303c43f97aafbd728c6e6b74957dbe8c.jpg","via":"花世界景区-九康大桥-武汉花世界","routeId":229,"totalDis":88000,"totalTime":30600,"hotStar":5,"shapeTypeStr":"基本平路","tags":["泊油路","景区","休闲"],"roadbookNum":2},{"title":"2018美骑100广州站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201804/18/fe636deb496ed68bf9a9ddd4c8056b20.jpg","via":"华辉度假村→花卉大道→X286→Y641→下亮桥/一签→G106国道→X376→S252→黄坑桥/二签→G240→连江口镇/三签→X377→X292→S292/四签→G106→S354→四九镇/二签→S354→G105→华辉度假村/终点","routeId":234,"totalDis":185000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"低难度爬坡","tags":["泊油路","景区","休闲"],"roadbookNum":3},{"title":"美骑100海口站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201706/13/a01a9b8213bb69ca609d0d1187dc008a.jpg","via":"琼山区双创广场-冯白驹故居-琼山区双创广场","routeId":228,"totalDis":100000,"totalTime":28800,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路"],"roadbookNum":2},{"title":"2018美骑100挑战者营地·脉动炽能量北京站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201806/26/a60bc55066e51f52041ee5eeb8235c2b.jpg","via":"【永定河自行车公园】右转→7KM处大堤路右转→700米左转→20KM处X002左堤路左转→22KM处X009右转→28KM处X001公韩路左转→38KM处G107国道【签到/补给/折返点】→原路返回→【永定河自行车公园】","routeId":241,"totalDis":80000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"基本平路","tags":["泊油路","水泥路","休闲"],"roadbookNum":3},{"title":"美骑100成都站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201707/13/71fec4edcdeaa491d177553ed10d398c.jpg","via":"双流万达广场-姐妹农庄-双流万达广场","routeId":232,"totalDis":90000,"totalTime":28800,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路","美食","景区","休闲"],"roadbookNum":2},{"title":"美骑100大连站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201707/13/8099d60ec69f508420d83d682ef48a66.jpg","via":"大连天地-北海镇-大连天地","routeId":230,"totalDis":88000,"totalTime":30600,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路","景区","休闲"],"roadbookNum":2},{"title":"2018美骑100挑战者营地·脉动炽能量沈阳站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201806/26/90b3bb183496d3432f82efc409b38943.jpg","via":"","routeId":266,"totalDis":100000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"基本平路","tags":["泊油路","水泥路","美食","休闲"],"roadbookNum":3},{"title":"2018美骑100西安站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201805/03/d4a87eec9bf08c2056c79c27d5e04464.jpg","via":"【汉长城未央宫遗址/起点】→邓六路→丰景路→西三环→北三环→草滩八路→无名路→草滩七路→河堤路→【50km签到补给点/一签】→堤顶路→【75km补水点】→堤顶路→【100km折返签到补给点/二签】→堤顶路→【125km补水点】→堤顶路→【150km签到补给点/三签】→河堤路→草滩七路→无名路→草滩八路→无名路→场部路→丰产路→邓六路→【汉长城未央宫遗址/终点】","routeId":236,"totalDis":200000,"totalTime":36000,"hotStar":5,"shapeTypeStr":"中难度爬坡","tags":["泊油路","水泥路"],"roadbookNum":4},{"title":"美骑100天津站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201707/13/c286fdae487285029e0e06dd6189e360.jpg","via":"东丽湖-海津大桥-东丽湖","routeId":231,"totalDis":88000,"totalTime":30600,"hotStar":5,"shapeTypeStr":"基本平路","tags":["水泥路","景区","休闲"],"roadbookNum":2},{"title":"2018美骑100太原站","thumb":"http://cdn.rabbitcycling.com/files/uploads/image/201805/03/c31cf31a6f84628083de5c661eb5695d.jpg","via":"【南内环街189号·崐崘域/起点】→体育西路→并州南路→长风街→长风东街→东山森林公园→【台骀山/补给点25KM】→307国道→龙城森林公园→【茶坊庙/补给点39km】→后沟村→卧虎山路（右拐不下隧道）→阳兴大道→新兰路→【中北大学/补给点74KM】→滨河东路→南内环街→【南内环街189号·崐崘域/终点】","routeId":235,"totalDis":100000,"totalTime":28800,"hotStar":5,"shapeTypeStr":"低难度爬坡","tags":["泊油路","水泥路"],"roadbookNum":2}]
         * pages : 2
         * count : 16
         */

        private int pages;
        private int count;
        private List<CateListBean> cateList;
        private List<ListBean> list;

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<CateListBean> getCateList() {
            return cateList;
        }

        public void setCateList(List<CateListBean> cateList) {
            this.cateList = cateList;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class CateListBean {
            /**
             * cateId : 28
             * cateName : 美骑100
             */

            private int cateId;
            private String cateName;

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public String getCateName() {
                return cateName;
            }

            public void setCateName(String cateName) {
                this.cateName = cateName;
            }
        }

        public static class ListBean {
            /**
             * title : 美骑100武汉站
             * thumb : http://cdn.rabbitcycling.com/files/uploads/image/201706/22/303c43f97aafbd728c6e6b74957dbe8c.jpg
             * via : 花世界景区-九康大桥-武汉花世界
             * routeId : 229
             * totalDis : 88000
             * totalTime : 30600
             * hotStar : 5
             * shapeTypeStr : 基本平路
             * tags : ["泊油路","景区","休闲"]
             * roadbookNum : 2
             */

            private String title;
            private String thumb;
            private String via;
            private int routeId;
            private int totalDis;
            private int totalTime;
            private int hotStar;
            private String shapeTypeStr;
            private int roadbookNum;
            private List<String> tags;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getVia() {
                return via;
            }

            public void setVia(String via) {
                this.via = via;
            }

            public int getRouteId() {
                return routeId;
            }

            public void setRouteId(int routeId) {
                this.routeId = routeId;
            }

            public int getTotalDis() {
                return totalDis/1000;
            }

            public void setTotalDis(int totalDis) {
                this.totalDis = totalDis;
            }

            public int getTotalTime() {
                return totalTime;
            }

            public void setTotalTime(int totalTime) {
                this.totalTime = totalTime;
            }

            public int getHotStar() {
                return hotStar;
            }

            public void setHotStar(int hotStar) {
                this.hotStar = hotStar;
            }

            public String getShapeTypeStr() {
                return shapeTypeStr;
            }

            public void setShapeTypeStr(String shapeTypeStr) {
                this.shapeTypeStr = shapeTypeStr;
            }

            public int getRoadbookNum() {
                return roadbookNum;
            }

            public void setRoadbookNum(int roadbookNum) {
                this.roadbookNum = roadbookNum;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }
        }
    }
}
