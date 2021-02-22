package com.calpis.interview.jdk.clone;

/**
 * @author Zhujialiang
 * @version V1.0
 * @Description
 * @Date 2021/2/20 18:14
 * @Copyright Copyright © 2020 深圳花儿绽放网络科技股份有限公司. All rights reserved.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("蔡徐坤", 23, new Address("校队", "美国"));
        User clone = (User) user.clone();
        System.out.println(user.equals(clone));
        System.out.println(user.getAddress().equals(clone.getAddress()));

        clone = new User(user.getName(), user.getAge(), new Address(user.getAddress().getCity(), user.getAddress().getProvince()));
        System.out.println(user.equals(clone));
        System.out.println(user.getAddress().equals(clone.getAddress()));
    }

    static class User implements Cloneable {
        private String name;
        private Integer age;
        private Address address;

        public User(String name, Integer age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User user = (User) super.clone();
            user.setAddress((Address) this.address.clone());
            return user;
        }
    }

    static class Address implements Cloneable {
        private String city;
        private String province;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public Address(String city, String province) {
            this.city = city;
            this.province = province;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
