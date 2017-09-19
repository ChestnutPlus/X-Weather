package x.chestnut.weather.p;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import x.chestnut.weather.contract.WeatherContract;
import x.chestnut.weather.m.bean.WBean;
import x.chestnut.weather.m.web.Net;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/18 22:44
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class WeatherPresenter implements WeatherContract.P {

    private WeatherContract.V mView;
    private String cityName;
    private Subscription subscription;
    private WBean wBean;

    public WeatherPresenter(WeatherContract.V mView,String cityName) {
        this.mView = mView;
        this.cityName = cityName;
    }

    @Override
    public void onSubscribe() {

    }

    @Override
    public void onUnSubscribe() {
        mView = null;
        if (subscription!=null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
        subscription = null;
    }

    @Override
    public void updateAllData() {
        mView.notifyUpdateStart();
        if (subscription==null) {
            if (wBean==null)
                subscription = Net.getAllWeatherData(cityName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(wBean -> {
                            WeatherPresenter.this.wBean = wBean;
                            if (wBean != null)
                                mView.notifyUpdateEnd(wBean);
                            else
                                mView.notifyUpdateFail();
                            subscription = null;
                        },throwable -> {
                            mView.notifyUpdateFail();
                            subscription = null;
                        });
            else
                mView.notifyUpdateEnd(wBean);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void reLoad() {

    }
}
