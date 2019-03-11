package com.lnsoft.swidpdhclast.testlitepal;

import org.litepal.crud.LitePalSupport;

/**
 * des：
 * author：onexzgj
 * time：2019/3/7
 */
public class Student extends LitePalSupport {

    private String name;
    private String age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
