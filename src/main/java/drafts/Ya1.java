package drafts;

import java.util.*;

public class Ya1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String nums = scanner.nextLine();
        
        long[] numArr = Arrays
            .stream(nums.split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

        long result = Arrays.stream(numArr).distinct().reduce(Long::sum).getAsLong();

        System.out.println(result);

    }
}
