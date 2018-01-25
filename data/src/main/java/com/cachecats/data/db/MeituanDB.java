package com.cachecats.data.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by solo on 2018/1/16.
 *
 * 创建数据库
 */


@Database(name = MeituanDB.NAME, version = MeituanDB.VERSION, foreignKeyConstraintsEnforced = true)
public class MeituanDB {
    //数据库名称
    public final static String NAME = "MeituanDB";
    //版本号
    public final static int VERSION = 2;
}
