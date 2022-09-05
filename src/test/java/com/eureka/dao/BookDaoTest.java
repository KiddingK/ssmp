package com.eureka.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eureka.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Eureka
 * @create 2022/8/31 14:09
 */
@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    void testSelectById(){
        bookDao.selectById(1);
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(1);
        book.setType("测试数据1");
        book.setName("测试数据1");
        book.setDescription("测试数据1");
        bookDao.updateById(book);
    }
    @Test
    void testDelete(){
        bookDao.deleteById(1);
    }
    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }
    @Test
    void testGetPage(){
        IPage page = new Page(2,3);
        bookDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }
    @Test
    void testGetBy(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "测试");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetByCondition(){
        String name = "";
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(name), Book::getName, name);
        bookDao.selectList(queryWrapper);
    }
}
