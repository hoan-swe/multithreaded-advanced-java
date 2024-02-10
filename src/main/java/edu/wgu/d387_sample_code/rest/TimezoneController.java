package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin
public class TimezoneController {

    @GetMapping("/showTime")
    public String showTime() {

        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Phoenix");
        ZoneId zUniversal = ZoneId.of("UTC");

        ZoneId zoneId = ZoneId.systemDefault(); // Local machine's timezone id
        LocalDateTime localDateTime = LocalDateTime.now(); // Local machine's time
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId); // Local machine's timezone

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM d, u");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh:mm a z");
        String date = localDateTime.format(formatter1);

        // Convert local time to Eastern time
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        String easternTime = zonedDateTimeEastern.format(formatter2);

        // Convert local time to Mountain time
        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        String mountainTime = zonedDateTimeMountain.format(formatter2);

        // Convert local time to Universal time
        ZonedDateTime zonedDateTimeUniversal = zonedDateTime.withZoneSameInstant(zUniversal);
        String universalTime = zonedDateTimeUniversal.format(formatter2);

        return new String(date + " at " + easternTime + " | " + mountainTime + " | " + universalTime);
    }
}
