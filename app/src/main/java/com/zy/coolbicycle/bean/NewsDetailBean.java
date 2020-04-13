package com.zy.coolbicycle.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/11
 */
public class NewsDetailBean extends BasePageBean<NewsDetailBean.DataBean.DisplayTypeBean> {

    /**
     * action : n:gn
     * res : 1
     * data : {"news_type":[],"banner_type":[],"display_type":[{"guide_content":"","h5_url":"https://mp.weixin.qq.com/s/vlSVxCo31DhOdmJ0GypzGA","tags":"","n_type":3,"allow_guide":0,"tags_expire_time":"无时效性","jump":"","publish_time":1585907455000,"pic_url":"https://static.imxingzhe.com/headline/2020-04-03-hvwzyapgqbxd1j2itd1nij24dwm2w3k2.jpg","id":3858,"title":"2020年年度奖牌规则调整，可免计一个月！","click":1427,"content":"","source":"","comment_count":3,"like_count":7,"allow_comment":1,"d_type":0,"pc_url":""}]}
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
        private List<?> news_type;
        private List<?> banner_type;
        private List<DisplayTypeBean> display_type;

        public List<?> getNews_type() {
            return news_type;
        }

        public void setNews_type(List<?> news_type) {
            this.news_type = news_type;
        }

        public List<?> getBanner_type() {
            return banner_type;
        }

        public void setBanner_type(List<?> banner_type) {
            this.banner_type = banner_type;
        }

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
             * click : 1427
             * content :
             * source :
             * comment_count : 3
             * like_count : 7
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
            private int click;
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

            public long getPublish_time() {
                return publish_time;
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

            public int getClick() {
                return click;
            }

            public void setClick(int click) {
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
