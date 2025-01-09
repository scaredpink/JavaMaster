package i.love.wsq.vo;

/**
 * @author baitao05
 */
public class Emp {
    private Long empNo;
    private String eName;
    private Dept dept;

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "【雇员信息 - " + super.hashCode() + "】编号：" + this.empNo + "、姓名：" + this.eName;
    }
}