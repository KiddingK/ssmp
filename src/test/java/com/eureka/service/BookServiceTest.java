package com.eureka.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eureka.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Eureka
 * @create 2022/8/31 20:21
 */
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.list());
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("添加数据2");
        book.setName("添加数据2");
        book.setDescription("添加数据2");
        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setType("修改数据2");
        book.setName("修改数据2");
        book.setDescription("修改数据2");
        System.out.println(bookService.updateById(book));
    }

    @Test
    void testDelete(){
        System.out.println(bookService.removeById(4));
    }

    @Test
    void testGetPage(){
        IPage iPage = new Page(2,3);
        IPage page = bookService.page(iPage, null);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }


}
