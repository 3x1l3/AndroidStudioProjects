package com.example.exile.weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by exile on 24/05/15.
 */
public class CurrentWeather {

    private String mIcon;
    private long mTime;
    private double mTemperature;
    private double mHumiditiy;
    private double mPrecipChance;
    private String mSummary;
    private String mTimezone;

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String mTimezone) {
        this.mTimezone = mTimezone;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumiditiy() {
        return mHumiditiy;
    }

    public void setHumiditiy(double humiditiy) {
        mHumiditiy = humiditiy;
    }

    public double getPrecipChance() {
        return mPrecipChance;
    }

    public void setPrecipChance(double precipChance) {
        mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getFormattedTime() {

        SimpleDateFormat formatter = new SimpleDateFormat("H:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        Date date = new Date(getTime() * 1000);
        String timeString = formatter.format(date);

        return timeString;

    }


}
