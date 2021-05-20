package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate() {
        LocalDate date = LocalDate.now().plusDays(3);
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName(String locate) {
        Faker faker = new Faker(new Locale("ru"));

        return faker.name().fullName();
    }

    public static String generateCity(String locate) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.address().city();
    }

    public static String generatePhone(String locate) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().cellPhone();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateName("ru"), generateCity("ru"), generatePhone("ru"));
        }
    }

    @Value
    public static class UserInfo {
        String randomName;
        String randomCity;
        String randomPhone;
    }

}
