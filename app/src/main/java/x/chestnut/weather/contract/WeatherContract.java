package x.chestnut.weather.contract;

import x.chestnut.weather.base.MvpBasePresenter;
import x.chestnut.weather.base.MvpBaseView;
import x.chestnut.weather.m.bean.WBean;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/18 22:39
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public interface WeatherContract {
    interface P extends MvpBasePresenter {
        void updateAllData();       //刷新所有的数据
        void update();   //刷新天气数据
        void reLoad();              //当加载失败后，重新加载数据
    }

    interface V extends MvpBaseView<P> {
        void notifyUpdateStart();
        void notifyUpdateFail();
        void notifyUpdateEnd(WBean wBean);
    }
}
