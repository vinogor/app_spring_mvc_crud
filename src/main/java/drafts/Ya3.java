package drafts;

import java.util.Arrays;
import java.util.Scanner;

public class Ya3 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String nums = scanner.nextLine();
        
        long[] numArr = Arrays
            .stream(nums.split(" "))
            .mapToLong(Long::parseLong)
            .toArray();
        
        boolean[] multiplicity = new boolean[length];
        
        for (int i = 0; i < length; i++) {
            if (numArr[i] % 2 != 0) {
                multiplicity[i] = true;
            }
        }
        
        int result = 0;
        
        for (int i = 1; i < length; i++) {
            if (multiplicity[i - 1] == multiplicity[i]) {
                int swap = findAndReplace(i, length, multiplicity, numArr);
                if (swap == 0) {
                    result = -1;
                    break;
                }
                result += swap;
            }
        }
        
        
        System.out.println(result);
        if (result != -1) {
            for (int i = 0; i < length; i++) {
                System.out.print(numArr[i] + " ");
            }
        }
        
    }
    
    private static int findAndReplace(int i, int length, boolean[] multiplicity, long[] numArr) {
        for (int j = i + 1; j < length; j++) {
            if (multiplicity[i] != multiplicity[j]) {
                boolean tmp = multiplicity[j];
                multiplicity[j] = multiplicity[i];
                multiplicity[i] = tmp;
                
                long tmpL = numArr[j];
                numArr[j] = numArr[i];
                numArr[i] = tmpL;
                return 1;
            }
        }
        return 0;
    }
}
