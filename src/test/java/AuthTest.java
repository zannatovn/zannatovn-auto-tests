import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("zannatovn")
@Feature("GitHub")
public class AuthTest {

    @BeforeEach
    public void setup() {

        step("Открыть страницу https://github.com", () -> {
            open("https://github.com/");
        });
    }

    @Test
    @Story("Авторизация")
    @DisplayName("Успешная авторизация")
    public void shouldAuthorizeTest() {

        step("Нажать на кнопку 'Sign In'", () -> {
            AuthPage.mainSignInButton()
                    .click();
        });

        step("Заполнить поля логина и пароля и нажать кнопку авторизации", () -> {
            AuthPage.loginInput()
                    .sendKeys("testtest");
            AuthPage.passwordInput()
                    .sendKeys("1234test");
            AuthPage.authButton()
                    .click();
        });

        step("Проверить, что появился верхний банер", () -> {
            ProfilePage.profileHeader()
                    .shouldBe(visible);
        });

        step("Открыть выпадающее меню", () -> {
            ProfilePage.myProfileButton()
                    .click();
        });

        step("Нажать на кнопку 'Your profile' и проверить имя пользователя", () -> {
            AuthPage.userNickname()
                    .click();
            ProfilePage.accountName()
                    .shouldHave(text("zannatovn"));
        });
    }
}