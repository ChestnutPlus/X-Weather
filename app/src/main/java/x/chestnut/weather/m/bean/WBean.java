package x.chestnut.weather.m.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 19:53
 *     desc  :  对接口返回的bean
 *              再封装一层，避免
 *              更换接口SDK所带来的
 *              不便修改。
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class WBean {

    public String cityName;     //城市
    public String countyName;   //国家
    public DailyForecastBean today; //今天天气
    public List<DailyForecastBean> dailyForecastBeanList;   //未来几天的天气预报

    public static class DailyForecastBean {
        public String date;                 //日期
        public long updateTimestampMs;      //更新的时间戳
        public String code;                 //天气状况状态码
        public String txt;                  //天气描述
        public String maxTemp;              //最高温度
        public String nowTemp;              //当前温度
        public String minTemp;              //最低温度

        public String feltAirTemperature;   //体感温度
        public String relativeHumidity;     //相对湿度
        public String pressure;             //气压
        public String precipitation;        //降水量
        public String windSpeed;            //风速
        public String visibilityKm;         //能见度，KM

        public String degreeOfComfortBrf;      //舒适度简述
        public String degreeOfComfortDesc;      //舒适度描述
        public String washCarBrf;               //洗车
        public String washCarDesc;
        public String dressingBrf;              //穿衣
        public String dressingDesc;
        public String sportBrf;                 //运动
        public String sportDesc;
        public String travelBrf;                //旅游
        public String travelDesc;
        public String uvBrf;                    //紫外线
        public String uvDesc;

        @Override
        public String toString() {
            return "DailyForecastBean{" +
                    "date='" + date + '\'' +
                    ", updateTimestampMs=" + updateTimestampMs +
                    ", code='" + code + '\'' +
                    ", txt='" + txt + '\'' +
                    ", maxTemp='" + maxTemp + '\'' +
                    ", nowTemp='" + nowTemp + '\'' +
                    ", minTemp='" + minTemp + '\'' +
                    ", feltAirTemperature='" + feltAirTemperature + '\'' +
                    ", relativeHumidity='" + relativeHumidity + '\'' +
                    ", pressure='" + pressure + '\'' +
                    ", precipitation='" + precipitation + '\'' +
                    ", windSpeed='" + windSpeed + '\'' +
                    ", visibilityKm='" + visibilityKm + '\'' +
                    ", degreeOfComfortBrf='" + degreeOfComfortBrf + '\'' +
                    ", degreeOfComfortDesc='" + degreeOfComfortDesc + '\'' +
                    ", washCarBrf='" + washCarBrf + '\'' +
                    ", washCarDesc='" + washCarDesc + '\'' +
                    ", dressingBrf='" + dressingBrf + '\'' +
                    ", dressingDesc='" + dressingDesc + '\'' +
                    ", sportBrf='" + sportBrf + '\'' +
                    ", sportDesc='" + sportDesc + '\'' +
                    ", travelBrf='" + travelBrf + '\'' +
                    ", travelDesc='" + travelDesc + '\'' +
                    ", uvBrf='" + uvBrf + '\'' +
                    ", uvDesc='" + uvDesc + '\'' +
                    '}';
        }
    }

    /**
     * 私有化构造方法，强制使用
     * 静态方法进行转换
     */
    private WBean() {}
    public static WBean change(WeatherRawBean weatherRawBean) {
        WBean wBean = new WBean();
        if (weatherRawBean!=null
                && weatherRawBean.HeWeather5!=null
                && weatherRawBean.HeWeather5.size()>0
                && weatherRawBean.HeWeather5.get(0).status.equalsIgnoreCase("ok")) {
            WeatherRawBean.HeWeather5Bean heWeather5Bean = weatherRawBean.HeWeather5.get(0);
            wBean.cityName = weatherRawBean.HeWeather5.get(0).basic.city;
            wBean.countyName = weatherRawBean.HeWeather5.get(0).basic.cnty;
            //toady
            DailyForecastBean today = new DailyForecastBean();
            SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd");
            today.date = myFmt2.format(new Date());
            today.updateTimestampMs = System.currentTimeMillis();
            today.code = heWeather5Bean.now.cond.code;
            today.txt = heWeather5Bean.now.cond.txt;
            today.nowTemp = heWeather5Bean.now.tmp;
            today.feltAirTemperature = heWeather5Bean.now.fl;
            today.relativeHumidity = heWeather5Bean.now.hum;
            today.pressure = heWeather5Bean.now.pres;
            today.precipitation = heWeather5Bean.now.pcpn;
            today.windSpeed = heWeather5Bean.now.wind.spd;
            today.visibilityKm = heWeather5Bean.now.vis;
            today.degreeOfComfortBrf = heWeather5Bean.suggestion.comf.brf;
            today.degreeOfComfortDesc = heWeather5Bean.suggestion.comf.txt;
            today.washCarBrf = heWeather5Bean.suggestion.cw.brf;
            today.washCarDesc = heWeather5Bean.suggestion.cw.txt;
            today.dressingBrf = heWeather5Bean.suggestion.drsg.brf;
            today.dressingDesc = heWeather5Bean.suggestion.drsg.txt;
            today.sportBrf = heWeather5Bean.suggestion.sport.brf;
            today.sportDesc = heWeather5Bean.suggestion.sport.txt;
            today.travelBrf = heWeather5Bean.suggestion.trav.brf;
            today.travelDesc = heWeather5Bean.suggestion.trav.txt;
            today.uvBrf = heWeather5Bean.suggestion.uv.brf;
            today.uvDesc = heWeather5Bean.suggestion.uv.txt;
            wBean.today = today;
            //未来几天
            if (heWeather5Bean.daily_forecast!=null) {
                List<DailyForecastBean> l = new ArrayList<>();
                for (x.chestnut.weather.m.bean.WeatherRawBean.HeWeather5Bean.DailyForecastBean d : heWeather5Bean.daily_forecast) {
                    DailyForecastBean dx = new DailyForecastBean();
                    dx.date = d.date;
                    dx.updateTimestampMs = System.currentTimeMillis();
                    dx.code = d.cond.code_d;
                    dx.txt = d.cond.txt_d;
                    dx.maxTemp = d.tmp.max;
                    dx.minTemp = d.tmp.min;
                    dx.relativeHumidity = d.hum;
                    dx.pressure = d.pres;
                    dx.precipitation = d.pcpn;
                    dx.windSpeed = d.wind.spd;
                    dx.visibilityKm = d.vis;
                    l.add(dx);
                }
                wBean.dailyForecastBeanList = l;
            }
        }
        return wBean;
    }

    /**
     * 更新天气数据
     * @param wBean wBean
     * @param updateWeatherRawBean updateWeatherRawBean
     */
    public static void update(WBean wBean,UpdateWeatherRawBean updateWeatherRawBean) {
        if (wBean != null
                && updateWeatherRawBean != null
                && updateWeatherRawBean.HeWeather5!=null
                && updateWeatherRawBean.HeWeather5.size()>0
                && updateWeatherRawBean.HeWeather5.get(0).basic.city.equalsIgnoreCase(wBean.cityName)){
            wBean.today.updateTimestampMs = System.currentTimeMillis();
            wBean.today.code = updateWeatherRawBean.HeWeather5.get(0).now.cond.code;
            wBean.today.txt = updateWeatherRawBean.HeWeather5.get(0).now.cond.txt;
            wBean.today.nowTemp = updateWeatherRawBean.HeWeather5.get(0).now.tmp;
            wBean.today.feltAirTemperature = updateWeatherRawBean.HeWeather5.get(0).now.fl;
            wBean.today.relativeHumidity = updateWeatherRawBean.HeWeather5.get(0).now.hum;
            wBean.today.pressure = updateWeatherRawBean.HeWeather5.get(0).now.pres;
            wBean.today.precipitation = updateWeatherRawBean.HeWeather5.get(0).now.pcpn;
            wBean.today.windSpeed = updateWeatherRawBean.HeWeather5.get(0).now.wind.spd;
            wBean.today.visibilityKm = updateWeatherRawBean.HeWeather5.get(0).now.vis;
        }
    }
}
