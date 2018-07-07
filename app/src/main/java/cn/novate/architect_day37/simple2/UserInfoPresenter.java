package cn.novate.architect_day37.simple2;

import cn.novate.architect_day37.retrofit.BaseSubscriber;
import cn.novate.architect_day37.retrofit.UserInfo;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 10:43
 * Version 1.0
 * Params:
 * Description:
*/

public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter{


    // 肯定会持有 V 和 M
    private UserInfoContract.UserInfoView mView ;
    private UserInfoContract.UserInfoModel mModel ;


    public UserInfoPresenter(UserInfoContract.UserInfoView view){
        this.mView = view ;
        mModel = new UserInfoModel() ;
    }


    public void attach(UserInfoContract.UserInfoView view){
        this.mView = view ;
    }

    public void detach(){
        this.mView = null ;
    }


    @Override
    public void getUsers(String token) {

        // 获取数据之前，需要显示正在加载中的进度条

        // RxJava + OkHttp + Retrofit
        mModel.getUsers(token).subscribe(new BaseSubscriber<UserInfo>() {
            @Override
            protected void onError(String errorCode, String errorMessage) {
                // 失败
            }

            @Override
            public void onNext(UserInfo userInfo) {
                // 成功
                mView.onSucceed(userInfo);
            }
        }) ;
    }
}
