package com.spring.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.swing.text.html.ObjectView;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的属性值，映射到组件
 *
 * @ConfigurationProperties 配置文件中的值绑定到对象
 * <p>
 * 只有这个组件是容器中的组件，才能容器提供 @ConfigurationProperties功能
 */
@PropertySource(value = {"classpath:person.properties"})//加载指定配置文件
@Component
@ConfigurationProperties(prefix = "person")//是从全局配置文件中获取值
//@Validated
public class Person {
    /**
     * <bean class="Person">
     * <property name ="LastName" value="字面量/
     * ${key}从配置文件中获取值/
     * #{SpEl}spring表达式"></property>
     * </bean>
     */
//    @Value("${person.last-name}")
    public String lastName;
    //    @Value("#{11*2}")
    private Integer age;
    //    @Value("true")
    private Boolean boss;
    private Date birth;
    //    @Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
