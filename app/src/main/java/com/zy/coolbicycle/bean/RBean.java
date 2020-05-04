package com.zy.coolbicycle.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/5/4
 */
public class RBean extends BasePageBean<RBean.RoutesBean> {


    /**
     * status : ok
     * func : getRoutesByHot
     * more : YES
     * routes : [{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151127/12335_1448555621847.jpeg","distance":2160000,"diffi":5,"cityId":290,"cityName":"成都","creater":{"tags":"黑鸟官方","accountId":12335,"level":4,"cityId":2,"nickname":"黑鸟tony","age":44,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","signature":"","userInfoJSON":{"tags":"黑鸟官方","level":4,"accountId":"12335","nickname":"黑鸟tony","age":"44","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","city":{"cityId":"2"}}},"routeId":1816,"commentCount":1523,"routeName":"318川藏线","subCount":2570},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151213/116315_1449939468325.jpeg","distance":809180,"diffi":3,"cityId":90,"cityName":"海口","creater":{"tags":"","accountId":116315,"level":0,"cityId":2,"nickname":"黑鸟","age":5,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151202/640262_1449054839878.jpg","signature":"","userInfoJSON":{"tags":"","level":0,"accountId":"116315","nickname":"黑鸟","age":"5","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151202/640262_1449054839878.jpg","city":{"cityId":"2"}}},"routeId":1824,"commentCount":462,"routeName":"海南岛","subCount":737},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151202/116315_1448989095655.jpeg","distance":1200000,"diffi":3,"cityId":363,"cityName":"台北","creater":{"tags":"","accountId":116315,"level":0,"cityId":2,"nickname":"黑鸟","age":5,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151202/640262_1449054839878.jpg","signature":"","userInfoJSON":{"tags":"","level":0,"accountId":"116315","nickname":"黑鸟","age":"5","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151202/640262_1449054839878.jpg","city":{"cityId":"2"}}},"routeId":1820,"commentCount":159,"routeName":"环台湾岛","subCount":549},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151128/12335_1448640405777.jpeg","distance":349480,"diffi":2,"cityId":248,"cityName":"海北藏族自治州","creater":{"tags":"黑鸟官方","accountId":12335,"level":4,"cityId":2,"nickname":"黑鸟tony","age":44,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","signature":"","userInfoJSON":{"tags":"黑鸟官方","level":4,"accountId":"12335","nickname":"黑鸟tony","age":"44","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","city":{"cityId":"2"}}},"routeId":1817,"commentCount":363,"routeName":"青海湖","subCount":731},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151109/83537_1447054628460.jpeg","distance":20000,"diffi":4,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":14,"commentCount":253,"routeName":"妙峰山","subCount":874},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1446006188684.jpeg","distance":30000,"diffi":1,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":35,"commentCount":57,"routeName":"北京城区","subCount":308},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151212/775666_1449902346240.jpeg","distance":150770,"diffi":3,"cityId":112,"cityName":"张家口","creater":{"tags":"黑鸟官方","accountId":775666,"level":0,"cityId":2,"nickname":"黑鸟妹妹","age":99,"cityName":"","gender":"1","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151111/22585_1447207380004.jpg","signature":"","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"775666","nickname":"黑鸟妹妹","age":"99","gender":"1","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151111/22585_1447207380004.jpg","city":{"cityId":"2"}}},"routeId":1823,"commentCount":221,"routeName":"草原天路","subCount":589},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151225/65774_1451008340099.jpeg","distance":33500,"diffi":5,"cityId":280,"cityName":"西安","creater":{"tags":"","accountId":65774,"level":5,"cityId":280,"nickname":"xbox","age":0,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/60000/60917/1415839415836.jpg","signature":"How many roads must a man walk down before we can call him a man?","userInfoJSON":{"tags":"","level":5,"accountId":"65774","nickname":"xbox","age":"0","gender":"0","portrait":"http://image.blackbirdsport.com/albums/60000/60917/1415839415836.jpg","city":{"cityId":"280"}}},"routeId":1869,"commentCount":277,"routeName":"秦岭分水岭","subCount":509},{"logo":"http://pics.blackbirdsport.com/stream/201703/12335_1490681179175.jpg","distance":238870,"diffi":2,"cityId":356,"cityName":"湖州","creater":{"tags":"","accountId":690155,"level":5,"cityId":356,"nickname":"七七","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201710/c_3116368_1507637757473.jpg@200w_200h","signature":"路有多长，就骑多远，不怕路长，只怕心老。","userInfoJSON":{"tags":"","level":5,"accountId":"690155","nickname":"七七","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201710/c_3116368_1507637757473.jpg@200w_200h","city":{"cityId":"356"}}},"routeId":2179,"commentCount":119,"routeName":"环太湖","subCount":467},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151201/775666_1448941705009.jpeg","distance":26000,"diffi":4,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":184,"commentCount":61,"routeName":"潭王路","subCount":455},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151223/116315_1450800418392.jpeg","distance":148010,"diffi":2,"cityId":352,"cityName":"杭州","creater":{"tags":"","accountId":116315,"level":0,"cityId":2,"nickname":"黑鸟","age":5,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151202/640262_1449054839878.jpg","signature":"","userInfoJSON":{"tags":"","level":0,"accountId":"116315","nickname":"黑鸟","age":"5","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151202/640262_1449054839878.jpg","city":{"cityId":"2"}}},"routeId":1853,"commentCount":92,"routeName":"环千岛湖","subCount":480},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1446006328040.jpeg","distance":6500,"diffi":1,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":36,"commentCount":37,"routeName":"奥林匹克森林公园","subCount":393},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1446001954404.jpeg","distance":22000,"diffi":1,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":22,"commentCount":40,"routeName":"大运河森林公园","subCount":348},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1446003230110.png","distance":12500,"diffi":5,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":29,"commentCount":44,"routeName":"高崖口","subCount":264},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151220/48118_1450592304742.jpeg","distance":17520,"diffi":1,"cityId":62,"cityName":"东莞","creater":{"tags":"","accountId":48118,"level":2,"cityId":62,"nickname":"夜黑勇闯寡妇村","age":31,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/40000/40543/1421660559641.jpg","signature":"只要我一起飞，空中就没有王牌！！！","userInfoJSON":{"tags":"","level":2,"accountId":"48118","nickname":"夜黑勇闯寡妇村","age":"31","gender":"0","portrait":"http://image.blackbirdsport.com/albums/40000/40543/1421660559641.jpg","city":{"cityId":"62"}}},"routeId":1847,"commentCount":31,"routeName":"大岭山森林公园","subCount":233},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1446002872349.jpeg","distance":4000,"diffi":3,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":27,"commentCount":31,"routeName":"东方红隧道","subCount":157},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1445999928220.jpeg","distance":10000,"diffi":4,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":13,"commentCount":23,"routeName":"香山公园","subCount":246},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151123/775666_1448272394295.jpeg","distance":13440,"diffi":3,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":283,"commentCount":18,"routeName":"凤凰岭","subCount":164},{"logo":"http://image.blackbirdsport.com/routes/year_2016/20160119/62969_1453140219178.jpeg","distance":1770,"diffi":1,"cityId":62,"cityName":"东莞","creater":{"tags":"","accountId":62969,"level":6,"cityId":62,"nickname":"追逐者童童","age":28,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201712/c_3331992_1512739054208.jpg@200w_200h","signature":"微信公众号 单车迷 联合创始人 主编","userInfoJSON":{"tags":"","level":6,"accountId":"62969","nickname":"追逐者童童","age":"28","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201712/c_3331992_1512739054208.jpg@200w_200h","city":{"cityId":"62"}}},"routeId":1910,"commentCount":50,"routeName":"松山湖","subCount":174},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151226/116358_1451144565833.jpeg","distance":72900,"diffi":2,"cityId":24,"cityName":"厦门","creater":{"tags":"","accountId":116358,"level":0,"cityId":2,"nickname":"骑行不止","age":25,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151226/640262_1451144673657.jpg","signature":"","userInfoJSON":{"tags":"","level":0,"accountId":"116358","nickname":"骑行不止","age":"25","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20151226/640262_1451144673657.jpg","city":{"cityId":"2"}}},"routeId":1872,"commentCount":50,"routeName":"环厦门岛","subCount":289},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151129/13780_1448774773383.jpeg","distance":68680,"diffi":3,"cityId":269,"cityName":"太原","creater":{"tags":"","accountId":13780,"level":2,"cityId":269,"nickname":"影歌","age":33,"cityName":"","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20150915/226193_1442296997417.jpg","signature":"","userInfoJSON":{"tags":"","level":2,"accountId":"13780","nickname":"影歌","age":"33","gender":"0","portrait":"http://image.blackbirdsport.com/albums/year_2015/20150915/226193_1442296997417.jpg","city":{"cityId":"269"}}},"routeId":1818,"commentCount":29,"routeName":"横岭二库","subCount":129},{"logo":"http://image.blackbirdsport.com/routes/year_2016/20160319/1458391712388_5825.jpeg","distance":25300,"diffi":1,"cityId":47,"cityName":"深圳","creater":{"tags":"","accountId":382947,"level":2,"cityId":47,"nickname":"追逐者-贾斯汀","age":26,"cityName":"","gender":"0","portrait":"http://wx.qlogo.cn/mmopen/PiajxSqBRaEJ4cwZ9ic8JQM1dqyFFIA3hLR6VXibwDiasicxRujbk74ZCLemlbmVaGP4zF86sCPKyPOqHR2fk8QUvVw/0","signature":"路过","userInfoJSON":{"tags":"","level":2,"accountId":"382947","nickname":"追逐者-贾斯汀","age":"26","gender":"0","portrait":"http://wx.qlogo.cn/mmopen/PiajxSqBRaEJ4cwZ9ic8JQM1dqyFFIA3hLR6VXibwDiasicxRujbk74ZCLemlbmVaGP4zF86sCPKyPOqHR2fk8QUvVw/0","city":{"cityId":"47"}}},"routeId":1947,"commentCount":47,"routeName":"深圳湾--红树林","subCount":180},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151028/83537_1446015778633.jpeg","distance":11000,"diffi":1,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":8,"commentCount":25,"routeName":"十三陵水库","subCount":239},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151125/775666_1448439692639.jpeg","distance":8000,"diffi":2,"cityId":2,"cityName":"北京","creater":{"tags":"黑鸟官方","accountId":1001,"level":0,"cityId":2,"nickname":"黑鸟助手","age":25,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","signature":"有问题找黑鸟助手","userInfoJSON":{"tags":"黑鸟官方","level":0,"accountId":"1001","nickname":"黑鸟助手","age":"25","gender":"0","portrait":"http://pics.blackbirdsport.com/static/icons/helper.png","city":{"cityId":"2"}}},"routeId":6,"commentCount":16,"routeName":"八达岭","subCount":123},{"logo":"http://image.blackbirdsport.com/routes/year_2015/20151218/367792_1450418798624.jpeg","distance":2370,"diffi":1,"cityId":4,"cityName":"上海","creater":{"tags":"","accountId":15160,"level":8,"cityId":4,"nickname":"黑衣加菲猫","age":40,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201710/c_3242569_1508908978622.jpg@200w_200h","signature":"自我修行","userInfoJSON":{"tags":"","level":8,"accountId":"15160","nickname":"黑衣加菲猫","age":"40","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201710/c_3242569_1508908978622.jpg@200w_200h","city":{"cityId":"4"}}},"routeId":1832,"commentCount":5,"routeName":"龙腾绕圈","subCount":74}]
     */

