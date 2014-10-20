package common;

import java.util.ArrayList;
import java.util.List;

/**
 * 演習用テストデータ提供
 */
public class TestData {
    
    private static List<Dept> depts = new ArrayList<>();
    
    static {
        Dept ps2 = new Dept("総務部");
            Section ps21 = new Section("総務1課", ps2);
                ps21.addEmp(new Emp(1, "田中", 32, Gender.MALE, ps21));
                ps21.addEmp(new Emp(2, "山田", 25, Gender.FEMALE, ps21));
            Section ps22 = new Section("総務2課", ps2);
                ps22.addEmp(new Emp(3, "高橋", 23, Gender.MALE, ps22));
            Section ps23 = new Section("総務幽霊課", ps2);
            ps2.addSection(ps21);
            ps2.addSection(ps22);
            ps2.addSection(ps23);
        Dept ps3 = new Dept("営業部");
            Section ps31 = new Section("営業2課", ps3);
                ps31.addEmp(new Emp(4, "目黒", 43, Gender.FEMALE, ps31));
                ps31.addEmp(new Emp(5, "中目黒", 42, Gender.MALE, ps31));
                ps31.addEmp(new Emp(6, "御囲地町", 25, Gender.FEMALE, ps31));
            Section ps32 = new Section("営業3課", ps3);
                ps32.addEmp(new Emp(7, "伊藤", 78, Gender.MALE, ps32));
                ps32.addEmp(new Emp(8, "佐藤", 21, Gender.MALE, ps32));
            ps3.addSection(ps31);
            ps3.addSection(ps32);
        depts.add(ps2);
        depts.add(ps3);
    }
    
    public static List<Dept> allDepts() {
        return depts;
    }
    // 課題として、同様の処理をStreamで行う。
    public static List<Section> allSection() {
        List<Section> sections = new ArrayList<>();
        for (Dept d : depts) {
            sections.addAll(d.getSections());
        }
        return sections;
    }
    
    
    // 課題として、同様の処理をStreamで行う。
    public static List<Emp> allEmployees() {
        List<Emp> list = new ArrayList<>();
        for (Section s : allSection()) {
            list.addAll(s.getEmployees());
        }
        return list;
    }
    
    public static void main(String[] args) {
        allDepts().stream().forEach(d -> System.out.println(d.getName()));
        
        allSection().stream().map(Section::getName).forEach(System.out::println);
        
        
        allEmployees().stream().forEach(e -> System.out.println(e));
        
    }
    
    
}
