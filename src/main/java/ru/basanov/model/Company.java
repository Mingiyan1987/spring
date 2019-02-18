package ru.basanov.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appCompany")
public class Company{

    public static final String QUERY_GET_BY_ID = "Company.getById";

    public static final String QUERY_REMOVE_BY_ID = "Company.removeById";

    public static final String QUERY_FIND_ALL = "Company.findAll";

    public static final String QUERY_REMOVE_ALL = "Company.removeAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name_company")
    private String nameCompany;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Ad> ads;

    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAds(ArrayList<Ad> ads) {
        this.ads = ads;
    }
}
