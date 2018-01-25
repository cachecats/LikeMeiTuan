package com.cachecats.data.shop.entity;

import com.cachecats.data.db.MeituanDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by solo on 2018/1/24.
 * 团购套餐表
 * id: id
 * 标题：title
 * 名称：name
 * 份数：count
 * 价格：price
 * 对应团购id: groupId
 * 对应商铺id：shopId
 */

@Table(database = MeituanDB.class)
public class GroupPackageEntity extends BaseModel {

    @PrimaryKey
    @Column
    public String id;

    @Column
    public String groupId;

    @Column
    public String shopId;

    @Column
    public String title;

    @Column
    public String name;

    @Column
    public int count;

    @Column
    public float price;
}
