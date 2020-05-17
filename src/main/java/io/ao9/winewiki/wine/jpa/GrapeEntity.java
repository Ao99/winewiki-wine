package io.ao9.winewiki.wine.jpa;

import javax.persistence.*;

@Entity
@Table(name = "grape")
public class GrapeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String name;
    boolean isRed;

    public GrapeEntity() {
    }

    public GrapeEntity(String name, boolean isRed) {
        this.name = name;
        this.isRed = isRed;
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

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    @Override
    public String toString() {
        return "GrapeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isRed=" + isRed +
                '}';
    }
}
