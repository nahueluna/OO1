package io.github;

import io.github.ej14b.DateLapseV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateLapseTest {

    DatePeriod lapso1, lapso2, lapso3;

    @BeforeEach
    void setUp() {
        lapso1 = new DateLapse(LocalDate.of(2004, 1, 6),
                LocalDate.of(2024, 11, 3));
        lapso2 = new DateLapse(LocalDate.of(2024, 11, 3),
                LocalDate.of(2020, 9, 15));
        lapso3 = new DateLapseV2(LocalDate.of(2004, 1, 6), 7607);
    }

    @Test
    void sizeInDays() {
        assertEquals(lapso1.sizeInDays(), 7607);
        assertEquals(lapso2.sizeInDays(), -1510);
        assertEquals(lapso3.sizeInDays(), 7607);
    }

    @Test
    void includesDate() {
        assert(lapso1.includesDate(LocalDate.of(2024, 11, 3)));
        assert(lapso3.includesDate(LocalDate.of(2024, 11, 3)));

        assertFalse(lapso1.includesDate(LocalDate.of(2036, 1, 1)));
        assertFalse(lapso3.includesDate(LocalDate.of(2024, 11, 4)));
        assertFalse(lapso2.includesDate(LocalDate.of(2020, 9, 16)));
    }
}