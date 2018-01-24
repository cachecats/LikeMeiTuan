package com.cachecats.data.shop.entity;

import com.cachecats.data.db.MeituanDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by solo on 2018/1/24.
 * 商店收到的评价表
     用户id: userId
     用户名： userName
     用户头像：userHeads
     评价商户id：shopId
     评价团购id：groupId
     评价内容：evaluation
     评价分数：evaluateScore
     人均消费：perConsume
     照片：pictures
     推荐菜：recommendDishes
 */

@Table(database = MeituanDB.class)
public class ShopEvaluateEntity {


}
