package com.pentavalue.yousry.rakaislamicapp.java.activities;

import java.util.Date;
import java.util.List;

/**
 * Created by yousry on 10/11/2017.
 */

public class Example {
    private String prayer_method_name;
    private String daylight;
    private String map_image;
    private String link;
    private String city;
    private String state;
    private String country;
    private String country_code;
    private int status_code;
    private java.util.List<Items> items;

    public String getPrayer_method_name() {
        return prayer_method_name;
    }

    public void setPrayer_method_name(String prayer_method_name) {
        this.prayer_method_name = prayer_method_name;
    }

    public String getDaylight() {
        return daylight;
    }

    public void setDaylight(String daylight) {
        this.daylight = daylight;
    }

    public String getMap_image() {
        return map_image;
    }

    public void setMap_image(String map_image) {
        this.map_image = map_image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public class Items {

        private Date dateFor;
        private String fajr;
        private String shurooq;
        private String dhuhr;
        private String asr;
        private String maghrib;
        private String isha;

        @Override
        public String toString() {
            return "Items{" +
                    "dateFor='" + dateFor + '\'' +
                    ", fajr='" + fajr + '\'' +
                    ", shurooq='" + shurooq + '\'' +
                    ", dhuhr='" + dhuhr + '\'' +
                    ", asr='" + asr + '\'' +
                    ", maghrib='" + maghrib + '\'' +
                    ", isha='" + isha + '\'' +
                    '}';
        }

        public String getDateFor() {
            return dateFor.toString();
        }

        public void setDateFor(String dateFor) {
            this.dateFor = new Date(dateFor);
        }

        public String getFajr() {
            return fajr;
        }

        public void setFajr(String fajr) {
            this.fajr = fajr;
        }

        public String getShurooq() {
            return shurooq;
        }

        public void setShurooq(String shurooq) {
            this.shurooq = shurooq;
        }

        public String getDhuhr() {
            return dhuhr;
        }

        public void setDhuhr(String dhuhr) {
            this.dhuhr = dhuhr;
        }

        public String getAsr() {
            return asr;
        }

        public void setAsr(String asr) {
            this.asr = asr;
        }

        public String getMaghrib() {
            return maghrib;
        }

        public void setMaghrib(String maghrib) {
            this.maghrib = maghrib;
        }

        public String getIsha() {
            return isha;
        }

        public void setIsha(String isha) {
            this.isha = isha;
        }

    }

}
