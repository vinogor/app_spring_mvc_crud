package drafts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityMob {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("prefixqweQWE");
        list.add("qwe123");

        List<String> result = convert(list, "prefix");

        System.out.println(result);
    }

    private static List<String> convert(List<String> list, String prefix) {
//        return list.stream().map(x -> (prefix + x)).collect(Collectors.toList()); //просто прибавляет
//        return list.stream().filter(x -> x.contains(prefix)).collect(Collectors.toList());

        return list
            .stream()
            .parallel()
            .filter(x -> ((x.length()>= prefix.length()) && (x.substring(0, prefix.length()).equals(prefix))))
            .collect(Collectors.toList());
    }
}