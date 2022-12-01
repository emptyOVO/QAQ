package com.Animals;


import java.time.LocalDateTime;
import java.time.Month;

public interface AnimalShop {
public void Buy();
public void Service(Customer customer);
public boolean DaYang(LocalDateTime localDateTime);
    public String DaKaXiaBan();

    //TODO：XieYe方法会报错有待完善

/*
    public void XieYe(int year, Month month, int day);
*/


}
