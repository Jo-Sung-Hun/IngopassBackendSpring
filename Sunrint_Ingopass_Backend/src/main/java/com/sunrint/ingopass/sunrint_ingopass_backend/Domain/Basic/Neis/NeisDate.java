package com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis;

import lombok.Builder;

import java.util.Objects;

public class NeisDate extends Object{
    private Integer year;
    private Integer month;
    private Integer day;
    @Builder
    public NeisDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public NeisDate() {
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "NeisDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NeisDate)) return false;
        NeisDate date = (NeisDate) o;
        return Objects.equals(getYear(), date.getYear()) && Objects.equals(getMonth(), date.getMonth()) && Objects.equals(getDay(), date.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMonth(), getDay());
    }
}
