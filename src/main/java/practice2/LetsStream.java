/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice2;

import common.Dept;
import common.Emp;
import common.Gender;
import common.TestData;
import common.Section;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream API レッスン1
 */
public class LetsStream {
    /**
     * オブジェクトベースのStream APIを使って見ましょう。
     */
    public static void main(String[] args) {
        
        // 社員から男性のみを抽出し、その名前と年齢をコンソール出力してください。
        TestData.allEmployees().stream()
                .filter(e -> e.getGender() == Gender.MALE)
                .map(e -> e.getName() + "(" + e.getAge() + ")")
                .forEach(System.out::println);
                
        // 50歳以上の社員はいますか?
        boolean over50 = TestData.allEmployees().stream()
                .anyMatch(e -> e.getAge() >= 50);
        
        System.out.println(over50);
        // 営業部の社員の平均年齢は?
        double avg = TestData.allEmployees().stream()
                .filter(e ->e.getSection().getDept().getName().equals("営業部"))
                .collect(Collectors.averagingDouble(Emp::getAge));

        
        System.out.println(avg);
        // 課ごとに社員を分けてください
        Map<Section, List<Emp>> group = TestData.allEmployees().stream()
                .collect(Collectors.groupingBy(Emp::getSection));
        
        System.out.println(group);
        
        // 部署の一覧から、課の一覧を作ってください。
        // ヒント : flatMap を使います。
        List<Section> secionList = TestData.allDepts().stream()
                  .flatMap(d -> d.getSections().stream())
                  .collect(Collectors.toList());
        
        secionList.stream().map(Section::getName).forEach(System.out::println);
        System.out.println("");
        
        // 部署の一覧から社員の一覧を作ってください。
        List<Emp> empList = TestData.allDepts().stream()
                    // flatmapの2重適用。
                  .flatMap(d -> d.getSections().stream())
                  .flatMap(s -> s.getEmployees().stream())
                  .collect(Collectors.toList());
        System.out.println(empList);
        
        
    }
    
}
