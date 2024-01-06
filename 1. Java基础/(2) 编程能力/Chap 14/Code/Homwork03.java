package com.tybxx.Homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        showMap(m);

        m.put("jack",2600);
        showMap(m);

        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            int value = (int) m.get(obj);
            m.put(obj, value + 100);
        }

        it = m.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
        System.out.println("===========");

        showMap(m);

    }
    public static void showMap(Map m){
        Iterator it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entries = (Map.Entry) it.next();
            System.out.println(entries.getKey() + "-" + entries.getValue());
        }
        System.out.println("===========");
    }

}
