package common;

/**
 * 社員
 * 社員は課に所属する。
 */
public class Emp {
    /** 社員ID */
    private int id;
    /** 名前 */
    private String name;
    /** 年齢 */
    private int age;
    /** 性別 */
    private Gender gender;
    /** 所属課 */
    private Section section;
    
    public Emp(int id, String name, int age, Gender gender, Section s) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.section =s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Emp other = (Emp) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emp{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", section=" + section.getName() + '}';
    }
    
    
    
}
