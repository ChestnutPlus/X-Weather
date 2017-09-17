package x.chestnut.weather.m.bean;

import java.util.List;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 22:19
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class SearchCityRawBean {

    public List<HeWeather5Bean> HeWeather5;

    public static class HeWeather5Bean {
        /**
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"直辖市"}
         * status : ok
         */
        public BasicBean basic;
        public String status;
        public static class BasicBean {
            /**
             * city : 北京
             * cnty : 中国
             * id : CN101010100
             * lat : 39.904000
             * lon : 116.391000
             * prov : 直辖市
             */
            public String city;
            public String cnty;
            public String id;
            public String lat;
            public String lon;
            public String prov;
        }
    }
}
