package i.love.wsq;

import i.love.wsq.domain.Book;
import i.love.wsq.util.MyBatisSessionFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.io.Resources;

public class TestBook {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBook.class);

    @Test
    public void testDoCreate() throws Exception {
        Book book = new Book("活着", "余华", 55.·55);
        LOGGER.info("doCreate {}", MyBatisSessionFactory.getSession().insert("i.love.wsq.BookNS.doCreate", book));
        InputStream input = Resources.getResourceAsStream("mybatis/mybatis.cfg.xml");
        SqlSession session = MyBatisSessionFactory.getSession();
        Book book = new Book("不存在的书");
        LOGGER.info("doCreate {}", session.insert("i.love.wsq.BookNS.doCreate", book));
        LOGGER.info("插入数据 {}", book);
        MyBatisSessionFactory.getSession().commit();
        MyBatisSessionFactory.close();
    }

    @Test
    public void testFindById() throws Exception {
        Long id = 1L;
        Book book = MyBatisSessionFactory.getSession().selectOne("i.love.wsq.BookNS.findById", id);
        LOGGER.info("findById {}", book);
        MyBatisSessionFactory.close();
    }

    @Test
    public void testFindAll() throws Exception {
        List<Book> bookList = MyBatisSessionFactory.getSession().selectList("i.love.wsq.BookNS.findAll");
        LOGGER.info("findById {}", bookList);
        MyBatisSessionFactory.close();
    }

    @Test
    public void testFindSplit() throws Exception {
        Map<String, Object> splitParams = new HashMap<>();
        splitParams.put("column", "name");
        splitParams.put("keyword", "%%");
        splitParams.put("start", 0);
        splitParams.put("lineSize", 2);
        List<Book> bookList = MyBatisSessionFactory.getSession().selectList("i.love.wsq.BookNS.findSplit", splitParams);
        LOGGER.info("findSplit {}", bookList);
        MyBatisSessionFactory.close();
    }

    @Test
    public void testGetAllCount() throws Exception {
        Map<String, Object> splitParams = new HashMap<>();
        splitParams.put("column", "name");
        splitParams.put("keyword", "%%");
        Long count = MyBatisSessionFactory.getSession().selectOne("i.love.wsq.BookNS.getAllCount", splitParams);
        LOGGER.info("findAllCount {}", count);
        MyBatisSessionFactory.getSession().close();
    }

    @Test
    public void testResultHandler() throws Exception {
        Map<Long, String> bookMap = new HashMap<>();
        MyBatisSessionFactory.getSession().select("i.love.wsq.BookNS.findAll", new ResultHandler() {
            @Override
            public void handleResult(ResultContext resultContext) {
                Book book = (Book) resultContext.getResultObject();
                bookMap.put(book.getBid(), book.getAuthor() + ": " + book.getName());
            }
        });
        LOGGER.info("ResultHandler: {}", bookMap);
    }

    @Test
    public void testFindByColumn() throws Exception {
        Book book = new Book();
        book.setName("红高粱");
        Book res = MyBatisSessionFactory.getSession().selectOne("i.love.wsq.BookNS.findByColumn", book);
        LOGGER.info("findByColumn {}", res);

        book = new Book();
        book.setBid(2L);
        res = MyBatisSessionFactory.getSession().selectOne("i.love.wsq.BookNS.findByColumn", book);
        LOGGER.info("findByColumn {}", res);
    }

    @Test
    public void testCache() throws Exception {
        // 第一次查询
        SqlSession sessionA = MyBatisSessionFactory.getSessionFactory().openSession();
        Book book1 = sessionA.selectOne("i.love.wsq.BookNS.findById", 1L);
        LOGGER.info("1st findById {}", book1);
        sessionA.close();
        // 第二次查询
        SqlSession sessionB = MyBatisSessionFactory.getSessionFactory().openSession();
        Book book2 = sessionB.selectOne("i.love.wsq.BookNS.findById", 1L);
        LOGGER.info("2nd findById {}", book2);
        MyBatisSessionFactory.close();
    }
}
