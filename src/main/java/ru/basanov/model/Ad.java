package ru.basanov.model;

import javax.persistence.*;

@Entity
@Table(name = "appAd")
@NamedQueries({
        @NamedQuery(name = Ad.QUERY_GET_BY_ID, query = "SELECT e FROM Ad e WHERE e.id = :id"),
        @NamedQuery(name = Ad.QUERY_REMOVE_BY_ID, query = "DELETE FROM Ad e WHERE e.id = :id"),
        @NamedQuery(name = Ad.QUERY_FIND_ALL, query = "SELECT e FROM Ad e"),
        @NamedQuery(name = Ad.QUERY_REMOVE_ALL, query = "DELETE FROM Ad e")
})
public class Ad {

    public static final String QUERY_GET_BY_ID = "Ad.getById";

    public static final String QUERY_REMOVE_BY_ID = "Ad.removeById";

    public static final String QUERY_FIND_ALL = "Ad.findAll";

    public static final String QUERY_REMOVE_ALL = "Ad.removeAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // связь с категорией

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company; // связь с компанией

    @Column(name = "content")
    private String content;

    public Ad() {
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Company getCompany() {
        return company;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
