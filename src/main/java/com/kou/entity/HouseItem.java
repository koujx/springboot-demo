package com.kou.entity;

import java.io.Serializable;

public class HouseItem implements Serializable {
    /**
     * 数据表 ID
     */
    private Integer id;

    /**
     * 房子详情页的URL
     */
    private String detailUrl;

    /**
     * 房子编号
     */
    private String houseCode;

    /**
     * 房子展示的图片的URL
     */
    private String imageUrl;

    /**
     * 房子展示出的名字 如 西城区 广安门 朗琴园 满五年唯一住房出售
     */
    private String displayName;

    /**
     * 房子的一些信息，在展示名字下面一行，如 朗琴园 | 1室0厅 | 51.93平米 | 北 | 精装
     */
    private String houseInfo;

    /**
     * 房子的位置信息，如 低楼层(共29层)2004年建塔楼 - 广安门
     */
    private String housePositionInfo;

    /**
     * 房子的关注信息，如 102人关注 / 共36次带看 / 27天以前发布
     */
    private String followInfo;

    /**
     * 房子的描述信息，如 距离7号线达官营站924米  房本满五年  随时看房
     */
    private String tag;

    /**
     * 房子总价，如 530万
     */
    private String totalPrice;

    /**
     * 房子单价，如 单价102061元/平米
     */
    private String unitPrice;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public String getHousePositionInfo() {
        return housePositionInfo;
    }

    public void setHousePositionInfo(String housePositionInfo) {
        this.housePositionInfo = housePositionInfo;
    }

    public String getFollowInfo() {
        return followInfo;
    }

    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", detailUrl=").append(detailUrl);
        sb.append(", houseCode=").append(houseCode);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", displayName=").append(displayName);
        sb.append(", houseInfo=").append(houseInfo);
        sb.append(", housePositionInfo=").append(housePositionInfo);
        sb.append(", followInfo=").append(followInfo);
        sb.append(", tag=").append(tag);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append("]");
        return sb.toString();
    }
}