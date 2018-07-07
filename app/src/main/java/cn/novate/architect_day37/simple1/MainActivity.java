package cn.novate.architect_day37.simple1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.novate.architect_day37.R;
import cn.novate.architect_day37.retrofit.UserInfo;

/**
 * Created by Administrator on 2018/7/7.
 */

public class MainActivity extends AppCompatActivity implements UserInfoContract.UserInfoView{

    private TextView textview;
    private UserInfoContract.UserInfoPresenter mPresenter ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_1);

        textview = (TextView) findViewById(R.id.textview);

        // 调用Presenter的方法
        mPresenter = new UserInfoPresenter(this) ;
        mPresenter.getUsers("ed6b0f7f34dd8cf7b003e40691457175");
    }

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
}
