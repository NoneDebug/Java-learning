package com.tybxx.Chap8.Homework01;

public class Homework01 {
    public static void main(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person("Tom", 12, "Student");
        person[1] = new Person("Tim", 36, "Manager");
        person[2] = new Person("Jack", 27, "Boss");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
        bubbleSortPerson(person);
        System.out.println("After sorting");
        System.out.println("=================");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
    }
    public static void bubbleSortPerson(Person[] persons){
        for (int i = 0; i < persons.length- 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++){
                if(persons[j + 1].getAge() < persons[j].getAge()){
                    Person tempPerson = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = tempPerson;
                }
            }
        }
    }
}
