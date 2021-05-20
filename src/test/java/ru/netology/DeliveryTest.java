package ru.netology;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }


    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        val validUser = DataGenerator.Registration.generateUser("ru");
//        val daysToAddForFirstMeeting = 4;
//        val firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
//        val daysToAddForSecondMeeting = 7;
//        val secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
        $("[data-test-id='city'] .input__control").setValue(validUser.getRandomCity());
        $("[data-test-id='date'] .input__control").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id='date'] .input__control").sendKeys(Keys.DELETE);
        $("[data-test-id='date'] .input__control").setValue(DataGenerator.generateDate());
        $("[data-test-id='name'] .input__control").setValue(validUser.getRandomName());
        $("[data-test-id='phone'] .input__control").setValue(validUser.getRandomPhone());
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Запланировать")).click();
        $(".notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(15));
    }

}