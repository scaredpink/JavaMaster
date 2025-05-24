package i.loved.wsq;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author baitao05
 */
public class RegexDemo {
    public static void main(String[] args) {
        String branchRegex = "^(bugfix|feature|hotfix|test|dev)/[A-Za-z0-9\\-]+?-[0-9]+?/[A-Za-z0-9\\.\\-\\/\\_]*";
        String branch = "dev/unittest-20250502/baitao05";
        if (branch.matches(branchRegex)) {
            System.out.println("符合规范");
        } else {
            System.out.println("不符合规范");
        }

    }
}
