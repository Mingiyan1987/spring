package ru.basanov.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appCategory")
@NamedQueries({
        @NamedQuery(name = Category.QUERY_GET_BY_ID, query = "SELECT e FROM Category e WHERE e.id = :id"),
        @NamedQuery(name = Category.QUERY_REMOVE_BY_ID, query = "DELETE FROM Category e WHERE Ad.id = :id"),
        @NamedQuery(name = Category.QUERY_FIND_ALL, query = "SELECT e FROM Category e"),
        @NamedQuery(name = Category.QUERY_REMOVE_ALL, query = "DELETE FROM Category e")
})
public class Category {

    public static final String QUERY_GET_BY_ID = "Category.getById";

    public static final String QUERY_REMOVE_BY_ID = "Category.removeById";

    public static final String QUERY_FIND_ALL = "Category.findAll";

    public static final String QUERY_REMOVE_ALL = "Category.removeAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name_category")
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    private List<Ad> ads;

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(ArrayList<Ad> ads) {
        this.ads = ads;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Long getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
