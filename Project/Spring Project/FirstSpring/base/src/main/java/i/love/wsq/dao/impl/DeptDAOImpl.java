package i.love.wsq.dao.impl;

import i.love.wsq.dao.IDeptDAO;
import i.love.wsq.vo.Dept;
import org.springframework.stereotype.Repository;

/**
 * @author baitao05
 */
@Repository // 数据层的注解
public class DeptDAOImpl implements IDeptDAO {
    @Override
    public Dept findById(Long deptNo) {
        // 手写模拟，等之后学到数据库开发再说
        Dept dept = new Dept();
        dept.setDeptNo(deptNo);
        dept.setDeptName("战略投资部");
        dept.setLoc("庇尔波因特");
        return dept;
    }
}
