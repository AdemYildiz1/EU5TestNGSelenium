package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    //Singleton class will have private constructor
    //it means other class can not create object of this class

    //basically in this way my drive will be singleton design pattern : it will return the same version of object/drive all the time
    //this example is applied in Driver class in utilities package so we can have benefits to use all the time same driver object

    private Singleton(){} //Private constructor

    private static String str;

    public static String getInstance(){

        //if str has no value, initialize it and return
        if(str==null){
            System.out.println("str is null. assigning value it");
            str="some value";
        }else{
            //if it has value just return it
            System.out.println("it has value, just returning it");
        }
        return str;

    }
}
