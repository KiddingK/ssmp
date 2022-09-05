package com.eureka.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eureka.domain.Book;


/**
 * @author Eureka
 * @create 2022/8/31 20:16
 */
public interface BookService extends IService<Book> {
    IPage<Book> getPage(Integer page, Integer size);

    IPage<Book> getPage(Integer page, Integer size, Book book);
}
