package x.chestnut.weather.m.bean;

import java.util.List;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 21:54
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class UpdateWeatherRawBean {

    public List<HeWeather5Bean> HeWeather5;

    public static class HeWeather5Bean {
        /**
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}}
         * now : {"cond":{"code":"104","txt":"阴"},"fl":"11","hum":"31","pcpn":"0","pres":"1025","tmp":"13","vis":"10","wind":{"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}}
         * status : ok
         */
        public BasicBean basic;
        public NowBean now;
        public String status;
        public static class BasicBean {
            /**
             * city : 北京
             * cnty : 中国
             * id : CN101010100
             * lat : 39.904000
             * lon : 116.391000
             * prov : 北京
             * update : {"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}
             */
            public String city;
            public String cnty;
            public String id;
            public String lat;
            public String lon;
            public String prov;
            public UpdateBean update;
            public static class UpdateBean {
                /**
                 * loc : 2016-08-31 11:52
                 * utc : 2016-08-31 03:52
                 */
                public String loc;
                public String utc;
            }
        }

        public static class NowBean {
            /**
             * cond : {"code":"104","txt":"阴"}
             * fl : 11
             * hum : 31
             * pcpn : 0
             * pres : 1025
             * tmp : 13
             * vis : 10
             * wind : {"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}
             */
            public CondBean cond;
            public String fl;
            public String hum;
            public String pcpn;
            public String pres;
            public String tmp;
            public String vis;
            public WindBean wind;

            public static class CondBean {
                /**
                 * code : 104
                 * txt : 阴
                 */
                public String code;
                public String txt;
            }

            public static class WindBean {
                /**
                 * deg : 40
                 * dir : 东北风
                 * sc : 4-5
                 * spd : 24
                 */
                public String deg;
                public String dir;
                public String sc;
                public String spd;
            }
        }
    }
}
