package com.zy.coolbicycle.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/11
 */
public class BannerBean extends BasePageBean<BannerBean.ResultBean.ItemsBean> {

    /**
     * code : 1
     * message : success
     * notice : {"softwareCount":0,"newsCount":17}
     * result : {"items":[{"detail":"","href":"https://www.oschina.net/project/2020/q1_projects","id":0,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_fa4e8e0a-2aef-4c8c-bbe2-077b55993de5.jpg","name":"第一季度 OSC 开源软件评选 投票开启","pubDate":"2020-04-08 14:43:18","type":0,"weight":12},{"detail":"","href":"https://my.oschina.net/editorial-story/blog/3217606","id":0,"img":"https://oscimg.oschina.net/oscnet/up-6ce8441e847009f9687ffa93dae658edd02.png","name":"挑战 TensorFlow 与 PyTorch，深度学习框架集中爆发","pubDate":"2020-04-07 13:31:38","type":0,"weight":10},{"detail":"","href":"","id":114589,"img":"https://static.oschina.net/uploads/space/2020/0403/031821_Id4C_2720166.png","name":"Eclipse Theia 1.0 发布，TypeScript 编写的云端和桌面 IDE 框架","pubDate":"2020-04-07 13:34:06","type":6,"weight":8},{"detail":"","href":"https://www.oschina.net/event/2315774?origin=appbanner","id":0,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_a8da708c-9a5e-430b-a049-761094ab6436.png","name":"聚焦大前端：Koltin·小程序·可视化>>>","pubDate":"2020-04-10 11:34:41","type":0,"weight":8},{"detail":"","href":"","id":114644,"img":"https://oscimg.oschina.net/oscnet/0c73e2cf2c5fe1c47a519ac40c2314baff8.jpg","name":"少儿编程语言 Scratch 进入 TIOBE TOP 20","pubDate":"2020-04-07 13:35:01","type":6,"weight":7}],"nextPageToken":"61AF0C190D6BD629","prevPageToken":"3EA621243546C8A5","requestCount":5,"responseCount":5,"totalResults":5}
     * time : 2020-04-11 18:12:54
     */

    private int code;
    private String message;
    private NoticeBean notice;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List getItemDatas() {
        return result.items;
    }

    public static class NoticeBean {
        /**
         * softwareCount : 0
         * newsCount : 17
         */

        private int softwareCount;
        private int newsCount;

        public int getSoftwareCount() {
            return softwareCount;
        }

        public void setSoftwareCount(int softwareCount) {
            this.softwareCount = softwareCount;
        }

        public int getNewsCount() {
            return newsCount;
        }

        public void setNewsCount(int newsCount) {
            this.newsCount = newsCount;
        }
    }

    public static class ResultBean {
        /**
         * items : [{"detail":"","href":"https://www.oschina.net/project/2020/q1_projects","id":0,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_fa4e8e0a-2aef-4c8c-bbe2-077b55993de5.jpg","name":"第一季度 OSC 开源软件评选 投票开启","pubDate":"2020-04-08 14:43:18","type":0,"weight":12},{"detail":"","href":"https://my.oschina.net/editorial-story/blog/3217606","id":0,"img":"https://oscimg.oschina.net/oscnet/up-6ce8441e847009f9687ffa93dae658edd02.png","name":"挑战 TensorFlow 与 PyTorch，深度学习框架集中爆发","pubDate":"2020-04-07 13:31:38","type":0,"weight":10},{"detail":"","href":"","id":114589,"img":"https://static.oschina.net/uploads/space/2020/0403/031821_Id4C_2720166.png","name":"Eclipse Theia 1.0 发布，TypeScript 编写的云端和桌面 IDE 框架","pubDate":"2020-04-07 13:34:06","type":6,"weight":8},{"detail":"","href":"https://www.oschina.net/event/2315774?origin=appbanner","id":0,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_a8da708c-9a5e-430b-a049-761094ab6436.png","name":"聚焦大前端：Koltin·小程序·可视化>>>","pubDate":"2020-04-10 11:34:41","type":0,"weight":8},{"detail":"","href":"","id":114644,"img":"https://oscimg.oschina.net/oscnet/0c73e2cf2c5fe1c47a519ac40c2314baff8.jpg","name":"少儿编程语言 Scratch 进入 TIOBE TOP 20","pubDate":"2020-04-07 13:35:01","type":6,"weight":7}]
         * nextPageToken : 61AF0C190D6BD629
         * prevPageToken : 3EA621243546C8A5
         * requestCount : 5
         * responseCount : 5
         * totalResults : 5
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * detail :
             * href : https://www.oschina.net/project/2020/q1_projects
             * id : 0
             * img : https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_fa4e8e0a-2aef-4c8c-bbe2-077b55993de5.jpg
             * name : 第一季度 OSC 开源软件评选 投票开启
             * pubDate : 2020-04-08 14:43:18
             * type : 0
             * weight : 12
             */

            private String detail;
            private String href;
            private int id;
            private String img;
            private String name;
            private String pubDate;
            private int type;
            private int weight;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }
        }
    }
}
