package th.ac.ku.carsinfo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CarsInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;

    private String desc;

    private String carsType;

    private Date saletDate;

    private Date saleTimes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String name) {
        this.brand = brand;
    }

    public String getdesc() {
        return desc;
    }

    public void setdesc(String desc) {
        this.desc = desc;
    }

    public String getCarsType() {
        return carsType;
    }

    public void setCarsType(String carsType) {
        this.carsType = carsType;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = starsaleDatetDate;
    }

    public Date getSaleTimes() {
        return saleTimes;
    }

    public void setSaleTimes(Date saleTimes) {
        this.saleTimes = saleTimes;
    }

}
