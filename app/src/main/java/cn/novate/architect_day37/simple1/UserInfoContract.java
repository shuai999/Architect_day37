package cn.novate.architect_day37.simple1;

import cn.novate.architect_day37.retrofit.UserInfo;
import rx.Observable;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 10:28
 * Version 1.0
 * Params:
 * Description:    协议类，可有可无
 *                好处：
 *                      多人协作开发时，可以把这个先写好
*/

public class UserInfoContract {
    // user View 层
    interface UserInfoView {
        // 1.正在加载中
        // 2.获取出错了
        // 3.成功了要显示数据
        void onLoading();
        void onError();
        void onSucceed(UserInfo userInfo);
    }

    // user presenter 层
    interface UserInfoPresenter {
        void getUsers(String token);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface UserInfoModel {
        Observable<UserInfo> getUsers(String token);
    }
}
