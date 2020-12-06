
package Model;


public abstract class OrderItem {
    private static Integer productID;
    private static Integer orderID;

    public OrderItem(Integer productID, Integer orderID) {
        OrderItem.productID = productID;
        OrderItem.orderID = orderID;
    }
    

    public static Integer getProductID() {
        return productID;
    }

    public static void setProductID(Integer productID) {
        OrderItem.productID = productID;
    }

    public static Integer getOrderID() {
        return orderID;
    }

    public static void setOrderID(Integer orderID) {
        OrderItem.orderID = orderID;
    }
    
    
    
}
