package cn.novate.architect_day37.simple3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.novate.architect_day37.R;
import cn.novate.architect_day37.retrofit.UserInfo;
import cn.novate.architect_day37.simple3.base.BaseMVPActivity;
import cn.novate.architect_day37.simple3.base.BasePresenter;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 14:49
 * Version 1.0
 * Params:
 * Description:
*/

public class MainActivity extends BaseMVPActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView{

    private TextView textview;

    @Override
    public void onLoading() {
        // 加载进度条
    }

    @Override
    public void onError() {
        // 显示错误
    }

    @Override
    public void onSucceed(UserInfo userInfo) {
        // 显示成功
        textview.setText(userInfo.toString());
    }

    @Override
    public UserInfoPresenter createPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        textview = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }
}
