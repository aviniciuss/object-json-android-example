package br.com.jsonobjectexample;

import java.util.ArrayList;

public class Person {
    public String name;

    private ArrayList<Phone> phones = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person() {}

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public ArrayList<Phone> getPhones() {
        return  phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phones=" + phones+
                '}';
    }
}
