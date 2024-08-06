import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAY11_ClassProblem {
}

// View는 Button, Text, Image 가 될 수 있다.
// 그리고 각 UI 요소들은 사용자와 상호작용할 수도 있고, 안할 수도 있다.
// 그러한 UI 요소가 특정하게 템플릿화되면 컴포넌트(Component)가 된다고 한다.
// 이 관계를 클래스로 정의하고 동작을 테스트하시오.
// (예를 들어, 버튼은 눌려질 수 있다.)

abstract class View {
    public View(View... views) {
        //children = Arrays.stream(views).toList();
        for(int i = 0; i < views.length; i++) {
            children.add(views[i]);
        }
    }

    private List<View> children = new ArrayList<>();
    private List<Interacter> interacters = new ArrayList<>();

    protected float x;
    protected float y;
    protected float width;
    protected float height;

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    public void setWidth(float width) { this.width = width; }
    public void setHeight(float height) { this.height = height; }

//    final void interact() {
//        onInteract();
//    }
//    // 뷰가 상호작용할 수도 있고, 안 할수도 있고...
//    // 상호작용하고 싶으면 오버라이드, 상호작용할게 없으면 오버라이드 안하면 됨
//    void onInteract() { }

    // 뷰를 그려냄
    // 메소드에서 final 키워드 : 오버라이드 방지
    // 템플릿(Template) 패턴 : 동작을 템플릿화 시키고, 그 동작에 오류가 없게끔 도와줌
    final void draw() {
        // 다른 기타 코드들

        // 훅(Hook) 메소드 : 기존 정해진 동작에 끼어들 수 있게끔 제공
        // 콜백(Callback) 메소드 : 어떤 이벤트가 일어났을 때, 그 타이밍을 알 수 있게끔 제공

        // 배경이나 뷰를 그리기전에 선행작업
        onDraw();

        // 그 다음 자식 뷰를 그림
        children.forEach(view -> view.draw());

        // 다른 기타 코드들
    }

    abstract void onDraw();
}

// 인터페이스에서 인터페이스를 상속 가능
interface Interacter {
    void interact();
}
interface Clicker extends Interacter {
    void click();
}

class Text extends View implements Clicker {
    @Override
    void onDraw() {
        System.out.println("Draw Text! (" + x + ", " + y + ", " + (x + width) + ", " + (y + height) + ")");
    }

    // 상호작용한다? -> 무얼할지 모르겠음 -> Clicker를 동작시키도록 함
    @Override
    public void interact() {
        click();
    }

    @Override
    public void click() {
        System.out.println("클릭됨");
    }
}

class Image extends View implements Interacter {
    @Override
    void onDraw() {
        System.out.println("Draw Image! (" + x + ", " + y + ", " + (x + width) + ", " + (y + height) + ")");
    }

    @Override
    public void interact() {
        System.out.println("상호작용");
    }
}
