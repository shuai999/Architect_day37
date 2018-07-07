package cn.novate.architect_day37.simple4;

import cn.novate.architect_day37.retrofit.BaseSubscriber;
import cn.novate.architect_day37.retrofit.UserInfo;
import cn.novate.architect_day37.simple4.base.BasePresenter;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 10:43
 * Version 1.0
 * Params:
 * Description:
*/

public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView> implements UserInfoContract.UserInfoPresenter{


    // 肯定会持有 V 和 M
    private UserInfoContract.UserInfoModel mModel ;


    public UserInfoPresenter(){
        mModel = new UserInfoModel() ;
    }

    @Override
    public void getUsers(String token) {

        // 获取数据之前，需要显示正在加载中的进度条

        getView().onLoading();
        // RxJava + OkHttp + Retrofit
        mModel.getUsers(token).subscribe(new BaseSubscriber<UserInfo>() {
            @Override
            protected void onError(String errorCode, String errorMessage) {
                // 失败
                /*if (getView() != null){

                    // 每次判断 View != null，很麻烦，怎么办？
                    // 由于View都是接口，通用代码 View != null统一处理，这个是AOP思想（aspectJ、动态代理）
                    getView().onError();
                }*/

                getView().onError();
            }

            @Override
            public void onNext(UserInfo userInfo) {
                // 成功
                /*if (getView() != null) {
                    getView().onSucceed(userInfo);
                }*/

                getView().onSucceed(userInfo);
            }
        }) ;
    }
}
