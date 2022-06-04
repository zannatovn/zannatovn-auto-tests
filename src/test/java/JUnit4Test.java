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
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.openqa.selenium.Keys.ENTER;

public class JUnit4Test {

   @BeforeEach
   public void setup(){
       open("https://github.com/junit-team/junit4");
   }

    @Test
    public void changeBranchTest() {

        JUnit4Page.branchSelectButton()
                .shouldHave(text("main"))
                .click();
        JUnit4Page.availableBranchList()
                .find(By.linkText("fixtures"))
                .click();
        sleep(1500); //без метода sleep страница не успевает прогрузится (переключится на другую ветку)
        JUnit4Page.branchSelectButton()
                .shouldHave(text("fixtures"));
    }

    @MethodSource("releasesSearch")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Поиск релиза")
    public void releaseSearchTest(String type, String searchData) {

       JUnit4Page.releasesButton()
               .click();
       JUnit4ReleasesPage.releaseNavigationButton()
               .shouldHave(text("Releases"));
       JUnit4ReleasesPage.findReleaseInput()
               .sendKeys(searchData, ENTER);
       JUnit4ReleasesPage.releaseCards()
               .get(0).as("первый релиз в списке")
               .shouldHave(text(searchData));
    }

    static Stream<Arguments> releasesSearch() {
        return Stream.of(
                arguments("номеру", "4.13.1"),
                arguments("номеру", "4.13.2"),
                arguments("номеру", "4.13"),
                arguments("буквам", "RC 2"),
                arguments("буквам", "RC 1")
        );
    }
}
