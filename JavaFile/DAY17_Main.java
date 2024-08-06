import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DAY17_Main {
    public static void main(String[] args) {
        /**
         * (Note. Reflect : 반사하다.)
         * - 리플렉션(Reflection) : 프로그래머가 코드를 입력 > 런타임환경 JVM기반에서 역으로 그 코드를 분석해내는 것
         *   - Class<?> : ? 는 와일드카드(Wildcard) => 와일드카드? 무엇이든지 사용 가능하게 지정(현재는 무엇이 들어갈지 모름)
         *     == Class<*>
         *
         * - Java를 JAR/WAR/EAR로 내보내기 : https://ifuwanna.tistory.com/244
         *
         *   class파일들을 압축파일로 만들어서, 다른 프로젝트에서 불러와서 사용 가능
         *
         *   >> 자바 압축(JAR : Java ARchive)
         *   >> 웹앱 압축(WAR : Web application ARchive)
         *   >> 엔터프라이즈 압축(EAR : Enterprise ARchive)
         *
         *   + ANT, Maven, Gradle => 빌드 자동화(사용자가 원하는대로 최대한 지원)
         *     ====>>>> 의존성(Dependency, Maven에 있는 JAR들 사용하는 행위)을 가져와서 빌드를 자동화
         *     > ANT : XML스크립트(build.xml)를 읽어서 빌드만 수행
         *     > Maven : XML스크립트(pom.xml)를 읽어서 빌드 + 라이프사이클 존재 + 의존성 관리
         *       (Maven Repository 에서 의존성을 가져옴)
         *     > Gradle : 독자적 파일(build.gradle/build.gradle.kts)를 읽어 빌드 + 라이프사이클 존재 = + 의존성 관리 + 작업 관리
         *
         * - 리플렉션의 궁극적 이유? 특정 클래스 기반의 객체에게 의존하는 것을 느슨(Loose)하게 결합시킴
         */

        // 객체 정보없이 클래스 정보를 가져오는 방법
        Class<?> cls = Clazz.class;

        // 필드 정보 읽기
        Field[] fields = cls.getFields();// 접근 가능한 모든 필드들(상속 포함)
        Field[] declaredFields = cls.getDeclaredFields(); // 정의되어있는 모든 필드들(상속 비포함, 현재 클래스에서만)
        System.out.println(fields.length);
        System.out.println(declaredFields.length);

        // 메소드 정보 읽기
        Method[] methods = cls.getMethods();// 접근 가능한 모든 메소드들(상속 포함)
        Method[] declaredMethods = cls.getDeclaredMethods(); // 정의되어있는 모든 메소드들(상속 비포함, 현재 클래스에서만)
        System.out.println(methods.length);
        System.out.println(declaredMethods.length);

        // 생성자 정보 읽기
        Constructor[] constructors = cls.getConstructors();
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        System.out.println(constructors.length);
        System.out.println(declaredConstructors.length);

        Object newInstance = null;
        // 리플렉션을 통한 객체 생성의 예
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor<Clazz> constructor = declaredConstructors[i];
            if(constructor.getParameterCount() < 1){ continue; }
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if(parameterTypes[0] != int.class) { continue; }

            try {
                newInstance = constructor.newInstance(1);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            // 리플렉션을 통한 값 설정의 예
            for(Field f : declaredFields) {
                boolean isFieldMember = f.getName() == "field" && f.getType() == int.class;
                if(!isFieldMember) { continue; }

                //== f.getAccessable()
                boolean isAccessable = f.canAccess(newInstance);
                f.setAccessible(true);
                try {
                    f.setInt(newInstance, 172893);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                f.setAccessible(isAccessable);
            }

            // 리플렉션을 통한 값 메소드 호출의 예
            for(Method m : declaredMethods) {
                boolean isMethodMember = m.getName() == "method"
                        && (m.getParameterTypes().length > 0 && m.getParameterTypes()[0] == int.class);
                if(!isMethodMember) { continue; }
                try {
                    m.invoke(newInstance, 23789498);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(newInstance != null) {
            // 원하는 작업
            System.out.println("객체 생성 완료");
        }
        System.out.println("-- 생성자 리플렉션 테스트 완료 -------------------------------------");

        // 객체 정보 + 클래스 정보를 가져오는 방법
        Clazz instance = new Clazz();
        Class<Clazz> clsWithInstance = (Class<Clazz>)instance.getClass();

        // 와일드 카드 사용
        Object obj = instance;
        Class<?> clsWithObject = obj.getClass();
        new DAY17_Main().fnKeepT(obj);
    }

    /**
     * - 제네릭(Generic) : 일반화 프로그래밍 => 런타임에서 타입을 결정해서 처리하는 프로그래밍
     *
     *   >> 컴파일 타임 타입 결정 : 우리가 코드를 작성할 때 이미 타입을 결정 가능한 프로그래밍
     *      >> 클래스의 이름을 비교해서 타입을 결정하는 형식 => 정적 타이핑(Static Typing)
     *   >> 런 타임 타입 결정 : 프로그램이 동작할 때 그 타입을 결정해서 하는 프로그래밍
     *      >> 객체의 필드,메소드 등을 비교해서 타입을 결정하는 형식 => 구조적 타이핑(Structural Typing)
     *
     *   명시적 프로그래밍(클래스 유형을 정확하게 지시해서 프로그래밍) => 호출 가능한 필드, 메소드 정확하게 호출
     *   일반화 프로그래밍 => 요구하는 형식에 맞추어서 두루뭉실하게 프로그래밍 => 의존성을 느슨하게 만듬
     *
     *   >> 타입 파라미터(Type parameter) : 앵글브래킷(`<>`) 사이에서 여러 개가 들어갈 수 있고, 타입을 가리킴
     *      >> 런타임에서 Object 클래스로 변환 => 컴파일 후에 Object 클래스 형식으로 변환되어있음
     *         => 타입을 잃음 => 타입 생략(Type ellision)
     *
     * <T> void reflectT(T instance) { ... }
     * <T, R> R reflectTR(T instance) { ... }
     * <K, V, R> R reflectKVR(Pair<K,V> instance) { ... }
     */

    // - 타입 파라미터의 타입 제한 : 상속을 받았는 범위만 T에 올 수 있도록 제한
    //   >> extends 키워드 or super 키워드 : 인터페이스든 클래스든 관계없이 동일 키워드
    // 한 개 클래스/인터페이스 상속으로 범위를 제한시킬 때
    <T extends Clazz> void restrictedOfClazz() { }
    <T extends Interface> void restrictedOfInterface() { }
    //<T super Clazz> void restrictedSuper() { }

    // 여러 개 클래스/인터페이스 상속으로 범위를 제한시킬 때
    <T extends Clazz & Interface> void restricted() { }

    // 아래 두 함수는 같은 함수임 => 타입 생략 문제
    void fnWithObject(Object param) {}
    <T> void fnWithT(T param) {}

    // 제네릭 사용시 타입 생략 방지 기법 2가지
    <T> void fnKeepT(T instance) {
        // 타입 단언(Type Assertion) : 강제 형변환을 통해 특정 클래스라는 것을 컴파일러가 확신시하게 함
        // instance에는 null이 올 수 있음
        //  => 첫번째 문제 : 컴파일러는 'null'은 무슨 타입이지? 라고 생각함
        //  => 두번째 문제 : instance가 null이면, getClass는 당연하게 null point exception
        //  => 디펜스코드 필요
        Class<T> tCls = (Class<T>) instance.getClass();

        // 리플렉션을 통해 어떤 필드를 사용하거나 메소드를 호출하거나 등등을 할 수 있음
    }
    <T> void fnKeepT(Class<T> tCls) {} // 아무 문제가 일어나지 않을 코드 => 권장
}

interface Interface {}

class Pair<K,V> {
    K mKey;
    V mValue;

    public K getKey() { return mKey; }
    public void setKey(K key) { this.mKey = key; }

    public V getValue() { return mValue; }
    public void setValue(V value) { this.mValue = value; }
}

class Clazz {
    // 생성자
    Clazz() {
        System.out.println("Clazz() 객체 생성 중...");
    }
    // 생성자 오버로딩
    Clazz(int param) {
        System.out.println("Clazz(int param) 객체 생성 중...");
    }

    // 내부 필드
    private int field = 0;
    public int publicField = 0;

    // 액세서 (== 메소드)
    public int getField() { return field; }
    public void setField(int newValue) { this.field = newValue; }

    // 메소드
    public boolean method() { return true; }
    // 메소드 오버로딩
    public boolean method(int param) { return true; }
}
