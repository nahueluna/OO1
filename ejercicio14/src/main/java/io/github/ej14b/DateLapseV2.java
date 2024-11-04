package io.github.ej14b;

import io.github.DatePeriod;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseV2 implements DatePeriod {
    private LocalDate from;
    private int sizeInDays;

    public DateLapseV2(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    @Override
    public LocalDate getFrom() {
        return this.from;
    }

    @Override
    public LocalDate getTo() {
        return getFrom().plusDays(this.sizeInDays);
    }

    @Override
    public int sizeInDays() {
        return this.sizeInDays;
    }

    @Override
    public boolean includesDate(LocalDate other) {
        return (other.isEqual(this.getFrom()) || other.isEqual(this.getTo())) ||
                (other.isAfter(this.getFrom()) && other.isBefore(this.getTo()));
    }
}
