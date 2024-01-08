package Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>(new HashMap<String, User>());
        userDAO.save("2006", new User(22, 6, "唐钰渤primay"));
        userDAO.save("2012", new User(3, 12, "唐钰渤junior"));
        userDAO.save("2015", new User(17, 15, "唐钰渤sunior"));
        userDAO.save("2018", new User(26, 18, "唐钰渤college"));
        userDAO.save("2022", new User(61, 22, "唐钰渤postgraduate"));
        System.out.println(userDAO);

        System.out.println("=============");

        System.out.println(userDAO.get("2022"));

        System.out.println("=============");
        userDAO.update("2006", new User(8, 6, "唐钰渤primary"));
        System.out.println(userDAO);


        System.out.println("=============");
        List list = userDAO.list();
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("=============");
        userDAO.delete("2015");
        System.out.println(userDAO);
    }
}


@SuppressWarnings({"all"})
class DAO<T>{

    //泛型类
    private Map<String, T> map;

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    //使用泛型的函数
    public void save(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id, entity);
    }
    public List<T> list(){
        List<T> ts = new ArrayList<>();
        for (T o : map.values()) {
            ts.add(o);
        }
        return ts;
    }
    public void delete(String id){
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
@SuppressWarnings({"all"})
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
