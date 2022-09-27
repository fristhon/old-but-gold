package co.sokhanvar.app;

import android.app.Application;

public class Smodel extends Application {

  private static String locationName;
  private static String number;
  private static String password;

  private static String currentSelect;

  private static Boolean sms = false;

  private static Double userLatitude;
  private static Double userLongitude;

  private static String body;

  private static String latitude;
  private static String longitude;

  private static String speed;
  private static String direction;
  private static String car;
  private static String oil;
  private static String door;
  private static String alarm;
  private static String hour;
  private static String minute;
  private static String day;
  private static String month;
  private static String year;

  private static Boolean net = false;

  public static String getLocationName() {
    return locationName;
  }

  public static void setLocationName(String locationName) {
    Smodel.locationName = locationName;
  }

  public static String getNumber() {
    return number;
  }

  public static void setNumber(String number) {
    Smodel.number = number;
  }

  public static String getPassword() {
    return password;
  }

  public static void setPassword(String password) {
    Smodel.password = password;
  }

  public static Double getUserLatitude() {
    return userLatitude;
  }

  public static void setUserLatitude(Double userLatitude) {
    Smodel.userLatitude = userLatitude;
  }

  public static Double getUserLongitude() {
    return userLongitude;
  }

  public static void setUserLongitude(Double userLongitude) {
    Smodel.userLongitude = userLongitude;
  }

  public static String getBody() {
    return body;
  }

  public static void setBody(String body) {
    Smodel.body = body;
  }

  public static String getLatitude() {
    return latitude;
  }

  public static void setLatitude(String latitude) {
    Smodel.latitude = latitude;
  }

  public static String getLongitude() {
    return longitude;
  }

  public static void setLongitude(String longitude) {
    Smodel.longitude = longitude;
  }

  public static String getSpeed() {
    return speed;
  }

  public static void setSpeed(String speed) {
    Smodel.speed = speed;
  }

  public static String getDirection() {
    return direction;
  }

  public static void setDirection(String direction) {
    Smodel.direction = direction;
  }

  public static String getCar() {
    return car;
  }

  public static void setCar(String car) {
    Smodel.car = car;
  }

  public static String getOil() {
    return oil;
  }

  public static void setOil(String oil) {
    Smodel.oil = oil;
  }

  public static String getDoor() {
    return door;
  }

  public static void setDoor(String door) {
    Smodel.door = door;
  }

  public static String getAlarm() {
    return alarm;
  }

  public static void setAlarm(String alarm) {
    Smodel.alarm = alarm;
  }

  public static String getHour() {
    return hour;
  }

  public static void setHour(String hour) {
    Smodel.hour = hour;
  }

  public static String getMinute() {
    return minute;
  }

  public static void setMinute(String minute) {
    Smodel.minute = minute;
  }

  public static Boolean getSms() {
    return sms;
  }

  public static void setSms(Boolean sms) {
    Smodel.sms = sms;
  }

  public static Boolean getNet() {
    return net;
  }

  public static void setNet(Boolean net) {
    Smodel.net = net;
  }

  public static String getCurrentSelect() {
    return currentSelect;
  }

  public static void setCurrentSelect(String currentSelect) {
    Smodel.currentSelect = currentSelect;
  }

  public static String getDay() {
    return day;
  }

  public static void setDay(String day) {
    Smodel.day = day;
  }

  public static String getMonth() {
    return month;
  }

  public static void setMonth(String month) {
    Smodel.month = month;
  }

  public static String getYear() {
    return year;
  }

  public static void setYear(String year) {
    Smodel.year = year;
  }
}
