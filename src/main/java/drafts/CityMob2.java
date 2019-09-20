package drafts;
// Вам дан набор слов. Набор слов заранее подготовлен в структуре данных на ваш выбор
// и способом на ваш выбор. Предполагаем, что набор слов стабильный и меняется крайне редко.
// Надо написать функцию, которая принимает в качестве аргументов префикс и вышеуказанную
// структуру данных и возвращает все слова из вышеуказанного набора, начинающиеся с этого префикса.
// Язык программирования на ваш выбор.


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityMob2 {
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
        return list.stream().filter(x -> ((x.length()>= prefix.length()) && (x.substring(0, prefix.length()).equals(prefix)))).collect(Collectors.toList());
    }
}
