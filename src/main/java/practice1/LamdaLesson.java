/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice1;

import common.Emp;
import common.TestData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 練習1 - ラムダ式
 */
public class LamdaLesson {
    
    /**
     * 匿名クラスによるComparatorを使用した整数リストの昇順ソートをラムダ式に書き換えてください。
     * (NetBeansの場合、コードアシストで書き換え可能かもしれませんが、あえて自分でやりましょう。)
     */
    public static void lesson1() {
        List<Integer> list = new ArrayList<Integer>(){{
          add(5);
          add(3);
          add(4);
          add(2);
          add(1);
        }};
        // 匿名クラス = ラムダ式なので書き換え可能。
        Collections.sort(list, (Integer x, Integer y) -> x - y);
        
        System.out.println(list);
    }
    
    // 社員一覧について、ラムダ式を用いて、名前の昇順に並べ替えてください。
    public static void lesson2() {
        List<Emp> empList = new ArrayList<>(TestData.allEmployees());
        
        Collections.sort(empList, (x,y) -> x.getName().compareTo(y.getName()));

        System.out.println(empList);
        
    }
    
    public static void main(String[] args) {
        lesson1();
        lesson2();
    }
}
