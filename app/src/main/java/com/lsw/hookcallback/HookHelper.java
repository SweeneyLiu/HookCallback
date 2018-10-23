package com.lsw.hookcallback;

import android.os.Handler;

/**
 * Created by sweeneyliu on 2018/10/23.
 */
public class HookHelper {
    public static void hookCallback() {
        //先获取当前的ActivityThread对象
        Object currentActivityThread = RefInvoke.getFieldObject("android.app.ActivityThread",null,"sCurrentActivityThread");
        //由于ActivityThread一个进程只有一个，我们获取这个对象的mH
        Handler mH = (Handler) RefInvoke.getFieldObject("android.app.ActivityThread",currentActivityThread,"mH");
        //把handler的mCallback字段，替换为hook后的字段
        RefInvoke.setFieldObject("android.os.Handler",mH,"mCallback",new HookCallback(mH));
    }
}
