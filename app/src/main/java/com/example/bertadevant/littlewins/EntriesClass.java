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

    public int getEntry_ID() {
        return entry_ID;
    }

    public int getEntry_level() {
        return entry_level;
    }

    public String getEntry_String() {
        return entry_String;
    }

    public void setEntry_ID(int ID) {
        entry_ID = ID;
    }

    public void setEntry_level(int level)
    {
        entry_level = level;
    }
    public void setEntry_String(String name)
    {
        entry_String = name;
    }


    /*
    //what I am doing?
    Creating Objects for each entry every time we load the app, the objects will be created either by the user
    (new entry button) or by reading the json files with past stored objects
     */


}
