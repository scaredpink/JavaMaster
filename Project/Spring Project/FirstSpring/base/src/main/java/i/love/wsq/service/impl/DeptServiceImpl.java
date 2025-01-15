package i.love.wsq.service.impl;

import i.love.wsq.dao.IDeptDAO;
import i.love.wsq.service.IDeptService;
import i.love.wsq.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baitao05
 */
@Service    //业务层实现
public class DeptServiceImpl implements IDeptService {
    @Autowired  // 实例注入
    private IDeptDAO deptDAO;// 业务层需要注入数据层的实例
    @Override
    public Dept get(Long deptNo) {
        return this.deptDAO.findById(deptNo);
    }
}
