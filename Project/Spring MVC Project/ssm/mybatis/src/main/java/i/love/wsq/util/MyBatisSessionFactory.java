package i.love.wsq.util;

import java.io.IOException;
import java.util.Objects;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author baitao05
 */
public class MyBatisSessionFactory {
    private static final String CONFIG_FILE = "mybatis/mybatis.cfg.xml"; // 配置文件
    private static SqlSessionFactory sessionFactory;
    private static final ThreadLocal<SqlSession> SESSION_THREAD_LOCAL = new ThreadLocal<>();

    static {
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSession() {
        SqlSession session = SESSION_THREAD_LOCAL.get();
        if (Objects.isNull(session)) {
            session = sessionFactory.openSession();
            SESSION_THREAD_LOCAL.set(session);
        }
        return session;
    }

    public static void close() {
        SqlSession session = SESSION_THREAD_LOCAL.get();
        if (Objects.nonNull(session)) {
            session.close();
            SESSION_THREAD_LOCAL.remove();
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
