
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) {
		Person ming = new Person();
		ming.setName("小明");
		System.out.println(ming.getName());

		// FIXME: 给Person增加getAge/setAge方法:
		Age n = new Age();
		n.setNum(15);
		ming.setAge(n);
		System.out.println(ming.getAge().getNum());
		n.setNum(20);
		System.out.println(ming.getAge().getNum());
	}
}
