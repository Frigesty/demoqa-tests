package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class PracticeFormTests {

    RegistrationForm registrationForm = new RegistrationForm();
    Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        //Данные для теста
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Male",
                number = faker.numerify("##########"),
                month = "August",
                year = "1996",
                day = "26",
                subject = "Maths",
                hobby = "Sports",
                folder = "img/",
                photo = "images.jpg",
                state = "Haryana",
                city = "Panipat",
                address = faker.address().fullAddress();


        String expectedFullName = format("%s %s", firstName, lastName);
        String expectedBirthdayDate = format("%s %s,%s",day, month,year);
        String expectedStateAndCity = format("%s %s", state, city);


        //Тест
       registrationForm.openPage()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(email)
               .setGender(gender)
               .setNumber(number)
               .setBirthDate(day, month, year)
               .setSubject(subject)
               .setHobby(hobby)
               .setPhoto(folder + photo)
               .setAddress(address)
               .setState(state)
               .setCity(city)
               .setSubmit()
               .checkForm("Student Name", expectedFullName)
               .checkForm("Student Email", email)
               .checkForm("Gender", gender)
               .checkForm("Mobile", number)
               .checkForm("Date of Birth", expectedBirthdayDate)
               .checkForm("Subjects", subject)
               .checkForm("Hobbies", hobby)
               .checkForm("Picture", photo)
               .checkForm("Address", address)
               .checkForm("State and City",expectedStateAndCity);

    }
}
