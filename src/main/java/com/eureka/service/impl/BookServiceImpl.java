package com.eureka.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eureka.dao.BookDao;
import com.eureka.domain.Book;
import com.eureka.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;


/**
 * @author Eureka
 * @create 2022/8/31 20:18
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService {
    @Override
    public IPage<Book> getPage(Integer page, Integer size) {
        return baseMapper.selectPage(new Page(page, size), null);
    }

    @Override
    public IPage<Book> getPage(Integer page, Integer size, Book book) {
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        queryWrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        queryWrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        return baseMapper.selectPage(new Page(page, size),queryWrapper);
    }
}
