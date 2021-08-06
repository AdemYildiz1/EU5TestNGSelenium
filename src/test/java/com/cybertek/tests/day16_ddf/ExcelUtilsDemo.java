package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

 //we'll move our VyTrack test data excel file to inside our frame work
    @Test
    public void readExcelFile(){
        //Create an object from ExcelUtil
        // it accept two argument
        //Argument 1: location of the file(path)
        //Argument 2 sheet tha we want to open

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //How many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all columns name
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //get all data in list of map
        List<Map<String, String>> dataList = qa3short.getDataList(); //it makes list based on rows/ each row in excel is a map list

        for (Map<String, String> onerow : dataList) { //it gets rows like row 1, 2, 3 but value is not regular order on the row it mix
            System.out.println(onerow);
        }

        //get nona as a value
        //go 3rd row/map(don't count firs row->title(keys name) but use index from 0, then get the value based on key
        dataList.get(2).get("firstname");
        System.out.println(dataList.get(2).get("firstname"));//first get is the list method, second get is the map method

        //get Harber as a value
        System.out.println(dataList.get(8).get("lastname"));

        //get all data in 2dimensional array
        String[][]dataArray=qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));

    }
}
