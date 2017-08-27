package br.com.jsonobjectexample;

public class Phone {

    public String phone;

    public Phone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
