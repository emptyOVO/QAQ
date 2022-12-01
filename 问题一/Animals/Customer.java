package com.Animals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Customer {
    private String Cus_Name;    //顾客名字
    private Integer Num;        //到店次数
    private LocalDateTime date;     //最新到店时间
    private LocalDate date2;

    public String getCus_Name() {
        return Cus_Name;
    }

    public Integer getNum() {
        return Num;
    }
    public LocalDate getTime(){return date2;}

    public LocalDateTime getDate() {
        return date;
    }

    public Customer(String cus_Name, Integer num, LocalDateTime date) {
        Cus_Name = cus_Name;
        Num = num;
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("顾客名字：" + Cus_Name + "'")
                .add("到店次数：" + Num)
                .add("最新到点时间：" + date)
                .toString();
    }
}
