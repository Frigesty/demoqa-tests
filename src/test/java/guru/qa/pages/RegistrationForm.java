package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import guru.qa.pages.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    Calendar calendar = new Calendar();

    // locators
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            photoInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput =$("#state"),
            cityInput = $("#city"),
            submitInput =$("#submit"),
            resultsTableLoc = $(".table-responsive");


    // action
    public RegistrationForm openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationForm setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationForm setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationForm setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationForm setGender(String gender) {
        genderInput.$(byText(gender)).click();

        return this;
    }

    public RegistrationForm setNumber(String number) {
        numberInput.setValue(number);

        return this;
    }

    public RegistrationForm setBirthDate (String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationForm setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }
    public RegistrationForm setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();

        return this;
    }
    public RegistrationForm setPhoto (String photo) {
        photoInput.uploadFromClasspath(photo);
        return this;
    }
    public RegistrationForm setAddress (String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationForm setState (String state) {
        stateInput.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationForm setCity (String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationForm setSubmit (){
        submitInput.click();
        return this;
    }
    public RegistrationForm checkForm (String fieldName, String value) {
        resultsTableLoc.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}
