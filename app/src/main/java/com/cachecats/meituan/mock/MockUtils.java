package com.cachecats.meituan.mock;

import com.cachecats.domin.shop.model.GroupPackageModel;
import com.cachecats.domin.shop.model.ShopGroupInfoModel;
import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.service.GroupPackageService;
import com.cachecats.domin.shop.service.ShopGroupInfoService;
import com.cachecats.domin.shop.service.ShopService;
import com.orhanobut.logger.Logger;
import com.solo.common.rxjava.CloseableRxServiceExecutor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/25.
 * mock 数据的工具类
 */

public class MockUtils {

    private ShopService shopService;
    private GroupPackageService groupPackageService;
    private ShopGroupInfoService shopGroupInfoService;
    private CloseableRxServiceExecutor executor;

    @Inject
    public MockUtils(ShopService shopService,
                     GroupPackageService groupPackageService,
                     ShopGroupInfoService shopGroupInfoService,
                     CloseableRxServiceExecutor executor) {
        this.shopService = shopService;
        this.groupPackageService = groupPackageService;
        this.shopGroupInfoService = shopGroupInfoService;
        this.executor = executor;
    }

    /**
     * mock商铺信息保存到数据库
     */
    public void mockShopDataToDB() {
        List<ShopModel> models = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ShopModel model = new ShopModel();
            model.setTel("1890028332" + i);
            model.setServiceScore(4.5f);
            model.setRecommendDishes("家常豆腐" + i);
            model.setPerConsume(45 + i);
            model.setName("张三" + i);
            model.setIntroduction("旺铺欢迎光临");
            model.setId(i + "");
            model.setAddress("北辰大道" + i);
            model.setLogo("http://omdl1pobo.bkt.clouddn.com/280778059_593d34d31e6ab_BYsp_1497183443.png");
            models.add(model);
        }
        //异步批量保存
        executor.execute(shopService.saveShops(models), () -> Logger.d("保存成功-------------"));
    }

    /**
     * mock 团购套餐数据
     */
    public void mockGroupPackagesToDB() {
        List<GroupPackageModel> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GroupPackageModel model = new GroupPackageModel();
            model.setShopId(i + "");
            model.setId(i + "");
            model.setGroupId(i + "");
            model.setTitle("美味套餐" + i);
            model.setPrice(10 + i);
            model.setName("麻婆豆腐" + i);
            model.setCount(1);
            list.add(model);
        }
//        groupPackageService.saveGroupPackages(list)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(() -> Logger.d("保存成功-------------"));

        executor.execute(groupPackageService.saveGroupPackages(list),
                () -> Logger.d("保存成功-------------"));
    }

    /**
     * 清空ShopEntity数据库
     */
    public void clearShop() {
//        shopService.clear()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(() -> Logger.d("清空数据库完成"));

        executor.execute(shopService.clear(), () -> Logger.d("清空数据库完成"));
    }


    public void mockGroupInfoData() {
        List<ShopGroupInfoModel> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ShopGroupInfoModel model = new ShopGroupInfoModel();
            model.setShopId(0 + "");
            model.setGroupId(i + "");
            model.setSoldNum(500 + i);
            model.setServiceScore(4.5f + i / 10);
            model.setRefundAnyTime(true);
            model.setOriginalPrice(22.0f);
            model.setCurrentPrice(18.0f);
            model.setNotes("超值套餐，不容错过");
            model.setName("劲省套餐" + i);
            model.setLabel("省，工作餐");
            model.setBuyNotes("无需预约，进店即可消费");
            model.setAutoRefund(true);
            list.add(model);
        }
//        shopGroupInfoService.saveGroupInfos(list)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(() -> Logger.d("保存成功-------------"));

        executor.execute(shopGroupInfoService.saveGroupInfos(list), () -> Logger.d("保存成功-------------"));
    }

}
