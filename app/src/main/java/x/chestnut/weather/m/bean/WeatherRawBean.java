package x.chestnut.weather.m.bean;

import java.util.List;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 19:14
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class WeatherRawBean {
    public List<HeWeather5Bean> HeWeather5;
    public static class HeWeather5Bean {
        //空气质量
        public AqiBean aqi;
        public BasicBean basic;
        public NowBean now;
        public String status;
        public SuggestionBean suggestion;
        public List<DailyForecastBean> daily_forecast;
        public List<HourlyForecastBean> hourly_forecast;
        public static class AqiBean {
            public CityBean city;
            public static class CityBean {
                public String aqi;          //aqi值
                public String co;           //一氧化碳
                public String no2;          //二氧化氮
                public String o3;           //臭氧
                public String pm10;         //pm10
                public String pm25;         //pm2.5
                public String qlty;         //空气质量
                public String so2;          //二氧化硫
            }
        }

        public static class BasicBean {
            public String city;     //城市
            public String cnty;     //国家
            public String id;       //id
            public String lat;
            public String lon;
            public UpdateBean update;
            public static class UpdateBean {
                public String loc;
                public String utc;
            }
        }

        public static class NowBean {
            public CondBean cond;   //天气状况
            public String fl;
            public String hum;
            public String pcpn;
            public String pres;
            public String tmp;
            public String vis;
            public WindBean wind;
            public static class CondBean {
                public String code; //天气状况状态码
                public String txt;  //天气描述
            }

            public static class WindBean {
                public String deg;
                public String dir;
                public String sc;
                public String spd;
            }
        }

        public static class SuggestionBean {
            public AirBean air;
            public ComfBean comf;
            public CwBean cw;
            public DrsgBean drsg;
            public FluBean flu;
            public SportBean sport;
            public TravBean trav;
            public UvBean uv;

            public static class AirBean {
                public String brf;
                public String txt;
            }

            public static class ComfBean {
                public String brf;
                public String txt;
            }

            public static class CwBean {
                public String brf;
                public String txt;
            }

            public static class DrsgBean {
                public String brf;
                public String txt;
            }

            public static class FluBean {
                public String brf;
                public String txt;
            }

            public static class SportBean {
                public String brf;
                public String txt;
            }

            public static class TravBean {
                public String brf;
                public String txt;
            }

            public static class UvBean {
                public String brf;
                public String txt;
            }
        }

        public static class DailyForecastBean {
            public AstroBean astro;
            public CondBeanX cond;
            public String date;
            public String hum;
            public String pcpn;
            public String pop;
            public String pres;
            public TmpBean tmp;
            public String uv;
            public String vis;
            public WindBeanX wind;

            public static class AstroBean {
                public String mr;
                public String ms;
                public String sr;
                public String ss;
            }

            public static class CondBeanX {
                public String code_d;
                public String code_n;
                public String txt_d;
                public String txt_n;
            }

            public static class TmpBean {
                public String max;
                public String min;
            }

            public static class WindBeanX {
                public String deg;
                public String dir;
                public String sc;
                public String spd;
            }
        }

        public static class HourlyForecastBean {
            public CondBeanXX cond;
            public String date;
            public String hum;
            public String pop;
            public String pres;
            public String tmp;
            public WindBeanXX wind;
            public static class CondBeanXX {
                public String code;
                public String txt;
            }

            public static class WindBeanXX {
                public String deg;
                public String dir;
                public String sc;
                public String spd;
            }
        }
    }
}
