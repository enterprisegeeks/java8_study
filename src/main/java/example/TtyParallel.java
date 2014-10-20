/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 並列処理実験
 */
public class TtyParallel {

    public static void main(String[] args) {
        List<Integer> list
                = IntStream.range(1, 1000).boxed()
                .parallel() // コメントアウトしたりして実行してください。
                .peek(i -> System.out.println("N=" + i + " process thread is [" + Thread.currentThread().getName() + "]"))
                .map(i -> i * 100 + i)
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
