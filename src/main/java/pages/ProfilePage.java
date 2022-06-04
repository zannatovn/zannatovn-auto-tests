package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public static SelenideElement profileHeader() {
        return $(".Header").as("Модалка профиля");
    }

    public static SelenideElement myProfileButton() {
        return $("[aria-label='View profile and more']").as("Кнопка 'Мой профиль'");
    }

    public static SelenideElement accountName() {
        return $(".vcard-username").as("Имя пользователя");
    }
}