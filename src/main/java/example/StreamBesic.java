package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ストリームの基本コード
 */
public class StreamBesic {

    public static void main(String[] args) {

        byForLoop();
        byStream();
    }

    private static void byStream() {
        List<String> list
                = Arrays.asList("A001", "100", "-200", "ABC", "92");
        List<Integer> res2 = list.stream() // Streamを‚生成
                .filter(s -> s.matches("[-+]?\\d+"))//整数のみ抽出
                .map(s -> Integer.parseInt(s)) //文字列→整数
                .filter(i -> i > 0) // 正の整数のみ抽出
                .map(i -> i * 3) // 3倍する
                .collect(Collectors.toList());      //結果をListとして取得
        System.out.println(res2);
    }

    private static void byForLoop() {
        List<String> list
                = Arrays.asList("A001", "100", "-200", "ABC", "92");
        List<Integer> res = new ArrayList<>();
        for (String s : list) {
            if (s.matches("[-+]?\\d+")) {
                int i = Integer.parseInt(s);
                if (i > 0) {
                    res.add(i * 3);
                }
            }
        }
        System.out.println(res);//300, 276

    }

}
