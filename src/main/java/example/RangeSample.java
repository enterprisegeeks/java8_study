package example;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 範囲生成サンプル
 */
public class RangeSample {
    
    public static void main(String[] args) {
        
        // 1から10の合計
        int sum = IntStream.range(1, 11).sum();
        System.out.println(sum);
        
        // flatMapによる組み合わせ
        // 0から9の数字のうち、乗算の値が25を超える組み合わせを求める。
        // TODO eclipse4.4では以下のコードはエラーとなります。コメントアウトしているコードを有効にしてください。
        List<String> comb = IntStream.range(0, 10).boxed()
                  .flatMap(x -> IntStream.range(x, 10).boxed()
                           .filter(y -> x * y >= 25).map(y -> x + "," + y))
                  .collect(Collectors.toList());     
        System.out.println(comb);
        
        /* ecpliseではネストしたラムダ式の型指定が必要。
        List<String> comb_ecplise = IntStream.range(0, 10).boxed()
                  .flatMap((Integer x) -> IntStream.range(x, 10).boxed()
                           .filter((Integer y) -> x * y >= 25).map((Integer y) -> x + "," + y))
                  .collect(Collectors.toList());
        
        System.out.println(comb_ecplise);
        */
        
        // 無限数の用途
        // 自然数のうち、3または5で割りきれる100番目の数字を求める。
        Optional<Integer> num = Stream.iterate(1, i -> i + 1)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .skip(99).findFirst();
        
        num.ifPresent(System.out::println);//215
        
    }
}
