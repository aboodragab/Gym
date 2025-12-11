
package com.gym.model;

public class Person {
    private int personId;
    private int age;
    private String name;
    private String phone;
    private String address;

    public Person(int personId, int age, String name, String phone, String address) {
        this.personId = personId;
        this.age = age;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
