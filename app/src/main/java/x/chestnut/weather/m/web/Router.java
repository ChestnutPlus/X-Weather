package x.chestnut.weather.m.web;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 17:54
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class Router {
    private static final String KEY = "f4ab902790cd42ad8d826355c447e630";
    public static final int HTTPS_REQUEST_TIMEOUT_MS = 1000*5;          //Https请求的超时
    public static final int HTTPS_CACHE_TIME_SECOND = 10;              //Https请求的缓存时间，单位：分钟

    public static final String GET_ALL_WEATHER_DATA = "https://free-api.heweather.com/v5/weather?key="+KEY+"&city=";
    public static final String UPDATE_WEATHER_DATA = "https://free-api.heweather.com/v5/now?key="+KEY+"&city=";
    public static final String SEARCH_CITY = "https://api.heweather.com/v5/search?key="+KEY+"&city=";
}
