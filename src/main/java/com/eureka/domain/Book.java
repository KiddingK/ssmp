package com.eureka.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Eureka
 * @create 2022/8/31 13:53
 */
// 使用lombok注解，设置getter、setter方法,toString方法......
@Data
@TableName("tbl_book")
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
