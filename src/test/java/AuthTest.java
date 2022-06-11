import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @BeforeEach
    public void setup(){
        open("https://github.com/");
    }

    @Test
    public void shouldAuthorizeTest() {

        AuthPage.mainSignInButton().click();
        AuthPage.loginInput()
                .sendKeys("testtest");
        AuthPage.passwordInput()
                .sendKeys("1234test");
        AuthPage.authButton().click();
        ProfilePage.profileHeader()
                .shouldBe(visible);
        ProfilePage.myProfileButton().click();
        AuthPage.userNickname().click();
        ProfilePage.accountName()
                .shouldHave(text("zannatovn"));
    }
}