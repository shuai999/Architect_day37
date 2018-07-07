package cn.novate.architect_day37.retrofit;

/**
 * Created by hcDarren on 2017/12/16.
 */

public class BaseResult {
    String bol;
    String msg;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return bol;
    }

    public boolean isOk(){
        return "true".equals(bol);
    }
}
