package com.calpis.interview.base.entity;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/13 18:44
 */
public class Hello {

    private String name;

    private Integer age;

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

    @Override
    public boolean equals(Object o) {
        Hello hello = (Hello) o;
        return hello.getAge().equals(getAge())
                && hello.getName().equals(getName());
    }

}
