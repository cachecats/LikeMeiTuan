package com.cachecats.data.shop.entity;

import com.cachecats.data.db.MeituanDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by solo on 2018/1/24.
 * 团购套餐表
 *   id: id
 *   标题：title
     名称：name
     份数：count
     价格：price
 *
 */

@Table(database = MeituanDB.class)
public class GroupPackageEntity {

    @PrimaryKey
    @Column
    public String id;

    @Column
    public String title;

    @Column
    public int count;

    @Column
    public float price;
}
