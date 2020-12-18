
package Model;

import java.util.ArrayList;
import java.util.List;


public abstract class Order {
    
    private static Integer id;
    private static String uFirstName;
    private static String uLastName;
    private static String uEmail;
    private static String uZipCode;
    private static String uCity;
    private static String uAddress;
    private static String uPhone;
    private static Integer orderAmount;
    private static Integer isActive;
    private static String datas = null;
    private static List<Integer> productList = new ArrayList<>();        
    
    
    public Order(Integer id, String uFirstName, String uLastName, String uEmail, String uZipCode, String uCity, String uAddress, String uPhone, Integer orderAmount, Integer isActive,String datas, List<Integer> productList) {
        Order.id = id;
        Order.uFirstName = uFirstName;
        Order.uLastName = uLastName;
        Order.uEmail = uEmail;
        Order.uZipCode = uZipCode;
        Order.uCity = uCity;
        Order.uAddress = uAddress;
        Order.uPhone = uPhone;
        Order.orderAmount = orderAmount;
        Order.isActive = isActive;
        Order.datas = datas;
        Order.productList = productList;
    }

    public static String getDatas() {
        return datas;
    }

    public static void setDatas(String datas) {
        Order.datas = datas;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Order.id = id;
    }

    public static String getuFirstName() {
        return uFirstName;
    }

    public static void setuFirstName(String uFirstName) {
        Order.uFirstName = uFirstName;
    }

    public static String getuLastName() {
        return uLastName;
    }

    public static void setuLastName(String uLastName) {
        Order.uLastName = uLastName;
    }

    public static String getuEmail() {
        return uEmail;
    }

    public static void setuEmail(String uEmail) {
        Order.uEmail = uEmail;
    }

    public static String getuZipCode() {
        return uZipCode;
    }

    public static void setuZipCode(String uZipCode) {
        Order.uZipCode = uZipCode;
    }

    public static String getuCity() {
        return uCity;
    }

    public static void setuCity(String uCity) {
        Order.uCity = uCity;
    }

    public static String getuAddress() {
        return uAddress;
    }

    public static void setuAddress(String uAddress) {
        Order.uAddress = uAddress;
    }

    public static String getuPhone() {
        return uPhone;
    }

    public static void setuPhone(String uPhone) {
        Order.uPhone = uPhone;
    }

    public static int getOrderAmount() {
        return orderAmount;
    }

    public static void setOrderAmount(int orderAmount) {
        Order.orderAmount = orderAmount;
    }

    public static int getIsActive() {
        return isActive;
    }

    public static void setIsActive(int isActive) {
        Order.isActive = isActive;
    }

    public static List<Integer> getProductList() {
        return productList;
    }

    public static void setProductList(List<Integer> productList) {
        Order.productList = productList;
    }

    
    
}
