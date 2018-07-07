package cn.novate.architect_day37.simple3.base;

/**
 * Created by Administrator on 2018/7/7.
 */

public class BasePresenter<V extends BaseView> {

    // 目前来讲有2个公用方法 , 传递的时候 会有不同的View , 怎么办？ 采用泛型

    private V mView ;

    public void attach(V view){
        this.mView = view ;
    }

    public void detach(){
        this.mView = null ;
    }

    public V getView(){
        return mView ;
    }
}
