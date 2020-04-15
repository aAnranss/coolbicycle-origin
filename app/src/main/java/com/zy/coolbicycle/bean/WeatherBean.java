package com.zy.coolbicycle.bean;

import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/15
 */
public class WeatherBean {

    /**
     * status : ok
     * api_version : v2.2
     * api_status : active
     * server_time : 1586934292
     * location : [25.1552,121.6544]
     * tzshift : 28800
     * lang : zh_CN
     * unit : metric
     * result : {"status":"ok","temperature":22,"humidity":0.65,"cloudrate":0.37,"skycon":"PARTLY_CLOUDY_DAY","visibility":24.13,"dswrf":548.1,"wind":{"speed":19.09,"direction":292.58},"pres":99775.22,"apparent_temperature":20.2,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":24,"intensity":2}},"aqi":11,"pm25":8,"ultraviolet":{"index":5,"desc":"中等"},"comfort":{"index":6,"desc":"凉爽"}}
     */

    private String status;
    private String api_version;
    private String api_status;
    private int server_time;
    private int tzshift;
    private String lang;
    private String unit;
    private ResultBean result;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * status : ok
         * temperature : 22
         * humidity : 0.65
         * cloudrate : 0.37
         * skycon : PARTLY_CLOUDY_DAY
         * visibility : 24.13
         * dswrf : 548.1
         * wind : {"speed":19.09,"direction":292.58}
         * pres : 99775.22
         * apparent_temperature : 20.2
         * precipitation : {"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":24,"intensity":2}}
         * aqi : 11
         * pm25 : 8
         * ultraviolet : {"index":5,"desc":"中等"}
         * comfort : {"index":6,"desc":"凉爽"}
         */

        private String status;
        private int temperature;
        private double humidity;
        private double cloudrate;
        private String skycon;
        private double visibility;
        private double dswrf;
        private WindBean wind;
        private double pres;
        private double apparent_temperature;
        private PrecipitationBean precipitation;
        private int aqi;
        private int pm25;
        private UltravioletBean ultraviolet;
        private ComfortBean comfort;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getCloudrate() {
            return cloudrate;
        }

        public void setCloudrate(double cloudrate) {
            this.cloudrate = cloudrate;
        }

        public String getSkycon() {
            return skycon;
        }

        public void setSkycon(String skycon) {
            this.skycon = skycon;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public double getDswrf() {
            return dswrf;
        }

        public void setDswrf(double dswrf) {
            this.dswrf = dswrf;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public double getPres() {
            return pres;
        }

        public void setPres(double pres) {
            this.pres = pres;
        }

        public double getApparent_temperature() {
            return apparent_temperature;
        }

        public void setApparent_temperature(double apparent_temperature) {
            this.apparent_temperature = apparent_temperature;
        }

        public PrecipitationBean getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(PrecipitationBean precipitation) {
            this.precipitation = precipitation;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public UltravioletBean getUltraviolet() {
            return ultraviolet;
        }

        public void setUltraviolet(UltravioletBean ultraviolet) {
            this.ultraviolet = ultraviolet;
        }

        public ComfortBean getComfort() {
            return comfort;
        }

        public void setComfort(ComfortBean comfort) {
            this.comfort = comfort;
        }

        public static class WindBean {
            /**
             * speed : 19.09
             * direction : 292.58
             */

            private double speed;
            private double direction;

            public double getSpeed() {
                return speed;
            }

            public void setSpeed(double speed) {
                this.speed = speed;
            }

            public double getDirection() {
                return direction;
            }

            public void setDirection(double direction) {
                this.direction = direction;
            }
        }

        public static class PrecipitationBean {
            /**
             * local : {"status":"ok","datasource":"radar","intensity":0}
             * nearest : {"status":"ok","distance":24,"intensity":2}
             */

            private LocalBean local;
            private NearestBean nearest;

            public LocalBean getLocal() {
                return local;
            }

            public void setLocal(LocalBean local) {
                this.local = local;
            }

            public NearestBean getNearest() {
                return nearest;
            }

            public void setNearest(NearestBean nearest) {
                this.nearest = nearest;
            }

            public static class LocalBean {
                /**
                 * status : ok
                 * datasource : radar
                 * intensity : 0
                 */

                private String status;
                private String datasource;
                private int intensity;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getDatasource() {
                    return datasource;
                }

                public void setDatasource(String datasource) {
                    this.datasource = datasource;
                }

                public int getIntensity() {
                    return intensity;
                }

                public void setIntensity(int intensity) {
                    this.intensity = intensity;
                }
            }

            public static class NearestBean {
                /**
                 * status : ok
                 * distance : 24
                 * intensity : 2
                 */

                private String status;
                private int distance;
                private int intensity;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public int getDistance() {
                    return distance;
                }

                public void setDistance(int distance) {
                    this.distance = distance;
                }

                public int getIntensity() {
                    return intensity;
                }

                public void setIntensity(int intensity) {
                    this.intensity = intensity;
                }
            }
        }

        public static class UltravioletBean {
            /**
             * index : 5
             * desc : 中等
             */

            private int index;
            private String desc;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class ComfortBean {
            /**
             * index : 6
             * desc : 凉爽
             */

            private int index;
            private String desc;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
