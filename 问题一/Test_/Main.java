
package Test_;

import com.Animals.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入宠物店的余额");
      //  double moneys = 10000;
        double moneys = sc.nextDouble();
        ArrayList<Customer> customers = new ArrayList<>();
        //创建动物泛型
        ArrayList<Animal> animals = new ArrayList<>();
        Animal Dog = new China_Dog("中华田园犬", 1, '男', 100.00);
        Animal Cat = new Cat("猫猫", 1, '女', 200.00);
        animals.add(Dog);
        animals.add(Cat);
        //创建客户泛型
        MyAnimalShop myAnimalShop = new MyAnimalShop(moneys, animals, customers);
        boolean flag = true;
        while (flag) {
            System.out.println("================飞哥宠物店管理系统================");
            System.out.println("本店营业时间：8:00~22:00（非此时段以外一律不可打卡下班）");
            System.out.println("输入1:买动物===输入2:卖动物===输入3:查看店内动物列表===输入4:打卡下班===输入5:退出系统===6:歇业");
            int i = sc.nextInt();
            switch (i) {
                case 1: {
                    myAnimalShop.Buy();
                }
                break;
                case 2: {
                    System.out.println("请输入顾客的信息:");
                    System.out.println("请输入顾客的姓名");
                   String name = sc.next();
              //    String name = "Celia";
                    System.out.println("请输入顾客到店的次数");
                    int num = sc.nextInt();
                //    int num = 0;
                    System.out.println("请输入顾客到店的时间(yyyy:MM:dd:hh:mm)");
                    String time = sc.next();
                    String[] s = time.split(":");
                    LocalDateTime localDateTime = LocalDateTime.of(zh(s[0]), zh(s[1]), zh(s[2]), zh(s[3]), zh(s[4]));
                    Customer customer = new Customer(name, num, localDateTime);
                    myAnimalShop.Service(customer);
                    System.out.println(flag);
                }
                break;

                case 4:{
                    System.out.println("请输入打卡下班时间:（yyyy:MM:dd:hh:mm）");
                    String time = sc.next();
                    String[] s = time.split(":");
                    LocalDateTime localDateTime2 = LocalDateTime.of(zh(s[0]), zh(s[1]), zh(s[2]), zh(s[3]), zh(s[4]));
                    int hour = localDateTime2.getHour();
                    //    int date2 = localDateTime2.getDayOfMonth();
                    if(hour >= 22 || hour <= 8) {
                        myAnimalShop.DaKaXiaBan();
                        System.out.println(myAnimalShop.DaKaXiaBan());
                    }
                    else System.out.println("未到下班时间");
                    break;
                }
                case 5:
                { flag = false;
                    break;}

                //TODO :（未完成部分已被注释）
                // 之前误解了歇业方法（我自己现在更改成了现在代码中的打卡下班方法），当时以为是按照时间来判断，比如8-22点营业那么剩余时间下班就是歇业，
                // 然后导致我使用的时LocalDateTime判断，最后写出来的方法输出客户信息时没有判断当天的客户来输出,而是把所有光临的客户都输出了，
                // 我的想法是写一个case：6，接收字符串提取里面的年月日，在MyAnimalShop里面写一个XieYe方法，增强for遍历之前的customers,
                // 然后判断如果顾客信息中日期是否与接收的年月日相符合，相符的就输出，然后再用对应的get-set来计算当天收入。
                // 目前已经写好了基本的方法主体，但是存在一些问题使我的方法会出现报错，目前不知道怎么解决
                // Exception in thread "main" java.lang.NullPointerException
                //	at com.Animals.MyAnimalShop.XieYe(MyAnimalShop.java:160)
                //	at Test_.Main.main(Main.java:94)
                //	目前看来是isEqual那条语句写错了，判断不出来相符
                //	因为发现的时间有点晚了，时间有些紧张实在来不及修改QAQ

                    /*
                case 6:
                {
                    System.out.println("请输入歇业时间:（yyyy:MM:dd）");
                    String time = sc.next();
                    String[] s2 = time.split(":");
                    LocalDate localDate = LocalDate.of(vh(s2[0]), vh(s2[1]), vh(s2[2]));
                    int year = localDate.getYear();
                    Month month = localDate.getMonth();
                    int day = localDate.getDayOfMonth();
                    myAnimalShop.XieYe(year,month,day);
                }

                     */



                case 3:
                {
                    System.out.println(animals);
                }
            }
            if (i<=1||i>=7)
                System.out.println("输入无效，请重新输入");
        }
    }

    public static int zh(String s) {
        return Integer.valueOf(s);
    }

    /*
    public static int vh(String s2) {
        return Integer.valueOf(s2);
    }

     */


}







