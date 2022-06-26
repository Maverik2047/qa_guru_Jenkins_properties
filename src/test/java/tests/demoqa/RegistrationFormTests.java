package tests.demoqa;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    @Test
    @Tag("formTest")
    @Owner("Maverik2047")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Сборка в Jenkins")
    @Story("Создание новой сборки в Jenkins")
    @Link(name = "Demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Fill out the registration form")
    void successfulTest() {
        String fName = "Mark";
        String lName = "Born";
        String userEmail = "Born@gloom.snail";

        step("Открыть форму регистрации студента", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });
        step("Заполнить поле Имя и Фамилия", () -> {
            $("#firstName").setValue(fName);
            $("#lastName").setValue(lName);
        });
        step("Заполнить поле Email", () -> {
            $("#userEmail").setValue(userEmail);
        });
        step("Выбрать пол студента", () -> {
            $("#genterWrapper").$(byText("Male")).click();
        });
        step("Ввести номер моб.телефона", () -> {
            $("#userNumber").setValue("9500267340");
        });
        step("Ввести дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("December");
            $(".react-datepicker__year-select").selectOption("1988");
            $("[aria-label='Choose Saturday, December 10th, 1988']").click();
        });
        step("Заполнить поле предметной области", () -> {
            $("#subjectsInput").sendKeys("m");
            $(byText("Maths")).click();
        });
        step("Выбрать хобби", () -> {
            $("#hobbiesWrapper").$(byText("Sports")).click();
        });
        step("Загрузить фото", () -> {
            $("#uploadPicture").uploadFromClasspath("test.png");
        });
        step("Ввести адрес,выбрать штат и город", () -> {
            $("#currentAddress").setValue("Palm Street");
            $("#state").click();
            $(byText("NCR")).click();
            $("#city").click();
            $(byText("Noida")).click();
        });
        step("Нажать кнопку подтвердить", () -> {
            $("#submit").click();
        });

        step("Сверить результаты заполненной формы регистрации", () -> {
            $(".modal-content").shouldHave(text("Mark"), text("Born"), text("Born@gloom.snail"),
                    text("Male"), text("9500267340"), text("10 December,1988"),
                    text("test.png"), text("Palm Street"),
                    text("NCR"), text("Noida"), text("Thanks for submitting the form"));
        });


    }
}

