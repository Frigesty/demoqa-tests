package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        //Данные для теста
        String firstName = "Airat";
        String lastName = "Karimov";
        String email = "karimov@test.ru";
        String gender = "Male";
        String number = "9990000111";
        String month = "August";
        String year = "1996";
        String day = "2";
        String subjects0 = "Maths";
        String subjects1 = "Computer";
        String hobby0 = "Sports";
        String hobby1 = "Reading";
        String hobby2 = "Music";
        String photo = "img/images.jpg";
        String adress = "Moscow city 13";
        String state = "Haryana";
        String city = "Panipat";

        //Открытие страницы для теста
        open("/automation-practice-form");

        //Тест
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();
        $("#subjectsInput").setValue(subjects0).pressEnter();
        $("#subjectsInput").setValue(subjects1).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby0)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath(photo);
        $("#currentAddress").setValue(adress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        // Проверка теста
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(number),
                text(day + " " + month + "," + year),
                text(subjects0 + ", " + subjects1),
                text(hobby0 + ", " + hobby1 + ", " + hobby2),
                text(adress),
                text(state + " " + city)
        );

    }
}
