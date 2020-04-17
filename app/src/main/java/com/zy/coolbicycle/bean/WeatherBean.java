package com.zy.coolbicycle.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/15
 */
public class WeatherBean {


    /**
     * resultcode : 200
     * reason : successed!
     * result : {"sk":{"temp":"22","wind_direction":"东北风","wind_strength":"1级","humidity":"86%","time":"21:38"},"today":{"temperature":"21℃~25℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期五","city":"来宾","date_y":"2020年04月17日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"最弱","comfort_index":"","wash_index":"较适宜","travel_index":"较适宜","exercise_index":"较适宜","drying_index":""},"future":{"day_20200417":{"temperature":"21℃~25℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期五","date":"20200417"},"day_20200418":{"temperature":"21℃~26℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"南风微风","week":"星期六","date":"20200418"},"day_20200419":{"temperature":"22℃~27℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"南风微风","week":"星期日","date":"20200419"},"day_20200420":{"temperature":"21℃~28℃","weather":"阴转小雨","weather_id":{"fa":"02","fb":"07"},"wind":"北风微风","week":"星期一","date":"20200420"},"day_20200421":{"temperature":"17℃~23℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"北风微风","week":"星期二","date":"20200421"},"day_20200422":{"temperature":"21℃~28℃","weather":"阴转小雨","weather_id":{"fa":"02","fb":"07"},"wind":"北风微风","week":"星期三","date":"20200422"},"day_20200423":{"temperature":"22℃~27℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"南风微风","week":"星期四","date":"20200423"}}}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * sk : {"temp":"22","wind_direction":"东北风","wind_strength":"1级","humidity":"86%","time":"21:38"}
         * today : {"temperature":"21℃~25℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期五","city":"来宾","date_y":"2020年04月17日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"最弱","comfort_index":"","wash_index":"较适宜","travel_index":"较适宜","exercise_index":"较适宜","drying_index":""}
         * future : {"day_20200417":{"temperature":"21℃~25℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期五","date":"20200417"},"day_20200418":{"temperature":"21℃~26℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"南风微风","week":"星期六","date":"20200418"},"day_20200419":{"temperature":"22℃~27℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"南风微风","week":"星期日","date":"20200419"},"day_20200420":{"temperature":"21℃~28℃","weather":"阴转小雨","weather_id":{"fa":"02","fb":"07"},"wind":"北风微风","week":"星期一","date":"20200420"},"day_20200421":{"temperature":"17℃~23℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"北风微风","week":"星期二","date":"20200421"},"day_20200422":{"temperature":"21℃~28℃","weather":"阴转小雨","weather_id":{"fa":"02","fb":"07"},"wind":"北风微风","week":"星期三","date":"20200422"},"day_20200423":{"temperature":"22℃~27℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"南风微风","week":"星期四","date":"20200423"}}
         */

        private SkBean sk;
        private TodayBean today;
        private FutureBean future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public FutureBean getFuture() {
            return future;
        }

