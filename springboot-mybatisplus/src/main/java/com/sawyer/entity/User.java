package com.sawyer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value = "t_user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    @TableField(value = "username")
    private String name;
    private Integer age;
    private Date bir;

    @TableField(exist = false)//不映射数据库
    private String aaa;
}
