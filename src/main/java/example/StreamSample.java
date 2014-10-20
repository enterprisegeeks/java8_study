/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author kentaro.maeda
 */
public class StreamSample {

    public static void main(String[] args) throws IOException {
        // 負数があるか?
        boolean negative = Stream.of(1, 2, 23, -4, 5, -6)
                .anyMatch(n -> n < 0); // true
        System.out.println(negative);

        // 全て aから始まるか?
        boolean startsWith_a = Stream.of("angel", "apple", "banana")
                .allMatch(s -> s.startsWith("a"));//false
        System.out.println(startsWith_a);

        init();
        // ファイルの101から200行目
        Files.lines(new File("log.txt").toPath())
                .skip(100).limit(100)
                .forEach(System.out::println);
        
        // 文字列配列を間にカンマを入れて文字列に。
        String[] sa = new String[]{"AA", "BB", "CC", "DD"};
        String concat = Arrays.stream(sa)
                .collect(Collectors.joining(","));

        String concat2 = String.join(",", sa);//別解
        
        System.out.println(concat);
        System.out.println(concat2);
        
        // 乗算
        int sum = Stream.of(1,2,3,4,5).reduce(1, (a, b) -> a * b);//120
        System.out.println(sum);
        
        //単語リストを始まりの1文字でグループ化したい。
        String[] word={"apple", "angel", "banana", "bush", "cross", "dart"};
        Map<Character, List<String>> group = Arrays.stream(word)
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(group);
        
    }

    private static void init() throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"))) {
            
            Consumer<String> c1 = s -> {
                try {
                    bw.write(s);
                    bw.newLine();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            };
            
            IntStream.range(1, 300).boxed().map(i -> "line:" + i)
                    .forEach(c1);
        }
        
        // ファイル出力はラムダ式を使うより、こちらの方がシンプルか。
        //Files.write(new File("log.txt").toPath(),
        //IntStream.range(1, 300).boxed().map(i -> "line:" + i).collect(Collectors.toList())
       // , StandardOpenOption.CREATE);

        
    }

}
