import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    @BeforeAll
    static void beforeAll(){
//        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void registration(){
        open("/automation-practice-form");
        $("#firstName").setValue("Basang");
        $("#lastName").setValue("Sokhorov");
        $("#userEmail").setValue("basangsokhorov@pochta.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9996778081");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("b").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("Снимок.PNG");
        $("#currentAddress").setValue("Местный адрес");
        $("#state").click();
        $("#react-select-3-input").val("ha").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("ka").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Basang Sokhorov"));


    }

}
