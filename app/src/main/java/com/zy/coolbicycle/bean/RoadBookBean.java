package com.zy.coolbicycle.bean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/13
 */
public class RoadBookBean{

    /**
     * distance : 150804
     * comment_num : 10
     * image : http://static.imxingzhe.com/lushu/fa3ae75f-a15d-4a27-8aea-20dce5164205.png
     * threed_lushu :
     * similarity_num : 32
     * sport : 3
     * id : 2697734
     * desc : 暂无备注
     * city : 四川-甘孜藏族自治州
     * style : 0
     * user_id : 1930703
     * title : 2019骑闯天路总决赛第一赛段
     * download_time : 2930
     * slope_thumbnail : https://lushu.oss-cn-hangzhou.aliyuncs.com/slope-images/2697734.png
     * user_pic : http://static.imxingzhe.com/default-avatar/default-avatar.png
     * ca_tdf : 0
     * user_name : competitions
     * collections : [[93,"2019骑闯天路总决赛路书合集","http://static.imxingzhe.com/webadm/1570617596000/f21f5161c9317"]]
     * type : 3
     * thumbnail : http://static.imxingzhe.com/lushu/fa3ae75f-a15d-4a27-8aea-20dce5164205.png!lushuWebThumb
     */

    private int distance;
    private int comment_num;
    private String image;
    private String threed_lushu;
    private int similarity_num;
    private int sport;
    private int id;
    private String desc;
    private String city;
    private int style;
    private int user_id;
    private String title;
    private int download_time;
    private String slope_thumbnail;
    private String user_pic;
    private int ca_tdf;
    private String user_name;
    private int type;
    private String thumbnail;
    private List<List<Integer>> collections;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThreed_lushu() {
        return threed_lushu;
    }

    public void setThreed_lushu(String threed_lushu) {
        this.threed_lushu = threed_lushu;
    }

    public int getSimilarity_num() {
        return similarity_num;
    }

    public void setSimilarity_num(int similarity_num) {
        this.similarity_num = similarity_num;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDownload_time() {
        return download_time;
    }

    public void setDownload_time(int download_time) {
        this.download_time = download_time;
    }

    public String getSlope_thumbnail() {
        return slope_thumbnail;
    }

    public void setSlope_thumbnail(String slope_thumbnail) {
        this.slope_thumbnail = slope_thumbnail;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }

    public int getCa_tdf() {
        return ca_tdf;
    }

    public void setCa_tdf(int ca_tdf) {
        this.ca_tdf = ca_tdf;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<List<Integer>> getCollections() {
        return collections;
    }

    public void setCollections(List<List<Integer>> collections) {
        this.collections = collections;
    }
}
