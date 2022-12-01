package com.Animals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop {
    private double money;
    private double get = 0;
    private double set = 0;
    private ArrayList<Animal> list;
    private ArrayList<Customer> customers;
    private boolean flag;

    @Override
    public void Buy() {

        System.out.println("买猫请输入1，买中华田园犬请输入2");
        Scanner sc = new Scanner(System.in);
        String index = sc.next();
//        String index = "1";
        Animal animal = null;
        if ("1".equals(index)) {
            System.out.println("请输入猫的姓名：");
            String name = sc.next();
//            String name = "波斯猫";
            System.out.println("请输入猫的年龄：");
            Integer age = sc.nextInt();
//            Integer age = 1;
            System.out.println("请输入猫的性别：");
            Character sex = sc.next().charAt(0);
//            Character sex = '女';
            System.out.println("请输入猫的价格：");
            Double price = sc.nextDouble();
//            Double price = 999.0;
            animal = new Cat(name, age, sex, price);
            System.out.println(animal);
        } else if ("2".equals(index)) {
            System.out.println("请输入狗的姓名：");
            String name = sc.next();
            System.out.println("请输入狗的年龄：");
            Integer age = sc.nextInt();
            System.out.println("请输入狗的性别：");
            Character sex = sc.next().charAt(0);
            System.out.println("请输入狗的价格：");
            Double price = sc.nextDouble();
            animal = new China_Dog(name, age, sex, price);
        } else {
            System.out.println("输入错误");
            return;
        }


        if (animal.Price > this.money) {
            System.out.println(money);
            try {
                throw new InsufficientBalanceException("余额不足！");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.money += get;
            this.money -= animal.Price;
            this.set += animal.Price;
            list.add(animal);
            System.out.println(list);
        }

    }

    @Override
    public void Service(Customer customer) {
        Double price = 0.0;
        if (!DaYang(customer.getDate())) return;
        customers.add(customer);
        System.out.println("卖猫请输入1，卖中华田园犬请输入2");
        Scanner sc = new Scanner(System.in);
        String index = sc.next();
        Animal animal = null;
        if ("1".equals(index)) {
            System.out.println("请输入猫的姓名：");
            String name = sc.next();
            System.out.println("请输入猫的年龄：");
            Integer age = sc.nextInt();
            System.out.println("请输入猫的性别：");
            Character sex = sc.next().charAt(0);
            System.out.println("请输入猫的出售价格：");
            price = sc.nextDouble();
            animal = new Cat(name, age, sex);
        } else if ("2".equals(index)) {
            System.out.println("请输入狗的姓名：");
            String name = sc.next();
            System.out.println("请输入狗的年龄：");
            Integer age = sc.nextInt();
            System.out.println("请输入狗的性别：");
            Character sex = sc.next().charAt(0);
            System.out.println("请输入狗的出售价格：");
            price = sc.nextDouble();
            animal = new China_Dog(name, age, sex);
        } else {
            System.out.println("输入错误");
            return;
        }
        sell(animal, price);
    }

    @Override
    public boolean DaYang(LocalDateTime localDateTime) {
        flag = true;
        int hour = localDateTime.getHour();
        System.out.println(hour);
        if (hour >= 22 || hour <= 8) {
            System.out.println("已打烊");
            System.out.println(customers);
            System.out.println("今天的收入是：" + (get - set));
            flag = false;
        }
        return flag;
    }


    public void sell(Animal animal, double price) {
        System.out.println(animal);
        for (Animal animal1 : list) {
            System.out.println(animal1);
            if (animal1.equals(animal)) {
                get += price;
                list.remove(animal);
                System.out.println("出售成功");
                animal.toString();
                return;
            }
        }
        try {
            throw new AnimalNotFoundException("没找到此动物");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public MyAnimalShop(double money, ArrayList<Animal> list, ArrayList<Customer> customers) {
        this.money = money;
        this.list = list;
        this.customers = customers;
    }
   
    public String DaKaXiaBan(){
       return  "已歇业" + "\t" + "光顾过的所有顾客信息是 "+"\t"+customers + "\t" + "收入是：" + (get - set);
    }

    //TODO：以下是写的XieYe方法，有问题待完善，详情见Main类里的TODO注释

/*
    public void XieYe(int year, Month month, int day) {
        LocalDate Stop = LocalDate.of(year,month,day);
        for(Customer customers :customers){
            if(customers.getTime().isEqual(Stop)){
                System.out.println("今天的顾客裂变如下：+"customers);
            }
        }
        System.out.println( "已歇业" + "\t" + "这天的收入是：" + (get - set));
    }

    public void XieYe() {
    }

 */




}

