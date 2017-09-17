package x.chestnut.weather.base;

import android.app.Application;

import com.chestnut.Common.utils.UtilsManager;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 14:35
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class WeatherApplication extends Application{

    private boolean init = false;

    @Override
    public void onCreate() {
        super.onCreate();
        checkInit();
    }

    public void checkInit() {
        if (!init) {
            UtilsManager.init(this);
            init = true;
        }
    }
}
