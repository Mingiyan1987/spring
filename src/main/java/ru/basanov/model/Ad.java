package ru.basanov.model;

import javax.persistence.*;

@Entity
@Table(name = "appAd")
public class Ad extends AbstractEntity{

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

    @Override
    public <T> T getEntity(TypedQuery<T> query) {
        return super.getEntity(query);
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
