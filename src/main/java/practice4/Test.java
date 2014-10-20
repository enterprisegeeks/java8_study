package practice4;

import java.util.Optional;

/**
 *
 * @author kentaro.maeda
 */
public class Test {
    /* 解答記述の際にコメントアウトをはずしてください、
    public static void main(String[] args) {
        
        OptionalMap<String, String> shiritori = new OptionalHashMap<String, String>(){{
            put("しりとり", "りんご");
            put("りんご", "ごりら");
            put("ごりら", "らっぱ");
            put("らっぱ", "ぱん");
        }};
        
       shiritori.getByOpt("しりとり").ifPresent(v -> System.out.println("しりとり->" + v ));
        
       System.out.println(shiritori.getByOpt("りんご").orElse("なかった"));
       System.out.println(shiritori.getByOpt("ぱんだ").orElse("なかった"));
        
        //3回しりとりが続けれるか?
        String start = "ごりら"; // 適宜変えてみてください。
        Optional<String> res = shiritori.getByOpt(start)
               .flatMap(shiritori::getByOpt)
                .flatMap(shiritori::getByOpt);
                
        if (res.isPresent()) {
            System.out.println(start + "から3回続けると、" + res.get() + "になります。");
        } else {
            System.out.println(start + "から3回つづけられませんでした。");
        }
   }
    */
}
