package i.love.wsq;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jdk.nashorn.internal.runtime.options.Option;

/**
 * @author baitao05
 */
public class Main {
    public static void main(String[] args) {
        Team team = new Team();
        List<String> upperCaseList = Optional.ofNullable(team.getNameList()).orElseGet(ArrayList::new).stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> ruleList = new ArrayList<>();
        ruleList.add("123");
        String matchRule = Optional.ofNullable(ruleList).orElseGet(ArrayList::new).stream()
                .filter("rule"::equals)
                .findFirst().orElseGet(() -> {return null;});
    }

    public static Optional<String> getUser() {
//        return Optional.of("baitao05");
        return Optional.of(null);
    }
}

class Team {
    private List<String> nameList;

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
