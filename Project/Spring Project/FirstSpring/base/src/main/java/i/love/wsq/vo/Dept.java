package i.love.wsq.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author baitao05
 */
public class Dept {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dept.class);
    private Long deptNo;
    private String deptName;
    private String loc;

    public Dept() {
        LOGGER.info("[构造方法]Dept");
    }

    @Override
    public String toString() {
        return "[部门消息]" + super.hashCode() + " 编号: " + this.deptNo + " 名称: " + this.deptName + " 位置: " + this.loc;
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        LOGGER.info("[setter方法]Dept");
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        LOGGER.info("[setter方法]Dept");

        this.loc = loc;
    }
}
