package io.ao9.winewiki.wine.jpa;

import javax.persistence.*;

@Entity
@Table(name = "wine")
public class WineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String imgUrl;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "grape_id")
    private GrapeEntity grape;
    private String description;

    public WineEntity() {
    }

    public WineEntity(String name, String imgUrl, GrapeEntity grape, String description) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.grape = grape;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public GrapeEntity getGrape() {
        return grape;
    }

    public void setGrape(GrapeEntity grape) {
        this.grape = grape;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WineEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", grape=" + grape +
                ", description='" + description + '\'' +
                '}';
    }
}