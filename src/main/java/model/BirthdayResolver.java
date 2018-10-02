package model;

import java.text.DateFormat;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayResolver {
    private String date;

    public BirthdayResolver(String date) {
        this.date = date;
    }
    private boolean isRight(String[]dateParts){
        int year = Integer.parseInt(dateParts[2]);
        if(!dateParts[0].matches("^((0?[1-9])|(([12][0-9])|(3[01])))$")){
            return false;
        }
        if(!Pattern.matches("^((0?[1-9])|(1[012]))$", dateParts[1])){
            return false;
        }
        if(Pattern.matches("^\\d{4}$", dateParts[2])){
            if(year>2017) return false;
        } else {
            if(year<18) year=Integer.parseInt("20"+year);
            else year = Integer.parseInt("19"+year);
        }
        if(dateParts[1].matches("^0?2$")){
            if(dateParts[0].matches("^3[01]$")) return false;
            if(dateParts[0].equals("29")&&!((year%4 == 0 && year%100 != 0)||(year%400 == 0))) return false;
        }
        return true;
    }
    private String getNumberOfDays(String[]dateParts){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date dateNow = new Date();
        String day=dateParts[0], month=dateParts[1], year=dateParts[2];
        if(dateParts[0].matches("^\\d$")) day="0"+day;
        if(dateParts[1].matches("^\\d$")) month="0"+month;
        if(dateParts[2].matches("^\\d{2}$")){
            if(Integer.parseInt(dateParts[2])<18){
                year="20"+year;
            } else{
                year="19"+year;
            }
        }
        String nextBirthday = day+"."+month;
        String birthDay = day+"."+month+"."+year;
        try {
            String isBirthday2019 = day+"."+month+".2018";
            if(df.parse(isBirthday2019).getTime()-dateNow.getTime()<0){
                nextBirthday+=".2019";
            } else {
                nextBirthday+=".2018";
            }
            Date dateOfNextBirthday = df.parse(nextBirthday);
            Date dateOfBirth = df.parse(birthDay);
            long startTime = dateNow.getTime();
            long endTime = dateOfNextBirthday.getTime();
            long nextBirthTime = endTime - startTime;
            long daysBeforeBirthday = nextBirthTime / (1000 * 60 * 60 * 24);
            long endTime2 = dateOfBirth.getTime();
            long yearsOldTime = startTime - endTime2;
            long yearsOld = yearsOldTime / (1000 * 60 * 60 * 24);
            yearsOld /= 365;
            return "You are "+yearsOld+" years old, "+daysBeforeBirthday+" days before birthday";
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return "Invalid Date";
        }
    }
    public String timeBeforeBirthdayAndYearsOld(){
        if(Pattern.matches("^\\d{1,2}[/]\\d{1,2}[/]((\\d{2})|(\\d{4}))$", date)){
            if(isRight(date.split("/"))){
                return getNumberOfDays(date.split("/"));
            }
        }
        if(Pattern.matches("^\\d{1,2}[-]\\d{1,2}[-]((\\d{2})|(\\d{4}))$", date)){
            if(isRight(date.split("-"))){
                return getNumberOfDays(date.split("-"));
            }
        }
        return "Invalid Date";
    }
}
