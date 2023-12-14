import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @BeforeAll
    static void beforeAll(){
//        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;

    }
    @Test
    void registration(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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
        $("#react-select-3-input").val("har").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("ka").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Basang Sokhorov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("basangsokhorov@pochta.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9996778081"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("29 June,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Снимок.PNG"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Местный адрес"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));



    }

}
