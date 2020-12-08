
package Model;


public abstract class Product {
    private static Integer id;
    private static Integer categoryID;
    private static String productName;
    private static Integer price;
    private static String decription;
    private static Integer weight;
    private static String brand;
    private static String color;
    private static String madeIn;
    private static String gender;
    private static Integer cSize;
    private static Integer stock;
    private static String photo;
    private static Integer is_active;

    public Product(Integer id, Integer categoryID, String productName, Integer price, String decription,Integer weight, String brand,String color,String madeIn, String gender,Integer cSize,Integer stock,String photo,Integer is_active) {
        Product.id = id;
        Product.categoryID = categoryID;
        Product.productName = productName;
        Product.price = price;
        Product.decription = decription;
        Product.weight = weight;
        Product.brand = brand;
        Product.color = color;
        Product.madeIn = madeIn;
        Product.gender = gender;
        Product.cSize = cSize;
        Product.stock = stock;
        Product.photo = photo;
        Product.is_active = is_active;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Product.id = id;
    }

    public static Integer getCategoryID() {
        return categoryID;
    }

    public static void setCategoryID(Integer categoryID) {
        Product.categoryID = categoryID;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        Product.productName = productName;
    }

    public static Integer getPrice() {
        return price;
    }

    public static void setPrice(Integer price) {
        Product.price = price;
    }

    public static String getDecription() {
        return decription;
    }

    public static void setDecription(String decription) {
        Product.decription = decription;
    }

    public static Integer getWeight() {
        return weight;
    }

    public static void setWeight(Integer weight) {
        Product.weight = weight;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        Product.brand = brand;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Product.color = color;
    }

    public static String getMadeIn() {
        return madeIn;
    }

    public static void setMadeIn(String madeIn) {
        Product.madeIn = madeIn;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Product.gender = gender;
    }

    public static Integer getcSize() {
        return cSize;
    }

    public static void setcSize(Integer cSize) {
        Product.cSize = cSize;
    }

    public static Integer getStock() {
        return stock;
    }

    public static void setStock(Integer stock) {
        Product.stock = stock;
    }

    public static String getPhoto() {
        return photo;
    }

    public static void setPhoto(String photo) {
        Product.photo = photo;
    }

    public static Integer getIs_active() {
        return is_active;
    }

    public static void setIs_active(Integer is_active) {
        Product.is_active = is_active;
    }
    
    
    
}
