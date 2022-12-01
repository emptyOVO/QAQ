package dan.dan2;

import java.util.Scanner;

public class fun {
    public static void main(String[] args) {
       fun1();
        fun2();
    }
    public static  void fun1(){
        Object o=new Object();
        int[] arr1;
        int[] arr2;
        arr1 = new int[]{1, 3, 5, 7, 9};
        arr2 = new int[]{2, 4, 6, 8, 10};
        Mythread mythread1=new Mythread(arr1,o);
        Mythread mythread2=new Mythread(arr2,o);
        Thread thread1=new Thread(mythread1);
        Thread thread2=new Thread(mythread2);
        thread1.start();
        thread2.start();
    }
    static boolean fun2(){
        boolean flag=true;
        Scanner myscanner = new Scanner(System.in);
              String email=myscanner.nextLine();
              String str="^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
        boolean matches = email.matches(str);
        System.out.println(matches);
        return flag;
    }
}
