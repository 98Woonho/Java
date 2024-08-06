public class DAY9_Problem {
    // main 메서드 작성
    public static void main(String[] args) {
        // 'Student' 객체 생성 및 화면에 출력
        Student student = new Student();
        student.printGrade();

        // 'Character' 객체 생성 및 기능 호출
        Character character = new Character();
        character.swing(true);
    }
}

enum Grade {
    A(90, 100),
    B(80, 89),
    C(70, 79),
    D(60, 69),
    F(0, 59);

    Grade(int minScore, int maxScore) {
        this.maxScore = maxScore;
        this.minScore = minScore;
    }

    int maxScore;
    int minScore;
}

class Student {
    // 멤버 변수 선언
    private Grade grade = Grade.F;
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade newValue) {
        this.grade = newValue;
    }

    // 생성자 메서드 작성
    Student() {
        this.grade = Grade.F;
    }
    Student(Grade grade) {
        this.grade = grade;
    }

    // 성적 출력 메서드 작성
    void printGrade() {
        System.out.println("이 학생의 성적 : "+grade);
    }
}

enum Weapon {
    Sword, // 검
    Pole, // 봉
    Spear // 창
}

enum State {
    Good,
    SoSo,
    Bad
}

class Character {
    // 게임 캐릭터를 클래스로 3종류 만들고,
    // 캐릭터는 다양한 값을 가질 수 있음 (e.g. 팔, 다리 등)
    // 캐릭터가 동작하는 기능을 선언하고, (e.g. 칼 휘두르기, 날기 등)
    // 캐릭터 동작은 옵션적으로 줄 수 있는 기능도 있어야 한다.
    private State body = State.Good;
    private State head = State.Good;
    private State leftArm = State.Good;
    private State leftLeg = State.Good;
    private State rightArm = State.Good;
    private State rightLeg = State.Good;
    private Weapon weapon;

    public State getHead() {
        return head;
    }
    public State getBody() {
        return body;
    }
    public State getLeftArm() {
        return leftArm;
    }
    public State getLeftLeg() {
        return leftLeg;
    }
    public State getRightArm() {
        return rightArm;
    }
    public State getRightLeg() {
        return rightLeg;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    void swing(boolean hasWeapon) {
        String weapon = hasWeapon && this.weapon != null ? this.weapon.name().toUpperCase() : null;
        weapon = weapon != null? weapon : "HAND";
        System.out.println("Use " + weapon);
    }

    void onLeftArmAttacked() {
        switch (leftArm) {
            case Good:
                leftArm = State.SoSo;
                break;
            case SoSo: // 사용 가능
                leftArm = State.Bad;
                break;
            case Bad:
            default: // 사용불가
                leftArm = null;
                break;
        }
    }

    void onLeftArmRetreived() {
        switch (leftArm) {
            case Bad:
                leftArm = State.SoSo;
                break;
            case SoSo: // 사용 가능
                leftArm = State.Good;
                break;
            case Good:
            default: // 사용불가
                leftArm = State.Good;
                break;
        }
    }
}
