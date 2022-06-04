import pages.AuthPage;
import pages.JUnit4Page;
import pages.JUnit4ReleasesPage;
import pages.ProfilePage;

public final class TestPages {

    public static final AuthPage authPage = new AuthPage();
    public static final ProfilePage profilePage = new ProfilePage();
    public static final JUnit4Page jUnit4Page = new JUnit4Page();
    public static final JUnit4ReleasesPage jUnit4ReleasesPage = new JUnit4ReleasesPage();

    private TestPages(){
    }
}