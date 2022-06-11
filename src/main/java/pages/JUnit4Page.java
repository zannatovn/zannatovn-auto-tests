package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class JUnit4Page {

    public static SelenideElement branchSelectButton() {
        return $("#branch-select-menu").as("Кнопка переключения ветки в репозитории");
    }

    public static SelenideElement availableBranchList() {
        return $("#ref-list-branches").as("Список веток в репозитории");
    }

    public static SelenideElement releasesButton() {
        return $("[href='/junit-team/junit4/releases'].Link--primary").as("Кнопка 'Releases'");
    }
}