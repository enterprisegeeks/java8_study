/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import common.Emp;
import common.TestData;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kentaro.maeda
 */
public class CollectionLambda {
    public static void main(String[] args) {
        // Listの中身を出力。
        Arrays.asList(1,2,3,4).forEach(System.out::println);
        
        // 演習1ソートの別解
        List<Emp> list = TestData.allEmployees();
        list.sort(Comparator.comparing(Emp::getName));
        list.forEach(e -> System.out.println(e.getId() + ":" + e.getName()));
        
        // Mapの出力、値更新。
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        // キー=2の値を累乗する。
        map.compute(2, (k, v) -> v * v);
        map.forEach((k,v)-> System.out.println(String.format("key=%d:value=%d", k,v)));
        
    }
}
