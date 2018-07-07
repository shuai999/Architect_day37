package cn.novate.architect_day37.simple4.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/7/7 15:40
 * Version 1.0
 * Params:
 * Description:    动态代理优化 View != null
*/

public class BasePresenter<V extends BaseView> {

    // 目前来讲有2个公用方法 , 传递的时候 会有不同的View , 怎么办？ 采用泛型

    private WeakReference<V> mViewReference ;
    private V mProxyView;

    // View一般都是Activity，可能会涉及到内存泄露的问题，但是已经解绑了就不会内存泄露，
    // 这里最好还是用一下软引用



    public void attach(V view){
//        this.mView = view ;

        this.mViewReference = new WeakReference<V>(view) ;

        // 用代理对象 动态代理
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 动态代理每次都会执行这个方法，调用的是被代理的对象（就是mView）
                if (mViewReference == null || mViewReference.get() == null) {
                    return null ;
                }else{
                    return method.invoke(mViewReference.get(), args);
                }
            }
        });
    }

    public void detach(){
        this.mViewReference.clear();
        this.mViewReference = null ;
        this.mProxyView = null ;
    }

    public V getView(){
        return mProxyView ;
    }
}
