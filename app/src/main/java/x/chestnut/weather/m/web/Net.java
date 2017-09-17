package x.chestnut.weather.m.web;

import com.chestnut.Common.utils.LogUtils;
import com.chestnut.Common.utils.XJsonUtils;
import com.kymjs.rxvolley.RxVolley;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import x.chestnut.weather.m.bean.SearchCityRawBean;
import x.chestnut.weather.m.bean.UpdateWeatherRawBean;
import x.chestnut.weather.m.bean.WBean;
import x.chestnut.weather.m.bean.WeatherRawBean;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 14:38
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class Net {

    private static String TAG = "Net";
    private static boolean OpenLog = true;

    /**
     * 获取所有的天气数据
     * 包括，今天的天气，未来的预报
     * @param cityName  城市名称
     * @return  bean
     */
    public static Observable<WBean> getAllWeatherData(String cityName) {
        return new RxVolley.Builder()
                .url(Router.GET_ALL_WEATHER_DATA+cityName)
                .timeout(Router.HTTPS_REQUEST_TIMEOUT_MS)
                .httpMethod(RxVolley.Method.GET)
                .getResult()
                .map(result -> {
                    if (result!=null && result.isSuccess()) {
                        String s = new String(result.data);
                        LogUtils.i(OpenLog,TAG,"getAllWeatherData:"+"result:"+s);
                        WeatherRawBean weatherRawBean = XJsonUtils.getInstance().getBean(s, WeatherRawBean.class);
                        if (weatherRawBean!=null)
                            return WBean.change(weatherRawBean);
                        else
                            return null;
                    }
                    else
                        return null;
                })
                .onErrorResumeNext(throwable -> {
                    LogUtils.e(OpenLog,TAG,"getAllWeatherData:"+"err:"+throwable.getMessage());
                    return Observable.just(null);
                });
    }

    /**
     * 更新天气数据，
     *  更新的是今天的天气
     * @param wBean wBean
     * @param cityName  城市名称
     * @return  true/false
     */
    public static Observable<Boolean> updateWeatherData(WBean wBean,String cityName) {
        return new RxVolley.Builder()
                .url(Router.UPDATE_WEATHER_DATA+cityName)
                .timeout(Router.HTTPS_REQUEST_TIMEOUT_MS)
                .httpMethod(RxVolley.Method.GET)
                .getResult()
                .map(result -> {
                    if (result!=null && result.isSuccess()) {
                        String s = new String(result.data);
                        LogUtils.i(OpenLog,TAG,"updateWeatherData:"+"result:"+s);
                        UpdateWeatherRawBean weatherRawBean = XJsonUtils.getInstance().getBean(s, UpdateWeatherRawBean.class);
                        if (weatherRawBean!=null) {
                            WBean.update(wBean, weatherRawBean);
                            return true;
                        }
                        else
                            return false;
                    }
                    else
                        return false;
                })
                .onErrorResumeNext(throwable -> {
                    LogUtils.e(OpenLog,TAG,"updateWeatherData:"+"err:"+throwable.getMessage());
                    return Observable.just(false);
                });
    }

    public static Observable<Boolean> updateWeatherData(WBean wBean) {
        return updateWeatherData(wBean,wBean.cityName);
    }

    /**
     * 搜索城市
     * @param cityName  关键词
     * @return  list city
     */
    public static Observable<List<String>> searchCity(String cityName) {
        return new RxVolley.Builder()
                .url(Router.SEARCH_CITY+cityName)
                .timeout(Router.HTTPS_REQUEST_TIMEOUT_MS)
                .httpMethod(RxVolley.Method.GET)
                .getResult()
                .map(result -> {
                    if (result!=null && result.isSuccess()) {
                        String s = new String(result.data);
                        LogUtils.i(OpenLog,TAG,"searchCity:"+"result:"+s);
                        SearchCityRawBean searchCityRawBean = XJsonUtils.getInstance().getBean(s, SearchCityRawBean.class);
                        if (searchCityRawBean!=null) {
                            List<String> stringList = new ArrayList<>();
                            for (SearchCityRawBean.HeWeather5Bean h:searchCityRawBean.HeWeather5 )
                                if (h.status.equalsIgnoreCase("ok"))
                                    stringList.add(h.basic.city);
                            return stringList;
                        }
                        else
                            return null;
                    }
                    else
                        return null;
                })
                .onErrorResumeNext(throwable -> {
                    LogUtils.e(OpenLog,TAG,"searchCity:"+"err:"+throwable.getMessage());
                    return Observable.just(null);
                });
    }
}
