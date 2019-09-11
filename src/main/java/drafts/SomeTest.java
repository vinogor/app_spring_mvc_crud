package drafts;

import java.io.IOException;
/*

// что выведется на экран?

public class SomeTest {

    public static void main(String[] args) {
        try {
            try {
                throw new Exception("a");
            } finally {
                if (true) {
                    throw new IOException("b");
                }
                System.err.println("c");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println("d");
            System.err.println(ex.getMessage());
        }
    }

}
*/

//--------------------------------------------------------------

// не изменяя методы - сделать чтобы перед "text" выводилось что-то ещё
class App {

    // ответ
//    static {
//        System.out.println("fswefwefserg");
//    }

    private static void printMessage() {
        System.out.println("text");
    }

    public static void main(String[] args) {
        printMessage();
    }

}