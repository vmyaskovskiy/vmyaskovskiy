package ru.job4j.lsp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    private String createDateStr;
    private String expaireDateStr;
    Date d = new Date();

    public DateFormat(String createDate, String expaireDate) {
        this.createDateStr = createDate;
        this.expaireDateStr = expaireDate;
    }



    public Date parsDate(String data) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            d = sdf.parse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }



    public int daysBetween(Date d1, Date d2)  {
        return (int)( (d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
    }

    public double procExpaireDate() {
        Date createDate = parsDate(this.createDateStr);
        Date expaireDate = parsDate(this.expaireDateStr);
        int fs = daysBetween(expaireDate, createDate);
        int esd = daysBetween(expaireDate, new Date());
        return ((100*esd)/fs);
    }

    public boolean endDate() {
        Date expaireDate = parsDate(this.expaireDateStr);
        return (expaireDate.getTime() < new Date().getTime());
    }
}