    private String status;
    private String func;
    private String more;
    private List<RoutesBean> routes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesBean> routes) {
        this.routes = routes;
    }

    @Override
    public List getItemDatas() {
        return routes;
    }

    public static class RoutesBean {
        /**
         * logo : http://image.blackbirdsport.com/routes/year_2015/20151127/12335_1448555621847.jpeg
         * distance : 2160000
         * diffi : 5
         * cityId : 290
         * cityName : 成都
         * creater : {":tags""黑鸟官方","accountId":12335,"level":4,"cityId":2,"nickname":"黑鸟tony","age":44,"cityName":"","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","signature":"","userInfoJSON":{"tags":"黑鸟官方","level":4,"accountId":"12335","nickname":"黑鸟tony","age":"44","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","city":{"cityId":"2"}}}
         * routeId : 1816
         * commentCount : 1523
         * routeName : 318川藏线
         * subCount : 2570
         */

        private String logo;
        private int distance;
        private int diffi;
        private int cityId;
        private String cityName;
        private CreaterBean creater;
        private int routeId;
        private int commentCount;
        private String routeName;
        private int subCount;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDiffi() {
            return diffi;
        }

        public void setDiffi(int diffi) {
            this.diffi = diffi;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public CreaterBean getCreater() {
            return creater;
        }

        public void setCreater(CreaterBean creater) {
            this.creater = creater;
        }

        public int getRouteId() {
            return routeId;
        }

        public void setRouteId(int routeId) {
            this.routeId = routeId;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getRouteName() {
            return routeName;
        }

        public void setRouteName(String routeName) {
            this.routeName = routeName;
        }

        public int getSubCount() {
            return subCount;
        }

        public void setSubCount(int subCount) {
            this.subCount = subCount;
        }

        public static class CreaterBean {
            /**
             * tags : 黑鸟官方
             * accountId : 12335
             * level : 4
             * cityId : 2
             * nickname : 黑鸟tony
             * age : 44
             * cityName :
             * gender : 0
             * portrait : http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h
             * signature :
             * userInfoJSON : {"tags":"黑鸟官方","level":4,"accountId":"12335","nickname":"黑鸟tony","age":"44","gender":"0","portrait":"http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h","city":{"cityId":"2"}}
             */

            private String tags;
            private int accountId;
            private int level;
            private int cityId;
            private String nickname;
            private int age;
            private String cityName;
            private String gender;
            private String portrait;
            private String signature;
            private UserInfoJSONBean userInfoJSON;

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public int getAccountId() {
                return accountId;
            }

            public void setAccountId(int accountId) {
                this.accountId = accountId;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public UserInfoJSONBean getUserInfoJSON() {
                return userInfoJSON;
            }

            public void setUserInfoJSON(UserInfoJSONBean userInfoJSON) {
                this.userInfoJSON = userInfoJSON;
            }

            public static class UserInfoJSONBean {
                /**
                 * tags : 黑鸟官方
                 * level : 4
                 * accountId : 12335
                 * nickname : 黑鸟tony
                 * age : 44
                 * gender : 0
                 * portrait : http://pics.blackbirdsport.com/album/201809/c_5048057_1538127463383jpg@200w_200h
                 * city : {"cityId":"2"}
                 */

                private String tags;
                private int level;
                private String accountId;
                private String nickname;
                private String age;
                private String gender;
                private String portrait;
                private CityBean city;

                public String getTags() {
                    return tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public String getAccountId() {
                    return accountId;
                }

                public void setAccountId(String accountId) {
                    this.accountId = accountId;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public String getPortrait() {
                    return portrait;
                }

                public void setPortrait(String portrait) {
                    this.portrait = portrait;
                }

                public CityBean getCity() {
                    return city;
                }

                public void setCity(CityBean city) {
                    this.city = city;
                }

                public static class CityBean {
                    /**
                     * cityId : 2
                     */

                    private String cityId;

                    public String getCityId() {
                        return cityId;
                    }

                    public void setCityId(String cityId) {
                        this.cityId = cityId;
                    }
                }
            }
        }
    }
}
