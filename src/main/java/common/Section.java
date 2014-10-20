package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 課。
 * 課は1つの部署に所属し、
 * 課には複数の社員がいる。
 */
public class Section {
    /** 課名 */
    private String name;
    /** 所属部署 */
    private Dept dept;
    /** 課内の社員 */
    private List<Emp> employees = new ArrayList<>();
    
    public Section(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
    }
    
    public void addEmp(Emp e) {
        employees.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Section{" + "name=" + name + ", dept=" + dept.getName() + ", employees=" + employees + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.dept);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Section other = (Section) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dept, other.dept)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
