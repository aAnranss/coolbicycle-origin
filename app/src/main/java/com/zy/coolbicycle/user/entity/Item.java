package com.zy.coolbicycle.user.entity;

/**
 * 应用模块:
 * 类描述:用户界面的选项
 * Created by 卢文钏 on 2020/4/2
 */
public class Item {
    private int aIcon;
    private String aTitle;

    public Item() {
    }

    public Item(String aTitle) {
        this.aTitle = aTitle;
    }

    public Item(int aIcon, String aTitle) {
        this.aIcon = aIcon;
        this.aTitle = aTitle;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }
}
