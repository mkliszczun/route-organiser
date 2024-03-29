package entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_entity")
public class Order implements TableListable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "order_num")
    private String orderNum;
    @Column(name = "customer")
    private String customer;
    @Column(name = "phone_number")
    private String phonNum;
    @Column(name = "delivery_time")
    private String deliveryTime;
    @Column(name = "adress")
    private String adres;
    @Column(name = "nip")
    private String nip;
    @Column(name = "add_info")
    private String addInfo;
    @Column(name = "route_id")
    private int routeId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Steel> steelList;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Bar> barList;


    public Order(){
        this.steelList = new ArrayList<>();
        this.barList = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhonNum() {
        return phonNum;
    }

    public void setPhonNum(String phoneNum) {
        this.phonNum = phoneNum;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public List<Steel> getSteelList() {
        return steelList;
    }

    public void setSteelList(List<Steel> steelList) {
        this.steelList = steelList;
    }

    public List<Bar> getBarList() {
        return barList;
    }

    public void setBarList(List<Bar> barList) {
        this.barList = barList;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString(){
        return orderNum + " " + adres;

    }
}
