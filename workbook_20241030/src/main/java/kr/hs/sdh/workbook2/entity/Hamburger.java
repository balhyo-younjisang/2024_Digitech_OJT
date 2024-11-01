package kr.hs.sdh.workbook2.entity;

import java.util.Objects;

public class Hamburger {
    private String name;
    private Integer price;
    private String imagePath;
    private Boolean isNew;
    private Boolean isRecommended;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(Boolean isRecommended) {
        this.isRecommended = isRecommended;
    }

    public Hamburger() {
    }

    public Hamburger(String name, Integer price, String imagePath, Boolean isNew, Boolean isRecommended) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.isNew = isNew;
        this.isRecommended = isRecommended;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Hamburger hamburger) {
            return this.name.contentEquals(hamburger.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 123;
    }
}
