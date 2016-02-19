package com.example.bertadevant.littlewins;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Created by bertadevant on 2/11/16.
 */
public class DayClass extends EntriesClass {

    protected String day_Date;
    private ArrayList<EntriesClass> day_Entries;

    DayClass()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        day_Date = df.format(c.getTime());
    }

    protected void setDay_Entry(EntriesClass entry)
    {
        day_Entries.add(entry);
    }

    protected int getDayResult()
    {
        int dayResults = 0, count = 0;
        for (int i=0; i<day_Entries.size(); i++ )
        {
            count += day_Entries.get(i).getEntry_level();
        }
        if (count/day_Entries.size() > 0 && count/day_Entries.size() < 1 )
            dayResults = 0;
        else if (count/day_Entries.size() > 1 && count/day_Entries.size() < 2)
            dayResults = 1;
        else if (count/day_Entries.size() > 2)
            dayResults = 2;
        else if (count == 0)
            dayResults = 0;

        return dayResults;
    }

    protected void endOfDay()
    {
        //Save on file the Date, Entries and dayResult
    }

    /*
    I made day_Entries an array of EntriesClass. That means that when I entry is done and stored in the DayClass file
    It should be passed on as an Entry object
     */

}
