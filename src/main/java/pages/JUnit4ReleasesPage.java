package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JUnit4ReleasesPage {

    public static SelenideElement findReleaseInput() {
        return $("[type='search']").as("Инпут поиска релизов");
    }

    public static ElementsCollection releasesCard() {
        return $$("[data-test-selector='release-card']");
    }

    public static SelenideElement releaseNavigationButton() {
        return $("[data-selected-links='repo_releases /junit-team/junit4/releases']").as("Кнопка навигации на странице 'Релизы'");
    }
}