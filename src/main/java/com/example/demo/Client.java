package com.example.demo;

import javax.management.InstanceNotFoundException;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "clients")
@Entity
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "payday")
    private LocalDate payday;

    @Column(name = "lastday")
    private LocalDate lastday;

    @Column(name = "count")
    private Integer count;

    @Column(name = "frequency")
    private LocalDate[] frequency;

    @Override
    public String toString() {

        String result = name + "\n"
                + "From: " + payday.format(DateTimeFormatter.ofPattern("dd.MM.yy")) + "\n"
                + "To: " + lastday.format(DateTimeFormatter.ofPattern("dd.MM.yy")) + "\n"
                + "Count: " + count + "\n";
        if(phone != null && !phone.isEmpty())
            result += "Phone: " + phone;

        return result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDate getLastday() {
        return lastday;
    }

    public void setLastday(LocalDate lastday) {
        this.lastday = lastday;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}