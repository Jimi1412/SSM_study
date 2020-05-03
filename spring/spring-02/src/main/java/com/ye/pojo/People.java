package com.ye.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;


public class People {
//    @Autowired
//    @Qualifier(value = "cat1")  //当bean中有两个改属性的bean时，用该注解与@Autowired配合指定是哪个bean
    @Resource(name = "cat1")
    Cat cat;
    @Autowired
    Dog dog;
    String name;

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }

    public Cat getCat() {
        return cat;
    }

  /*  public void setCat(Cat cat) { this.cat = cat; }*/

    public Dog getDog() {
        return dog;
    }

   /* public void setDog(Dog dog) { this.dog = dog; }*/

    public String getName() {
        return name;
    }

   public void setName(String name) { this.name = name; }
}
