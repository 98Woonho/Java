import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DAY12_ClassProblem {
    public static void main(String[] args) {
        Game game = new Game();

        NPCs npc1 = new NPCs();
        NPCs npc2 = new NPCs();
        NPCs npc3 = new NPCs();
        NPCs npc4 = new NPCs();
        game.add(npc1);
        game.add(npc2);
        game.add(npc3);
        game.add(npc4);
        Characters character1 = new Characters();
        Characters character2 = new Characters();
        Characters character3 = new Characters();
        Characters character4 = new Characters();
        game.add(character1);
        game.add(character2);
        game.add(character3);
        game.add(character4);
        Monsters monsters1 = new Monsters();
        Monsters monsters2 = new Monsters();
        Monsters monsters3 = new Monsters();
        Monsters monsters4 = new Monsters();
        game.add(monsters1);
        game.add(monsters2);
        game.add(monsters3);
        game.add(monsters4);
        // 그래픽 상에서 무기와 캐릭터 사이에
        // 충돌(Collision)이 발생된 것을 확인하면,
        // 공격된 것으로 처리
        character3.attack(monsters2);
    }
}

// 게임을 만든다고 합시다.
// 그럼 캐릭터들이 있을 것이고, 몬스터도 있습니다.
// 몬스터는 몬스터끼리 싸울 수 없습니다.
// 캐릭터도 캐릭터 간에 싸울 수 없습니다.
// 캐릭터와 몬스터 간에만 싸울 수 있는데,
// 체력이란 것도 있을 것이고, 에너지나 등등 정보들이 더 있습니다.
// 체력이 0이 되면, 캐릭터는 죽는겁니다.
// 이것을 클래스로 표현해보세요.
class Game {
    private List<GameObject> gameObjects = new ArrayList<GameObject>();
    public void add(GameObject gameObject) {
        gameObjects.add(gameObject);
    }
    public void remove(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }
}
abstract class GameObject {
    GameObject(
        int health,
        int attack,
        int defence
    ) {
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }

    /**
     * 체력
     *
     * @author 작성자
     * @since 작성한 날짜
     * @see 참고자료
     */
    protected int health;
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    /**
     * 공격력
     */
    protected int attack;
    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    /**
     * 방어력
     */
    protected int defence;
    public int getDefence() { return defence; }
    public void setDefence(int defence) { this.defence = defence; }

    public void attack(GameObject target) {
        //같은 클래스끼리는 공격 불가
        if(target.getClass() == this.getClass()){
            return;
        }

        // 내공격력(2) - 상대방어력(1) = 깎아야할 체력(1)
        // 내공격력(2) - 상대방어력(3) = 깎아야할 체력(-1)
        int attackValue = attack - target.defence;
        if(attackValue > 0) {
            target.health -= attackValue;
        }
    }

    // hashCode() 와 equals() 는 한 세트
    // 주어진 객체가 같은 객체인지 판별
    //
    // List.add, List.remove 등에 대해서 같은 객체인지 판별이 되어야 동작

    @Override
    public boolean equals(Object o) {
        // 얕은 복사(Shallow Copy) : C언어 같으면 포인터 주소, Java 같으면 레퍼런스 주소만 복사
        // 깊은 복사(Deep Copy) : 값 전체를 복사

        // 주어진 객체 o와 this가 같은지 판별(얕게 확인)
        // 얕게 확인 : 주소가 같은지 확인
        if (this == o) return true;
        // o가 Null 인지 판별
        // or 클래스가 같은지 판별
        if (o == null || getClass() != o.getClass()) return false;
        // 가지고 있는 값이 같은지
        GameObject that = (GameObject) o;
        return health == that.health;
    }

    @Override
    public int hashCode() {
        // 값들을 해시코드 라는 정수값으로 변환
        return Objects.hash(health);
    }

    // toString : 객체를 문자열로 변환
    @Override
    public String toString() {
        // JSON 문자열
//        return "{ health:"+health+" }";
        return "GameObject{" +
                "health=" + health +
                '}';
    }
}
class Characters extends GameObject {
    Characters() {
        super(100, 1, 1);
    }
}
class NPCs extends GameObject {
    NPCs() {
        super(10000000, 10000, 10000);
    }
}
class Monsters extends GameObject {
    Monsters() {
        super(100, 1, 1);
    }
}
