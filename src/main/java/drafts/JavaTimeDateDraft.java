package drafts;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class JavaTimeDateDraft {
    public static void main(String[] args) {

        ZoneId operatorZone = ZoneId.of("+6");
        ZoneId clientZone = ZoneId.of("+4");

//        ZonedDateTime clientZonedDateTime = ZonedDateTime.of(
//            2019, 2, 10,
//            16, 15, 3, 333,
//            clientZone);

        Date clientDate = new Date(
            2019 - 1900, Calendar.JUNE, 10,
            17 - 1, 15, 3);


        // переводим старый Date в модный ZonedDateTime с учётом пояса
        ZonedDateTime clientZonedDateTime = clientDate.toInstant().atZone(clientZone);


        System.out.println("operatorZone: " + operatorZone);
        System.out.println("clientZonedDateTime: " + clientZonedDateTime);
        System.out.println();

        // получаем местное время оператора
        LocalDateTime operatorLocalDateTime = clientZonedDateTime.withZoneSameInstant(operatorZone).toLocalDateTime();

        DayOfWeek dayOfWeek = operatorLocalDateTime.getDayOfWeek();
        int hour = operatorLocalDateTime.getHour();

        System.out.println("operatorLocalDateTime: " + operatorLocalDateTime);
        System.out.println(dayOfWeek);
        System.out.println(hour);
    }
}
