package com.example.bertadevant.littlewins;

/**
 * Created by bertadevant on 2/11/16.
 */
public class EntriesClass {

    private int entry_ID;
    private int entry_level;
    private String entry_String;

    EntriesClass(int ID, int level, String name) {
        entry_ID = ID;
        entry_level = level;
        entry_String = name;
        //prints the new entry on a json file
    }


    EntriesClass() {
        System.out.print("Cannot enter an empty entry");
    }

    protected int getEntry_ID() {
        return entry_ID;
    }

    protected int getEntry_level() {
        return entry_level;
    }

    protected String getEntry_String() {
        return entry_String;
    }

    protected void setEntry_ID(int ID) {
        entry_ID = ID;
    }

    protected void setEntry_level(int level)
    {
        entry_level = level;
    }
    protected void setEntry_String(String name)
    {
        entry_String = name;
    }

    //Level 0 : bad
    //level 1 : normal
    //level 2 : good

    /*
    //what I am doing?
    Creating Objects for each entry every time we load the app, the objects will be created either by the user
    (new entry button) or by reading the json files with past stored objects
     */


}
