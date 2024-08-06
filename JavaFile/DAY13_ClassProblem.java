import java.util.List;
import java.util.Objects;

public class DAY13_ClassProblem {
    public static void main(String[] args) {

    }
}

/**
 * - XML : eXtended Markup Language
 *
 * e.g.
 *   <parent attribute>
 *       <child>
 *           <child>
 *               ...
 *           </child>
 *       </child>
 *   </parent>
 *
 * - JSON : JavaScript Object
 *
 * e.g.
 *   {
 *       "string_key" : "string"
 *       "number_key" : 0
 *       "double_key" : 0.0
 *       "boolean_key" : true,
 *       "array_key" : [
 *           "object_key" : {
 *               ...
 *           }
 *       ],
 *       "object_key" : {
 *           ...
 *       }
 *   }
 *
 * 아래의 JSON 객체를 클래스로 만들고, 표현하는 Object를 만들어봅시다.
 *   >> 객체 송수신용으로 많이 사용 > 서버 개발자는 DTO(Data Transfer Object)라고 지칭
 *   >> 서버 > 모바일
 *   >> 서버 > 웹 Ajax/XMLHttpRequest(XHR)
 *
 * - DAO(Data Access Object) : 서버와 DB 사이의 객체
 * - DTO(Data Transfer Object) : 서버와 클라이언트/서버와 서버 사이의 객체
 * - VO(Value Object) : 서버와 클라이언트/서버와 서버 사이의 객체(Read-only)
 */
//{
//    "Influencer" :   { "name" : "Jaxon" ,  "age" : 42 ,  "city" : "New York" }
//}
class Influencer {
    private String name;
    private int age;
    private String city;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Influencer that = (Influencer) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }

    // 만약, toString 안만들어줄 경우 레퍼런스 주소값이 출력됨(e.g. Influencer@67dsf67)
    @Override
    public String toString() {
        return "Influencer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}


//"school":{
//    "classes": [
//        "1-1", "1-2", "1-3", "2-1", "2-2", "2-3", "3-1", "3-2", "3-3"
//    ],
//    "studentss": [
//        {
//            "name" : "aaa",
//            "classes": "1-1",
//        },
//        {
//            "name" : "bbb",
//            "classes": "2-2",
//        },
//        {
//            "name" : "ccc",
//            "classes": "3-1",
//        }
//    ]
//}

class School {
    private List<String> classes;
    private List<Studentss> studentss;

    public List<String> getClasses() { return classes; }
    public void setClasses(List<String> classes) { this.classes = classes; }
    public List<Studentss> getStudentss() { return studentss; }
    public void setStudentss(List<Studentss> studentss) { this.studentss = studentss; }
}

// classes 는 하위에 문자열만 값으로 가지고 있으므로 불필요
//class Classes {
//    String value;
//}

class Studentss {
    private String name;
    private String classes;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getClasses() { return classes; }
    public void setClasses(String classes) { this.classes = classes; }
}


