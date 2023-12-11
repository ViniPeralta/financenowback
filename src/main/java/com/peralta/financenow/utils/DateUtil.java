package com.peralta.financenow.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {

    public static LocalDate ddMMyyyytoLocalDate(String date) {

        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

}
