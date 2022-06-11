import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.JUnit4Page;
import pages.JUnit4ReleasesPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.openqa.selenium.Keys.ENTER;

@Owner("zannatovn")
@Feature("Проверка репозитория Junit4")
public class JUnit4Test {

   @BeforeEach
   public void setup() {
       step("Открыть страницу https://github.com/junit-team/junit4", () -> {
           open("https://github.com/junit-team/junit4");
       });
   }

    @Test
    @Story("Смена ветки")
    @DisplayName("Проверка выбора ветки")
    public void changeBranchTest() {

        step("Нажать на название текущей ветки", () -> {
            JUnit4Page.branchSelectButton()
                    .shouldHave(text("main"))
                    .click();
        });

        step("Переключиться на другую ветку", () -> {
            JUnit4Page.availableBranchList()
                    .find(By.linkText("fixtures"))
                    .click();
        });

        step("Проверить, что название текущей ветки сменилось на выбранную", () -> {
            sleep(1500); //без метода sleep страница не успевает прогрузится (переключится на другую ветку)
            JUnit4Page.branchSelectButton()
                    .shouldHave(text("fixtures"));
        });
    }

    @Story("Проверка поиска релизов")
    @MethodSource("releasesSearch")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Поиск релиза")
    public void releaseSearchTest(String type, String searchData) {

       step("Нажать на кнопку 'Releases' и проверить, что открылась страница с релизами", () -> {
           JUnit4Page.releasesButton()
                .click();
           JUnit4ReleasesPage.releaseNavigationButton()
                .shouldHave(text("Releases"));
       });

       step("Ввести в строку поиска название релиза и нажать Enter", () -> {
           JUnit4ReleasesPage.findReleaseInput()
                .sendKeys(searchData, ENTER);
       });

       step("В результатах поиска отображаются релизы соответствующие поисковому запросу", () -> {
           JUnit4ReleasesPage.releaseCards()
                .get(0).as("первый релиз в списке")
                .shouldHave(text(searchData));
       });
    }

    static Stream<Arguments> releasesSearch() {
        return Stream.of(
                arguments("по буквам и номеру", "JUnit 4.13.2"),
                arguments("по номеру", "4.13.2"),
                arguments("по буквам", "Beta 2")
        );
    }
}
