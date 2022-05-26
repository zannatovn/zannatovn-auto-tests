import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @Test
    public void shouldAuthorizeTest() {

        //1. Открыть страницу https://github.com/
        open("https://github.com/");

        //2. Кликнуть на кнопку 'Sign in'
        $("[href='/login']").click();

        //3. Заполнить поля логина и пароля
        $("[id='login_field']").sendKeys("testtest");
        $("[id='password']").sendKeys("1234test");

        //4. Нажать кнопку 'Sign in'
        $(".js-sign-in-button").click();

        //5. Проверить авторизацию
        $(".Header").shouldBe(visible);

        //6. Открыть меню
        $("[aria-label='View profile and more']").click();

        //7. Нажать на пункт 'Your profile'
        $(byText("Your profile")).click();

        //8. Проверить, что отображается личный профиль
        $(".vcard-username").shouldHave(text("zannatovn"));
    }
}