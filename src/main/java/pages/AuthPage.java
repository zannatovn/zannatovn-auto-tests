package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    public static SelenideElement mainSignInButton() {
        return $("[href='/login']").as("Кнопка логина");
    }

    public static SelenideElement loginInput() {
        return $("#login_field").as("Инпут ввода логина");
    }

    public static SelenideElement passwordInput() {
        return $("#password").as("Инпут ввода пароля");
    }

    public static SelenideElement authButton() {
        return $(".js-sign-in-button").as("Кнопка авторизации");
    }

    public static SelenideElement userNickname() {
        return $(byText("Your profile")).as("Имя пользователя");
    }
}