package com.cachecats.data.shop.entity;

import com.cachecats.data.db.MeituanDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by solo on 2018/1/24.
 * 商家的团购信息表
 * 商家id：shopId
 * 团购id: groupId
 * 团购名称：groupName
 * 原价：originalPrice
 * 现价：currentPrice
 * 已售：soldNum
 * 说明：notes
 * 随时退：isRefundAnyTime
 * 过期自动退：isAutoRefund
 * 服务分：serviceScore
 * 标签：label
 * 购买须知：buyNotes
 * 关联套餐内容：查套餐表
 */

@Table(database = MeituanDB.class)
public class ShopGroupInfoEntity extends BaseModel {

    @PrimaryKey
    @Column
    public String groupId;

    @Column
    public String shopId;

    @Column
    public String name;

    @Column
    public float originalPrice;

    @Column
    public float currentPrice;

    @Column
    public int soldNum;

    @Column
    public String notes;

    @Column
    public boolean isRefundAnyTime;

    @Column
    public boolean isAutoRefund;

    @Column
    public float serviceScore;

    @Column
    public String label;

    @Column
    public String buyNotes;

    public List<GroupPackageEntity> groupPackages;

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "groupPackages")
    public List<GroupPackageEntity> getGroupPackages() {
        if (groupPackages == null || groupPackages.isEmpty()) {
            groupPackages = SQLite.select().from(GroupPackageEntity.class)
                    .where(GroupPackageEntity_Table.groupId.eq(groupId))
                    .queryList();
        }
        return groupPackages;
    }


}
