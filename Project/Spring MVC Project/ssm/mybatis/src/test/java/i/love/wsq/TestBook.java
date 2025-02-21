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
        Book book = new Book("红高粱", "莫言", 66.66);
        LOGGER.info("doCreate {}", session.insert("i.love.wsq.BookNS.doCreate", book));
        LOGGER.info("插入数据 {}", book);
        session.commit();
        session.close();
        input.close();
    }
}
