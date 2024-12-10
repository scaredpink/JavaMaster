/**
 * @author baitao05
 */
@Deprecated
public class Person {
    @Deprecated
    private String name;
    @Report("123")
    private Integer age;

    @Deprecated
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
