package com.cachecats.data.shop.entity;

import com.cachecats.data.db.MeituanDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by solo on 2018/1/18.
 * 商店对应的数据库实体
 * <p>
 * 商家信息表 ：
 * id: shopId
 * 店名：shopName
 * logo图标: logo
 * 地址：address
 * 电话：tel
 * 服务分：serviceScore
 * 人均消费：perConsume
 * 简介：introduction
 * 推荐菜：recommendDishes
 */

@Table(database = MeituanDB.class)
public class ShopEntity extends BaseModel {

    @PrimaryKey
    public String id;

    @Column
    public String name;

    @Column
    public String logo;

    @Column
    public String address;

    @Column
    public String tel;

    @Column
    public float serviceScore;

    @Column
    public float perConsume;

    @Column
    public String introduction;

    @Column
    public String recommendDishes;


}
