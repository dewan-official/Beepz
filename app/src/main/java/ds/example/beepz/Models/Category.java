package ds.example.beepz.Models;

public class Category {
    private int categoryId;
    private String categoryName, icon, details;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String icon, String details) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.icon = icon;
        this.details = details;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
