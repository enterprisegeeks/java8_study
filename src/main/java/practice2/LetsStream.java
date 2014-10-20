/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice2;

import common.Dept;
import common.Emp;
import common.TestData;
import common.Section;
import java.util.List;
import java.util.Map;

/**
 * Stream API レッスン1
 */
public class LetsStream {
    /**
     * オブジェクトベースのStream APIを使って見ましょう。
     */
    public static void main(String[] args) {
        
        // 社員から男性のみを抽出し、その名前と年齢をコンソール出力してください。
        TestData.allEmployees().stream()/** 解答  */;
                
        // 50歳以上の社員はいますか?
        //boolean over50 = TestData.allEmployees().stream()/** コメントをはずし解答  */;
        
        //営業部の社員の平均年齢は?
        //double avg = TestData.allEmployees().stream()/* コメントをはずし解答 */;
        
        // 課ごとに社員を分けてください
        //Map<Dept, List<Emp>> group = TestData.allEmployees().stream()/* コメントをはずし解答 */;
        
        // 部署の一覧から、課の一覧を作ってください。
        // ヒント : flatMap を使います。
        //List<Section> secionList = TestData.allDepts().stream()/*コメントをはずし解答 */;
        
        // 部署の一覧から社員の一覧を作ってください。
        //List<Emp> empList = TestData.allDepts().stream()/* コメントをはずし解答*/;
        
        
    }
    
}
