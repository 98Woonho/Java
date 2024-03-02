import java.util.HashMap;
import java.util.Map;

public class DAY14_ClassProblem {
    public static void main(String[] args) {

    }
}

// 앱스토어 구축
// 앱 스토어에는 여러 앱이 있을 수 있고, 이 앱들은 각각의 분류들을 가짐
// 앱들의 내용은 각각의 앱마다 다르고, 외부 결제형 또는 앱 내 결제형, 그리고 구독 또는 1회성 결제 유형으로 나뉨
// 또한, 각 앱들은 사진이 보여질 수 있으며, 이 사진은 서버로부터 받아올 수 있게 됨
// 이것을 클래스로 표현하시오.
enum Genre {
    Common,
    Game,
}

class AppStore {
    // 앱스토어는 여러 개의 앱을 가진다.
    private Map<String, App> mApps = new HashMap<>();

    // 중첩 클래스: 클래스는 클래스인데, 내부 클래스가 아니라, "중첩" 된다.
    // - 내부 클래스(Inner Class)  vs 중첩 클래스(Nested Class)
    //   >> 내부 : 바깥쪽 클래스의 멤버에 접근 가능
    //   >> 중첩 : 바깥쪽 클래스의 멤버에 접근 불가능
    //
    //   그럼 아무거나 쓰면 되는 것 아닌가요?
    //      내부 클래스의 문제는 그 멤버에 접근할 수 있다는 것에 문제가 있음
    //      멤버에 접근할 수 있다는 것은 레퍼런스 주소를 알고 있다는 의미
    //      ==>> 메모리적 문제 발생
    //      필요없는 객체를 제거하는 쓰레기 수집(GC : Garbage Collection)에서 문제
    //      소유 객체, 소유되는 객체가 있을 때, 서로가 알고 있는 경우(레퍼런스 주소를 서로가 갖고 있는 경우)
    //      GC가 제대로 안될 수 있음
    //
    // - GC(Javascript/Java GC, iOS ARC, Flutter Scavenger)의 원리
    //   소유 객체가 소유 권한을 포기할 때 (e.g. useCase = null),
    //   소유되는 객체가 포기당했기 때문에 메모리 해제 대상(객체 제거 대상)이 됨
    //   그런데, 양쪽에서 서로가 알고 있는 경우, 한 쪽에서 포기했다고 해서,
    //   다른 한쪽은 사용하고 있다고 판단하고 있어서, 해제가 안되는 경우가 있음 ==>> 메모리 누수
    //   이걸 해결하기 위해서 finalize() 메소드를 호출하면 안됨, finalize 메소드는 Java에서 절대 호출하지 말라고 권장
    //   GC가 객체를 메모리 해제할 때 finalize 호출 후 제거를 함(GC가 finalize 호출 안할 수도 있음)
    //
    //   >> 강한 레퍼런스(Strong Reference) : 소유 객체와 소유되는 객체가 서로 레퍼런스 주소를 보유하는 경우 이 유형
    //      e.g. 이런 유형의 코드(내부 클래스)
    //      new Owner( new UseCase() )
    //      Owner(UseCase useCase) {
    //          useCase.owner = this;
    //      }
    //
    //   >> 약한 레퍼런스(Weak Reference) : 소유 객체가 소유되는 객체만 레퍼런스 주소를 보유하는 경우 이 유형
    //      e.g. 이런 유형의 코드(중첩 클래스)
    //      new Owner( new UseCase() )
    //      Owner(UseCase useCase) {
    //          //이런 유형의 코드는 하지 않음
    //          //useCase.owner = this;
    //      }
    //
    // 강한 레퍼런스의 경우 WeakReference 클래스를 통해서 표시를 해줌
    // 그러면 GC타임(GC를 수행할 때)에 두 객체를 보유하고 있는 또다른 객체가 있는지 판단 후
    // 없을 경우 GC가 이 두 객체를 제거 대상으로 봄(이것도 영 믿을 것은 못 됨)
    static abstract class App {
        App(AppInfo appInfo) {
            this.mAppInfo = appInfo;
        }

        // 앱의 정보는 외부에 보관
        private AppInfo mAppInfo;
        public AppInfo getInfo() { return mAppInfo; }
        public void setInfo(AppInfo appInfo) { this.mAppInfo = appInfo; }

        // ... 앱이 동작할 때 필요한 멤버만 정의 ...

        /**
         * 앱을 실행시킨다.
         *
         * @param args 앱이 시작될 때, 줘야할 초기 옵션 값들
         * @return 앱이 오류가 없었는지 여부
         * @author Paper.Kim
         * @since 230717
         */
        // 브릿지 패턴
        abstract boolean launch(String[] args);
        // 템플릿 메소드 패턴 : 상속 및 구현 측에서 super.launch(args); 호출 필요
//        boolean launch(String[] args) {
//            // ... 앱이 실행될 때 미리 해야할 사항 ...
//            return false;
//        }
    }

    static class AppInfo {
        AppInfo(
            Genre genre,
            boolean inPayment,
            boolean once,
            String previewImage
        ) {
            this.mGenre = genre;
            this.mInPayment = inPayment;
            this.mOnce = once;
            this.mPreviewImage = previewImage;
        }

        // 장르
        private Genre mGenre;
        // 내부에서 결제? 외부에서 결제?
        private boolean mInPayment;
        // 1회형? 구독형?
        private boolean mOnce;
        // 링크나 경로를 통한 앱의 이미지 출력용
        private String mPreviewImage;

        public Genre getGenre() { return mGenre; }
        public void setGenre(Genre genre) { this.mGenre = genre; }

        public boolean getInPayment() { return mInPayment; }
        public void setInPayment(boolean inPayment) { this.mInPayment = inPayment; }

        public boolean getOnce() { return mOnce; }
        public void setOnce(boolean once) { this.mOnce = once; }

        public String getPreviewImage() { return mPreviewImage; }
        public void setPreviewImage(String previewImage) { this.mPreviewImage = previewImage; }
    }
}

class OfficeApp extends AppStore.App {
    OfficeApp() {
        super(
            new AppStore.AppInfo(
                Genre.Common,
                false,
                false,
                // 구글번역 PNG 이미지 데이터
                "data:image/png;base64,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"
            )
        );
    }

    @Override
    boolean launch(String[] args) {
        System.out.println("Office 앱 실행");
        return true;
    }
}