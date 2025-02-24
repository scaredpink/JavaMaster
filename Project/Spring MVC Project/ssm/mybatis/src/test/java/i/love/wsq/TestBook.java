package i.love.wsq;

import i.love.wsq.domain.Book;
import i.love.wsq.util.MyBatisSessionFactory;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.io.Resources;

/**
 * @author baitao05
 */
public class TestBook {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBook.class);

    @Test
    public void testDoCreate() throws Exception {
        InputStream input = Resources.getResourceAsStream("mybatis/mybatis.cfg.xml");
        SqlSession session = MyBatisSessionFactory.getSession();
        Book book = new Book("不存在的书");
        LOGGER.info("doCreate {}", session.insert("i.love.wsq.BookNS.doCreate", book));
        LOGGER.info("插入数据 {}", book);
        session.commit();
        session.close();
        input.close();
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
