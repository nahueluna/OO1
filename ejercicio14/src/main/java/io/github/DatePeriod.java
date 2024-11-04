package io.github;

import java.time.LocalDate;

public interface DatePeriod {

    public LocalDate getFrom();

    public LocalDate getTo();

    public int sizeInDays();

    public boolean includesDate(LocalDate other);
}
