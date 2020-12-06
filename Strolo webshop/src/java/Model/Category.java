
package Model;


public abstract class Category {
    private static Integer id;
    private static String categoryName;

    public static Integer getId() {
        return id;
    }

    public static String getCategoryName() {
        return categoryName;
    }

    public Category(Integer id, String categoryName) {
        Category.id = id;
        Category.categoryName = categoryName;
    }
    
    
}
