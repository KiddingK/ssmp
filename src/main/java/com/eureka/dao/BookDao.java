package com.eureka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eureka.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eureka
 * @create 2022/8/31 14:07
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
