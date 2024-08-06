import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DAY16_Annotation {
    public static void main(String[] args) {
        /**
         * - 제어의 역전(IoC : Inversion of Control) : DL 와 DI의 결합
         *
         * 의존성 탐색(DL : Dependency Lookup) : 문자열 등을 통해서 선언된 클래스를 탐색
         * 의존성 주입(DI : Dependency Injection) : 특정한 객체가 필요로 하는 객체를 외부에서 만들어서 주입
         *
         * - 의존성 주입 방법
         *   >> 생성자 주입 : 객체를 생성할 때 주입
         *   >> 필드 주입(Setter 주입) : 생성된 후 특정한 방법으로 필드에 주입
         *   >> 메소드 주입 : 생성된 후 특정한 메소드를 호출하여 주입
         */

        Class<A> aCls = A.class;

        A a = null;
        try {
            Constructor<A> constructor = aCls.getDeclaredConstructor();

            // 생성자 주입
            a = constructor.newInstance(new B());

            // 생성자 주입 : 애노테이션을 통한 주입 자동화
            Injection injection = constructor.getAnnotation(Injection.class);
            if(injection != null) {
                a = constructor.newInstance(new B());
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 필드 주입
        a.setB(new B());

        // 필드 주입 : 애노테이션을 통한 주입 자동화
        Field[] fields = a.getClass().getDeclaredFields();
        for(Field field : fields) {
            Injection injection = field.getAnnotation(Injection.class);
            if(injection != null) {
                Class<?> cls = injection.value();
                if(cls == B.class.getClass()) {
                    a.setB(new B());
                }
            }
        }

        // 메소드 주입
        a.method(new B());

        // 메소드 주입 : 애노테이션을 통한 주입 자동화
        Method[] methods = a.getClass().getDeclaredMethods();
        for(Method method : methods) {
            Injection injection = method.getAnnotation(Injection.class);
            if(injection != null) {
                Class<?> cls = injection.value();
                if(cls == B.class.getClass()) {
                    a.method(new B());
                }
            }
        }
    }
}

@Target({
        ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD,
})
@interface Injection {
    Class<?> value();
}

class A {
    B b;

    // 애노테이션을 이용한 생성자 주입 구현 시
    @Injection(B.class)
    // 생성자 주입
    A(B b) {
        this.b = b;
    }

    // 애노테이션을 이용한 필드 주입 구현 시
    @Injection(B.class)
    // 필드 주입
    public void setB(B b) {
        this.b = b;
    }

    // 애노테이션을 이용한 메소드 주입 구현 시
    @Injection(B.class)
    // 메소드 주입
    public void method(B b) {
        this.b = b;
    }
}
class B { }