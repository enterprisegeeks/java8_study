package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 部署
 * 部には複数の課がある。
 */
public class Dept {
    /** 部署名 */
    private String name;
    /** 部署内の課 */
    List<Section> sections = new ArrayList<>();
    
    public Dept(String name) {
        this.name = name;
    }
    
    public void addSection(Section s) {
        sections.add(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    
    
    
    @Override
    public String toString() {
        return "Dept{" + "name=" + name + ", sections=" + sections + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final Dept other = (Dept) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