        public void setFuture(FutureBean future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * temp : 22
             * wind_direction : 东北风
             * wind_strength : 1级
             * humidity : 86%
             * time : 21:38
             */

            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * temperature : 21℃~25℃
             * weather : 阴
             * weather_id : {"fa":"02","fb":"02"}
             * wind : 南风微风
             * week : 星期五
             * city : 来宾
             * date_y : 2020年04月17日
             * dressing_index : 舒适
             * dressing_advice : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
             * uv_index : 最弱
             * comfort_index :
             * wash_index : 较适宜
             * travel_index : 较适宜
             * exercise_index : 较适宜
             * drying_index :
             */

            private String temperature;
            private String weather;
            private WeatherIdBean weather_id;
            private String wind;
            private String week;
            private String city;
            private String date_y;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 02
                 * fb : 02
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * day_20200417 : {"temperature":"21℃~25℃","weather":"阴","weather_id":{"fa":"02","fb":"02"},"wind":"南风微风","week":"星期五","date":"20200417"}
             * day_20200418 : {"temperature":"21℃~26℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"南风微风","week":"星期六","date":"20200418"}
             * day_20200419 : {"temperature":"22℃~27℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"南风微风","week":"星期日","date":"20200419"}
             * day_20200420 : {"temperature":"21℃~28℃","weather":"阴转小雨","weather_id":{"fa":"02","fb":"07"},"wind":"北风微风","week":"星期一","date":"20200420"}
             * day_20200421 : {"temperature":"17℃~23℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"北风微风","week":"星期二","date":"20200421"}
             * day_20200422 : {"temperature":"21℃~28℃","weather":"阴转小雨","weather_id":{"fa":"02","fb":"07"},"wind":"北风微风","week":"星期三","date":"20200422"}
             * day_20200423 : {"temperature":"22℃~27℃","weather":"小雨转阴","weather_id":{"fa":"07","fb":"02"},"wind":"南风微风","week":"星期四","date":"20200423"}
             */

            private Day20200417Bean day_20200417;
            private Day20200418Bean day_20200418;
            private Day20200419Bean day_20200419;
            private Day20200420Bean day_20200420;
            private Day20200421Bean day_20200421;
            private Day20200422Bean day_20200422;
            private Day20200423Bean day_20200423;

            public Day20200417Bean getDay_20200417() {
                return day_20200417;
            }

            public void setDay_20200417(Day20200417Bean day_20200417) {
                this.day_20200417 = day_20200417;
            }

            public Day20200418Bean getDay_20200418() {
                return day_20200418;
            }

            public void setDay_20200418(Day20200418Bean day_20200418) {
                this.day_20200418 = day_20200418;
            }

            public Day20200419Bean getDay_20200419() {
                return day_20200419;
            }

            public void setDay_20200419(Day20200419Bean day_20200419) {
                this.day_20200419 = day_20200419;
            }

            public Day20200420Bean getDay_20200420() {
                return day_20200420;
            }

            public void setDay_20200420(Day20200420Bean day_20200420) {
                this.day_20200420 = day_20200420;
            }

            public Day20200421Bean getDay_20200421() {
                return day_20200421;
            }

            public void setDay_20200421(Day20200421Bean day_20200421) {
                this.day_20200421 = day_20200421;
            }

            public Day20200422Bean getDay_20200422() {
                return day_20200422;
            }

            public void setDay_20200422(Day20200422Bean day_20200422) {
                this.day_20200422 = day_20200422;
            }

            public Day20200423Bean getDay_20200423() {
                return day_20200423;
            }

            public void setDay_20200423(Day20200423Bean day_20200423) {
                this.day_20200423 = day_20200423;
            }

            public static class Day20200417Bean {
                /**
                 * temperature : 21℃~25℃
                 * weather : 阴
                 * weather_id : {"fa":"02","fb":"02"}
                 * wind : 南风微风
                 * week : 星期五
                 * date : 20200417
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanX {
                    /**
                     * fa : 02
                     * fb : 02
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20200418Bean {
                /**
                 * temperature : 21℃~26℃
                 * weather : 小雨
                 * weather_id : {"fa":"07","fb":"07"}
                 * wind : 南风微风
                 * week : 星期六
                 * date : 20200418
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXX {
                    /**
                     * fa : 07
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20200419Bean {
                /**
                 * temperature : 22℃~27℃
                 * weather : 小雨转阴
                 * weather_id : {"fa":"07","fb":"02"}
                 * wind : 南风微风
                 * week : 星期日
                 * date : 20200419
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXX {
                    /**
                     * fa : 07
                     * fb : 02
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20200420Bean {
                /**
                 * temperature : 21℃~28℃
                 * weather : 阴转小雨
                 * weather_id : {"fa":"02","fb":"07"}
                 * wind : 北风微风
                 * week : 星期一
                 * date : 20200420
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXX {
                    /**
                     * fa : 02
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20200421Bean {
                /**
                 * temperature : 17℃~23℃
                 * weather : 小雨
                 * weather_id : {"fa":"07","fb":"07"}
                 * wind : 北风微风
                 * week : 星期二
                 * date : 20200421
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXX {
                    /**
                     * fa : 07
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20200422Bean {
                /**
                 * temperature : 21℃~28℃
                 * weather : 阴转小雨
                 * weather_id : {"fa":"02","fb":"07"}
                 * wind : 北风微风
                 * week : 星期三
                 * date : 20200422
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXX {
                    /**
                     * fa : 02
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20200423Bean {
                /**
                 * temperature : 22℃~27℃
                 * weather : 小雨转阴
                 * weather_id : {"fa":"07","fb":"02"}
                 * wind : 南风微风
                 * week : 星期四
                 * date : 20200423
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXXX {
                    /**
                     * fa : 07
                     * fb : 02
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }
        }
    }
}
