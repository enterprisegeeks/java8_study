/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Stream API レッスン2
 * Stream APIでマッチングのような複数のコレクションを扱うには、
 * 通常zipと呼ばれる仕組みが必要です。
 * 
 * zip で何ができるか見てみましょう。
 */
public class ZipPractice {
    
    public static void main(String[] args) {
        
        /*
        * 2つの整数リストの各要素同士の差を求めてみます。
        * [5,4,3,2]と [1,2,3] というリストがあって、求めたいのは、
        * [5-1, 4-2, 3-3] => [4,2,0] という同じインデックスにある要素の差です。
        * (はみ出す要素は無視します。)
        * zipを使って、以下のようにします。
        */
        List<Integer> list1 = Arrays.asList(5,4,3,2);
        List<Integer> list2 = Arrays.asList(1,2,3);
        List<Integer> subtract = zip(list1.stream(), list2.stream())
                .map(pair -> pair.one - pair.two)
                .collect(Collectors.toList());
        
        System.out.println(subtract);
        
        /*
         * mapの内容次第で、色々な処理ができることがわかると思います。 
         */
        
        /**
         * 以下は配列の特定のインデックスのみを扱いたい場合です。
         * インデックスが偶数のみの要素を扱う場合、Stream だけでは難しいですが、
         * zip と無限ストリームを組み合わせて実現します。
         */
        // この配列から日本語のみ。(インデックスが1,3のものだけとりたい)
        String[] array = {"Hello", "こんにちわ", "good-by","さようなら"};
        zip(Arrays.stream(array), Stream.iterate(0, i -> i + 1))
                .filter(pair -> pair.two % 2 == 1)
                .map(Pair::one) // これはメソッド one() を定義しているから可能なメソッド参照。
                .forEach(System.out::println);
        
        
        /*
        * 問題
        * 数列 : 1， 2， 4， 7，11， 16,,,
        * これは、要素Anと１つ前の要素An-1の差を取ると
        * 階差数列: 1,  2,  3,  4,  5,,, 
        * となります。
        * 数列とみなした配列から階差数列を求めてください。
        * ループ処理で1つ前の要素を取得するには、ループの外に一時変数などを用意すると思います。
        * zipを使って、同様の処理ができるでしょうか。
        * ヒント。1つの配列から2つのストリームを生成して、zipに渡します。
        * zipのペアが、AnとAn-1となるように片方のストリームにある中間操作を適用します。　
        */
        List<Integer> an = Arrays.asList(1,2,4,7,11,16,22);
        
       List<Integer> diff = null;//zip(/** nullを削除し、答えを記述 */);
                
        // [1,2,3,4,5,6]となるはず。
        System.out.println(diff);
    }
    
    // 以下は気になる人だけ見てください。
    
    private static class Pair<S,T> {
        final S one;
        final T two;
        
        public Pair(S s, T t) {
            one = s;
            two = t;
        }

        public S one() {
            return one;
        }

        public T two() {
            return two;
        }
        
        
    }
    
    private static <S,T> Stream<Pair<S,T>> zip(Stream<S> s, Stream<T> t) {
        
        final Iterator<S> si = s.iterator();
        final Iterator<T> ti = t.iterator();
        
        Iterator<Pair<S,T>> itr = new Iterator<Pair<S, T>>() {

            @Override
            public boolean hasNext() {
                return si.hasNext() && ti.hasNext();
            }

            @Override
            public Pair<S, T> next() {
                return new Pair<>(si.next(), ti.next());
            }
        };
        
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(itr, Spliterator.NONNULL), false);
    }
    
}
