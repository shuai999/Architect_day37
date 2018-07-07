package cn.novate.architect_day37.simple3.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 15:03
 * Version 1.0
 * Params:
 * Description:    泛型构建基类，将attach()、detach()方法放到基类中
*/

public abstract class BaseMVPActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    private P mPresenter ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();

        // 创建 P ，只能交给子类，每个 Activity都不一样
        mPresenter = createPresenter() ;
        // 绑定
        mPresenter.attach(this);
        initView() ;
        initData() ;

    }


    // 由子类去实现
    public abstract P createPresenter();

    public abstract void initData();

    public abstract void initView();

    public abstract void setContentView();


    /**
     * 解绑
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
