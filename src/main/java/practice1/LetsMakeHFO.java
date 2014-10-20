package practice1;

import common.Dept;
import common.Section;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * ラムダ式課題2 ラムダ式を受け取るメソッドを作ろう。
 * 
 * CSVファイルのデータ変換を題材に、ラムダ式を受け取る側のメソッドを作り、理解を深めます。
 * 
 * 関数型言語では、関数を引数に受け取る関数や、関数を返す関数を、
 * 高階関数(High Order Function -> HFO)と呼びます。
 * 
 */
public class LetsMakeHFO {
    /**
     * CSVファイルから任意のオブジェクトの一覧へ変換する。
     * 本来であればIOリソースとすべきだが、単純化するため文字列リストをファイルの内容と見立てています。
     */ 
    public static <R> List<R> readCsv(List<String> csvLines, LineToObject<R> lambda) {
    //Functionを用いて、以下でもよい。
    //public static <R> List<R> readCsv(List<String> csvLines, Function<String[],R> lambda) { 
        List<R> list = new ArrayList<>();
        
        // 1行ずつカンマで分割し、ラムダ式の内容でR型へ変換する。
        for (String line : csvLines) {
            String[] items = line.split(",");
            
            R r = lambda.apply(items);
            list.add(r);
        }
        return list;
    }
    
    /** テスト。commonパッケージの課一覧への変換を試みます。 */
    public static void main(String[] args) {
        //部署名と課名のCSVファイル。
        List<String> csvLines = Arrays.asList("PS1部, PS1-1",
                "PS1部, PS1-2",
                "PS2部, PS2-1",
                "PS2部, PS2-2");
        
        // 文字列配列から Sectionオブジェクトのコンストラクタ呼び出しのラムダ式。
        List<Section> sections = readCsv(csvLines, 
                item -> new Section(item[1], new Dept(item[0])));
        System.out.println(sections);
        
    }
}

/**
 * CSVファイルの一行をカンマで区切った文字列配列を引数に、任意のオブジェクトへの変換を行う関数です。
 * なお、今回は練習ということで関数型インターフェースを作成しましたが、
 * 標準の、 java.util.function.Function<T,R> で、 TをString[] として宣言した方が良いです。
 * @see Function
 */
@FunctionalInterface
interface LineToObject<R> {
    R apply(String[] items);
}
