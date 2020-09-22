package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema= "public", name= "box")
public class Box {
    private long id;
    private String address;
    private Gift gift;

    public Box(){}

    @Id
    @Column(name = "id", nullable = false)
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    @Column(name = "address", nullable = false)
    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "gift_id")
    public Gift getGift() { return gift; }

    public void setGift(Gift gift) { this.gift = gift; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return id == box.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, gift);
    }

}
