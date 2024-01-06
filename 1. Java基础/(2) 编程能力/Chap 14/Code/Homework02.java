package com.tybxx.Homework;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(car);
        arrayList.add(car2);
        arrayList.add(car2);
        showArray1(arrayList);


        arrayList.remove(car2);
        showArray2(arrayList);

        arrayList.add(car);
        System.out.println("宾利是否存在？" + arrayList.contains(car2));
        System.out.println("元素个数：" + arrayList.size());

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(car);
        showArray3(arrayList1);
        System.out.println("是否包含arrayList1的元素？" + arrayList.containsAll(arrayList1));

        arrayList.removeAll(arrayList1);
        showArray1(arrayList);

        System.out.println("列表为空？" + arrayList.isEmpty());
        arrayList.clear();
        System.out.println("列表为空？" + arrayList.isEmpty());
    }
    public static void showArray1(ArrayList list){
        System.out.println("====方法1 迭代器====");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
    public static void showArray2(ArrayList list){
        System.out.println("====方法2 增强for====");
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void showArray3(ArrayList list){
        System.out.println("====方法3 普通for====");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

@SuppressWarnings({"all"})
class Car{
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
