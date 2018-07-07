package cn.novate.architect_day37.simple1;

import cn.novate.architect_day37.retrofit.RetrofitClient;
import cn.novate.architect_day37.retrofit.UserInfo;
import rx.Observable;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 10:50
 * Version 1.0
 * Params:
 * Description:
*/

public class UserInfoModel implements UserInfoContract.UserInfoModel {

    // Model层，获取数据
    @Override
    public Observable<UserInfo> getUsers(String token){
        return RetrofitClient.getServiceApi()
                .queryUserInfo(token)
                // .subscribeOn().observeOn().subscribe()
                // Subscriber 封装一下
                // 第二个坑 , 坑我们 返回值都是一个泛型，转换返回值泛型
                .compose(RetrofitClient.<UserInfo>transformer());
    }
}
