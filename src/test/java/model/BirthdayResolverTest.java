package model;

import org.junit.Assert;
import org.junit.Test;

public class BirthdayResolverTest {
    @Test
    public void timeBeforeBirthdayAndYearsOldGoodRequest() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("12/07/2017");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertNotEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldGoodRequestOneNumber() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("2/7/17");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertNotEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldGoodRequestOtherDelimiters() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("2-7-17");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertNotEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldBadRequestDay() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("44/12/1999");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldBadRequestMonth() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("23/34/1999");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldBadRequestYear() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("23/12/2020");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldBadRequest29February() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("29/2/2017");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertEquals("Invalid Date", actual);
    }

    @Test
    public void timeBeforeBirthdayAndYearsOldBadRequestDifferentDelimiters() {
        BirthdayResolver birthdayResolver = new BirthdayResolver("23-12/1999");
        String actual = birthdayResolver.timeBeforeBirthdayAndYearsOld();
        Assert.assertEquals("Invalid Date", actual);
    }
}