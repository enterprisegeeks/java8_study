package example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * CSVReader With rambda
 */
public class CSVReader {
    
    public static <T> List<T> read(File file, Function<String[], T> f) throws IOException {
        List<T> list = new ArrayList<>();
        for (String line : Files.readAllLines(file.toPath())) {
            list.add(f.apply(line.split(",")));
        }
        return list;
        
        // これでもよい。
//        return Files.lines(file.toPath())
//                .map(l -> l.split(","))
//                .map(f)
//                .collect(Collectors.toList());
        
        // fに対して関数合成を行うと、以下でも良い。
//        return Files.lines(file.toPath())
//                .map(f.compose(l -> l.split(","))) // composeは引数の関数を実行して、fを実行する。
//                .collect(Collectors.toList());
        
    }
    
    static class Person {
        private String lastName;
        private String firstName;
        public Person(String l, String f) {
            lastName = l;
            firstName = f;
        }
        public String toString(){return lastName + " " + firstName;}
        public String getName(){return toString();}
    }
    
    public static void main(String[] args) throws Exception{
        Files.write(new File("user.csv").toPath(), 
                Arrays.asList("tanaka,ichiro", "yamada,jiro"), StandardOpenOption.CREATE);
        
        
        List<Person> list = CSVReader.read(new File("user.csv"), 
                array -> new Person(array[0], array[1]));
        
        System.out.println(list);
        
    }
}
