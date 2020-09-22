package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;



@Entity
@Table(schema = "public", name = "gift")
public class Gift implements Serializable {

    private long id;
    private String name;
    private Double width;
    private Double height;
    private Double weight;
    private Double price;
    private List<Box> boxes;

    public Gift(){}

    @Id
    @Column(name = "id", nullable = false)
    public long getId(){return id;}

    public void setId(long id){this.id = id;}

    @Column(name = "name", nullable = false)
    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    @Column(name = "width", nullable = false)
    public Double getWidth(){return width;}

    public void setWidth(Double width){this.width = width;}

    @Column(name = "height", nullable = false)
    public Double getHeight(){return height;}

    public void setHeight(Double height){this.height = height;}

    @Column(name = "weight", nullable = false)
    public Double getWeight(){return weight;}

    public void setWeight(Double weight){this.weight = weight;}

    public Double getPrice(){return price;}

    public void setPrice(Double price){this.price = price;}

    @OneToMany(mappedBy = "gift", cascade = CascadeType.ALL)
    public List<Box> getBoxes() {return boxes;}

    public void setBoxes(List<Box> boxes) {this.boxes = boxes;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return id == gift.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, width, height, weight, price, boxes);
    }
}
