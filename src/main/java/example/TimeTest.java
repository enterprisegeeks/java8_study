package example;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 *
 * @author kentaro.maeda
 */
public class TimeTest {
    public static void main(String[] args) {
        
        LocalDateTime may = LocalDateTime.of(2014, 5, 8, 13, 0, 0);
        LocalDateTime calcDate = may.minusMonths(1).plus(Period.ofYears(2));
        System.out.println(calcDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
        
        Chronology jp = Chronology.of("Japanese");
        ChronoLocalDate wareki = jp.date(may);
        System.out.printf("%d年は%s %d年\n",wareki.get(ChronoField.YEAR), wareki.getEra(),wareki.get(ChronoField.YEAR_OF_ERA));
        
        List<Object> l =  ap().apply(new ArrayList<>(Arrays.asList(1,2,3,4,5)), 23);
        
    }
    
    private static <A> BiFunction<List<A>, A, List<A>> ap() {
        return (l,a) -> {l.add(a); return l;};
    }
}
