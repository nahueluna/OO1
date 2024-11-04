package io.github;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements DatePeriod {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public int sizeInDays() {
        return (int)ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
    }

    public boolean includesDate(LocalDate other) {
        return (other.isEqual(this.getFrom()) || other.isEqual(this.getTo())) ||
                (other.isAfter(this.getFrom()) && other.isBefore(this.getTo()));
    }
}
