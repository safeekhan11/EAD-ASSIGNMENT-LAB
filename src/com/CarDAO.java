package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "carBean")
@SessionScoped
public class CarDAO {


    public int car_id;
    private List<Car> cars;
    private final DbConnection conn = new DbConnection();

    public CarDAO() {
        cars = conn.getCars();
    }

    public List<Car> getCar() {
        return cars;
    }

    public void setCar(List<Car> car) {
        this.cars = car;
    }

    public String bookcar(int uid,int cid) {
            conn.bookcar1(uid,cid);
            return "booked.xhtml";

    }

}
