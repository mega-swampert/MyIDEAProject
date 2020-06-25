package com.spring.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @Entity 是JPA注解配置映射关系，标记该类为JPA实体类 （和数据表映射的类）
 * @Table 指定相对应的数据表
 */
@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id//标记主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer id;

    @Column(name = "last_name", length = 50)//与数据表对应的一个列
    private String lastName;
    @Column()
    private String email;
}
