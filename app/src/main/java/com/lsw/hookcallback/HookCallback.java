package com.lsw.hookcallback;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by sweeneyliu on 2018/10/23.
 */
public class HookCallback implements Handler.Callback {

    private static final String TAG = "HookCallback";

    Handler mBase;

    public HookCallback(Handler mBase) {
        this.mBase = mBase;
    }


    @Override
    public boolean handleMessage(Message msg) {

        Log.i(TAG, "handleMessage: "+msg.what);

        switch (msg.what){
            case 100:
                Object object = msg.obj;
                Log.i(TAG, "handleMessage: "+object.toString());
                break;
        }
        mBase.handleMessage(msg);
        return true;
    }
}
