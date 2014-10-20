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
 * メソッド参照サンプル
 */
public class MethodRef {
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

        
        // 引数なし→戻り値あり。コンストラクタのメソッド参照
        Supplier<List<String>> s1 = () -> new ArrayList<>();
        Supplier<List<String>> s2 = ArrayList::new;
        List<String> l = s2.get(); // ArrayList
        // 引数2つ→戻り値有り。
        //Integer.sumはただの加算だが、まさにメソッド参照で使うために用意されたと思われる。
        BinaryOperator<Integer> add1 = (a,b)-> Integer.sum(a, b);
        BinaryOperator<Integer> add2 = Integer::sum;
        int res = add2.apply(5,6);// 11
        
        // オブジェクトのメソッド実行
        Function<Person, String> p1 = p -> p.getName();
        Function<Person, String> p2 = Person::getName;
        
        System.out.println(p1.apply(new Person("tanaka", "ichiro")));
        System.out.println(p2.apply(new Person("tanaka", "ichiro")));
        
        
    }
}
