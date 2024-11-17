package com.lingapms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateService {

    public String getFormattedDate() {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        return currentDate.format(formatter);
    }
}
