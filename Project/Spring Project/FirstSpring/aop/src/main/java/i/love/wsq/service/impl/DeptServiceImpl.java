package i.love.wsq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import i.love.wsq.service.IDeptService;
import i.love.wsq.vo.Dept;

/**
 * @author baitao05
 */
public class DeptServiceImpl implements IDeptService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeptServiceImpl.class);
    // 此时需要注入DAO接口实例，才可以实现数据层代码的开发处理
    @Override
    public boolean add(Dept dept) {
        // 手工开启事务
        LOGGER.info("[部门增加]部门编号: {}、部门名称: {}、部门位置: {}", dept.getDeptNo(), dept.getdName(), dept.getLoc());
        return true;
        // 手工提交事务
    }
}
