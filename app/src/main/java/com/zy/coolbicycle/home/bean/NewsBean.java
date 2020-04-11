package com.zy.coolbicycle.home.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class NewsBean extends BasePageBean<NewsBean.DataBean.DisplayTypeBean> {

    /**
     * action : n:gn
     * res : 1
     * data : {"news_type":[],"banner_type":[],"display_type":[{"guide_content":"","h5_url":"https://mp.weixin.qq.com/s/vlSVxCo31DhOdmJ0GypzGA","tags":"","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1585907455000,"pic_url":"https://static.imxingzhe.com/headline/2020-04-03-hvwzyapgqbxd1j2itd1nij24dwm2w3k2.jpg","id":3858,"title":"2020年年度奖牌规则调整，可免计一个月！","click":1328,"content":"","source":"","comment_count":3,"like_count":6,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"成为pro","h5_url":"https://mp.weixin.qq.com/s/oCTXuliehas9H6JNOsaDtg","tags":"","n_type":3,"allow_guide":1,"tags_expire_time":2147483647,"jump":"http://imxingzhe.com/xingzhe_pro/#/","publish_time":1585907259000,"pic_url":"https://static.imxingzhe.com/headline/2020-04-03-21d57f2k26eygunyqa2vr5sw4zdnkoy1.jpg","id":3857,"title":"想成为大Pro的用户请进，机会来了！","click":1026,"content":"","source":"","comment_count":2,"like_count":1,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"https://mp.weixin.qq.com/s/tZYL1m32VzR_dfl-Ezilsw","tags":"","n_type":3,"allow_guide":0,"tags_expire_time":2147483647,"jump":"","publish_time":1585809030000,"pic_url":"https://static.imxingzhe.com/headline/2020-04-02-aff8pwdd0u4uwwn81mbb76hvmpcjhnrn.jpg","id":3856,"title":"【招人】不拿梦想唬人，但行者真的需要你！","click":2156,"content":"","source":"","comment_count":3,"like_count":13,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"7字新号","h5_url":"https://mp.weixin.qq.com/s/AafnuIW8fXyD_GOj39LMyg","tags":"","n_type":3,"allow_guide":1,"tags_expire_time":2147483647,"jump":"http://www.imxingzhe.com/mall/#/numCardAutoSelect","publish_time":1584523042000,"pic_url":"https://static.imxingzhe.com/headline/2020-03-18-4k95gzt9pmfpbyi6kj675gqwut0cbjy1.jpg","id":3853,"title":"\u201c7\u201d字头靓号今晚开选！手慢无","click":3339,"content":"各位，今天就是3月18日了，如之前预告，今晚8点，\u201c7\u201d字头行者号牌就开放啦！","source":"","comment_count":6,"like_count":3,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"选购新号","h5_url":"https://mp.weixin.qq.com/s/Mko4ccpIMr0UQnnksErhkw","tags":"","n_type":3,"allow_guide":1,"tags_expire_time":"无时效性","jump":"http://www.imxingzhe.com/mall/#/numCardAutoSelect","publish_time":1584440732000,"pic_url":"https://static.imxingzhe.com/headline/2020-03-17-cc6ctr3zeannh16km0lfbubzis55gjfj.jpg","id":3852,"title":"久等了！这张\u201c7318\u201d号车牌终于要来了！","click":11106,"content":"","source":"","comment_count":6,"like_count":17,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"https://mp.weixin.qq.com/s/u2z5bIM6w8xIwh8FJvheAA","tags":"","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1584094568000,"pic_url":"https://static.imxingzhe.com/headline/2020-03-13-16u5e2t56pxrxzltpnfymlmcug80u1wx.jpg","id":3851,"title":"行者史上最重量级勋章来了，它属于爬坡党！","click":13482,"content":"为了鼓励大家挑战爬坡，爱上爬坡，我们拿出了一枚极具含金量的【攀登者】勋章，用于奖励勇于攀登（爬坡）的骑行者。","source":"","comment_count":18,"like_count":52,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"Pro福利","h5_url":"https://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508676&idx=1&sn=4e36df989756feca66d3379268b57af1","tags":"","n_type":3,"allow_guide":1,"tags_expire_time":"1周","jump":"http://imxingzhebit.baiduux.com/h5/spring2020.html","publish_time":1583202950000,"pic_url":"https://static.imxingzhe.com/headline/2020-03-03-jr2gfk2fdfep845gs92c0om051z0ce38.jpg","id":3849,"title":"行者Pro今年的第一波福利，来了！","click":3762,"content":"行者商城骑行服装、车架等配件大力促销，行者pro用户更享低价","source":"","comment_count":0,"like_count":2,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"峰","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508668&idx=1&sn=4e835690921042b3016e140244e8c80a&chksm=84bdc8adb3ca41bbefd52a437343dc7443673aa74f36e5cf2dec1e32349bdc1c74d1caf62756&token=24919","tags":"骑行-入门","n_type":3,"allow_guide":1,"tags_expire_time":"无时效性","jump":"www.imxingzhe.com/mall/#/product/191","publish_time":1582805512000,"pic_url":"https://static.imxingzhe.com/headline/2020-02-27-tt6be4gic78cv0b3xfbh2babe3a1ho4t.png","id":3848,"title":"白拿行者峰！行者买峰返现活动第二期启动","click":4730,"content":"","source":"行者","comment_count":7,"like_count":12,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"运动抗疫","h5_url":"https://mp.weixin.qq.com/s/EZU_HBCkIBUDMYrr9wXFEg","tags":"骑行-入门","n_type":3,"allow_guide":1,"tags_expire_time":"无时效性","jump":"http://imxingzhebit.baiduux.com/h5/Indoorcycling.html","publish_time":1582365300000,"pic_url":"https://static.imxingzhe.com/headline/2020-02-22-zuunsaobg7sp43gbmvr15k2szpt8nbtx.jpg","id":3845,"title":"今天，一起跨入室内骑行新世界！","click":2021,"content":"","source":"行者","comment_count":0,"like_count":5,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"领取非","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508594&idx=1&sn=a2eb5bc17a54241ebe22f396d101ee84&chksm=84bdc8e3b3ca41f518950671c18b32cc3ee5943be18449de57f499a26679a2bcc41e4a519a00&token=78404","tags":"骑行-入门","n_type":3,"allow_guide":1,"tags_expire_time":"无时效性","jump":"http://www.imxingzhe.com/xingzhe_pro/#/","publish_time":1581595756000,"pic_url":"https://static.imxingzhe.com/headline/2020-02-13-t4304vxvoye0frkok8se9mq7h1dl2jmk.png","id":3843,"title":"武汉加油！行者向全体武汉骑友赠送pro资格","click":4248,"content":"","source":"行者","comment_count":5,"like_count":8,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508556&idx=2&sn=f4f1e83b6585ea1217ed11c07d7532dd&chksm=84bdc8ddb3ca41cb951cc92923b89ad0b8b5d78088d2661b5b343632b82e3b6189741dccc3c1&token=10871","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1581078390000,"pic_url":"https://static.imxingzhe.com/headline/2020-02-07-0rwke8laj2tk11ofm937gqs6d1h2gw12.jpg","id":3840,"title":"关于2020年年度奖牌的相关通知","click":5877,"content":"","source":"行者","comment_count":8,"like_count":30,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508553&idx=1&sn=5aa4f4371be12685b8960d33eac27302&chksm=84bdc8d8b3ca41ced2237fded095c5a6965688c453ab11f631407ec2d46b7efa878806edae7c&token=21140","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1580990950000,"pic_url":"https://static.imxingzhe.com/headline/2020-02-06-p4yih0vhl79lkpxhjtz5em25iiyyud9q.jpg","id":3839,"title":"看哭了！95后女孩骑车辗转300公里回武汉抗击疫情","click":7124,"content":"","source":"行者","comment_count":31,"like_count":110,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508553&idx=2&sn=e153122ac797890c475dfb6b99f7e7df&chksm=84bdc8d8b3ca41ce8ffbe171199a7dd02618cc7dcb8033deeb94d142926cd51810c9f3359cc2&token=21140","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1580990873000,"pic_url":"https://static.imxingzhe.com/headline/2020-02-06-1y3s2590czyk5l2jcgpqeevwbjmdlsg4.jpg","id":3838,"title":"鼠你最强！新春画轨迹中奖名单","click":3456,"content":"","source":"行者","comment_count":2,"like_count":11,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=509024864&idx=1&sn=a86c4cdea1cda58e168a8fab7914fbe5&chksm=04bdc83133ca4127ec67e3ab083e0f14704a0479a564a54d570b82860b054e3c7148d1853ad4#rd","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1579690854000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-22-eaedq8xemdu22bpgbhywhcy1m6gd626j.png","id":3834,"title":"农历猪年最后一次推送，我们要说三件事","click":5999,"content":"","source":"行者","comment_count":3,"like_count":18,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=509024843&idx=1&sn=dfeab97a587f1011760cbb8a717cf855&chksm=04bdc81a33ca410c98c2a7d4df1ea618c4886ad041d50991756c6f6ea8f3fe7fafdf7f90e272#rd","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1579605162000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-21-7pc31choa8faf6073tytegxo1yv2uhhg.jpg","id":3833,"title":"2019骑的怎么样？来看这份年度总结","click":9027,"content":"","source":"行者","comment_count":16,"like_count":12,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=509024830&idx=1&sn=e299562f24cfaba8f284b4e2882d9590&chksm=04bdc86f33ca417932b219e204209caca246967466e7f2132782dd36e6c8a5da2e3935d078de#rd","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1579345291000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-18-e2klxzq6jtwfywm3f054tf5avoh15fvq.png","id":3831,"title":"鼠你最强！新春画轨迹送台历！","click":2610,"content":"","source":"行者","comment_count":2,"like_count":7,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"热度返现","h5_url":"https://mp.weixin.qq.com/s/TZyKxkUxkzeuBrjs4s_fxw","tags":"骑行-入门","n_type":3,"allow_guide":1,"tags_expire_time":"无时效性","jump":"http://www.imxingzhe.com/mall/#/product/191","publish_time":1579087450000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-15-0r59558vrfk4ocp0u6hxcb0inu7b5lxa.png","id":3829,"title":"近百用户白嫖行者峰成功！买峰返现活动公告","click":12699,"content":"","source":"行者","comment_count":1,"like_count":23,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=509024819&idx=2&sn=6ae2e57dd78c3e4d10a49c00e638d514&chksm=04bdc86233ca41743437021b859dff0399700d5778ae1f8f11bdde1a8c0b05aa6ea650b1a6a9#rd","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1579087375000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-15-c7gky2basxv0576pozfyza20vwagi41f.jpg","id":3827,"title":"通知：关于年度奖牌用户领取PRO的方法","click":11205,"content":"","source":"行者","comment_count":3,"like_count":8,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=2656508466&idx=1&sn=32d1ff5bdcf22a8595d446601a1fc1d7&chksm=84bdc863b3ca4175520fa260508f57ddfaf0db245c08cc7de453a48e8fbf98599e251b4ce22f&token=25894","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1579087269000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-15-9zk2ruhttz9ee1b76n391gmp3xivueau.png","id":3826,"title":"2019行者年度骑王揭晓！另有大量福利赠送","click":3159,"content":"","source":"行者","comment_count":3,"like_count":12,"allow_comment":1,"d_type":0,"pc_url":""},{"guide_content":"","h5_url":"http://mp.weixin.qq.com/s?__biz=MzA3MjQyNzMyNg==&mid=509024801&idx=1&sn=d4b3c3e6a63e1a783609455f2423eadc&chksm=04bdc87033ca41664675aafcd965f150ea441365ef60874ade7d53e8f201f744fbf5669c80bd#rd","tags":"骑行-入门","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1578484847000,"pic_url":"https://static.imxingzhe.com/headline/2020-01-08-bb25skwdxe2jbhojuge7yp58yld3ey6a.jpg","id":3825,"title":"关于新年期间延迟发货的通知","click":3555,"content":"","source":"行者","comment_count":5,"like_count":3,"allow_comment":1,"d_type":0,"pc_url":""}]}
     */

    private String action;
    private int res;
    private DataBean data;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public List getItemDatas() {
        return data.display_type;
    }

    public static class DataBean {
        private List<DisplayTypeBean> display_type;

        public List<DisplayTypeBean> getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(List<DisplayTypeBean> display_type) {
            this.display_type = display_type;
        }

        public static class DisplayTypeBean {
            /**
             * guide_content :
             * h5_url : https://mp.weixin.qq.com/s/vlSVxCo31DhOdmJ0GypzGA
             * tags :
             * n_type : 3
             * allow_guide : 0
             * tags_expire_time : 无时效性
             * jump :
             * publish_time : 1585907455000
             * pic_url : https://static.imxingzhe.com/headline/2020-04-03-hvwzyapgqbxd1j2itd1nij24dwm2w3k2.jpg
             * id : 3858
             * title : 2020年年度奖牌规则调整，可免计一个月！
             * click : 1328
             * content :
             * source :
             * comment_count : 3
             * like_count : 6
             * allow_comment : 1
             * d_type : 0
             * pc_url :
             */

            private String guide_content;
            private String h5_url;
            private String tags;
            private int n_type;
            private int allow_guide;
            private String tags_expire_time;
            private String jump;
            private long publish_time;
            private String pic_url;
            private int id;
            private String title;
            private String click;
            private String content;
            private String source;
            private int comment_count;
            private int like_count;
            private int allow_comment;
            private int d_type;
            private String pc_url;

            public String getGuide_content() {
                return guide_content;
            }

            public void setGuide_content(String guide_content) {
                this.guide_content = guide_content;
            }

            public String getH5_url() {
                return h5_url;
            }

            public void setH5_url(String h5_url) {
                this.h5_url = h5_url;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public int getN_type() {
                return n_type;
            }

            public void setN_type(int n_type) {
                this.n_type = n_type;
            }

            public int getAllow_guide() {
                return allow_guide;
            }

            public void setAllow_guide(int allow_guide) {
                this.allow_guide = allow_guide;
            }

            public String getTags_expire_time() {
                return tags_expire_time;
            }

            public void setTags_expire_time(String tags_expire_time) {
                this.tags_expire_time = tags_expire_time;
            }

            public String getJump() {
                return jump;
            }

            public void setJump(String jump) {
                this.jump = jump;
            }

            public String getPublish_time() {
                /**
                 * 1585907455000 表示这个整数代表着发布时间与1970年1月1日0时0分0秒的时间差(以秒为单位)
                 * 将其格式化为 yyyy-MM-dd HH:mm:ss形式
                 * 并返回
                 */
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(publish_time);
                return dateString;
            }

            public void setPublish_time(long publish_time) {
                this.publish_time = publish_time;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getClick() {
                return click;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public int getAllow_comment() {
                return allow_comment;
            }

            public void setAllow_comment(int allow_comment) {
                this.allow_comment = allow_comment;
            }

            public int getD_type() {
                return d_type;
            }

            public void setD_type(int d_type) {
                this.d_type = d_type;
            }

            public String getPc_url() {
                return pc_url;
            }

            public void setPc_url(String pc_url) {
                this.pc_url = pc_url;
            }

        }
    }
}
