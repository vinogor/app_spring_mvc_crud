package drafts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ya2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strs = scanner.nextLine();

        char[] chars = strs.toCharArray();
        int numOfLetters = 0;
        List<Integer> numbers1 = new ArrayList<>();
        int index = -1;
        
        boolean flag = false;
    
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                numOfLetters++;
                flag = false;
            } else {
            
                if (!flag) {
                    index++;
                    numbers1.add(index, Integer.parseInt(String.valueOf(aChar)));
                    flag = true;
                } else {
                    numbers1.set(index, numbers1.get(index) * 10 + Integer.parseInt(String.valueOf(aChar)));
                }
            }
        }
    
        int sum = (int) numbers1.stream().mapToDouble(a -> a).sum();
        int result = sum + numOfLetters - numbers1.size();
        System.out.println(result);
    
    }
}

