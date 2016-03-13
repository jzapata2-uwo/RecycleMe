package com.nHacks.recycleMe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

/**
 * Created by Juan Zapata on 3/13/2016.
 */
public class Helper_FileManager {

    public static String fileName_container = "container.jpg";
    public static String fileName_paper = "paper.jpg";
    public static String fileName_organic = "organic.jpg";
    public static String fileName_landfill = "landfill.jpg";

    public static String path = "C:\\Users\\Juan Zapata\\Documents\\GitHub\\NHacks2016\\app\\resources\\drawlable\\";

    public static File root = new File(Helper_FileManager.path);

    public static Bitmap bitmap_container = BitmapFactory.decodeFile(Helper_FileManager.root + Helper_FileManager.fileName_container);

    public static Bitmap bitmap_paper;
    public static Bitmap bitmap_organic;
    public static Bitmap bitmap_landfill;

    public Helper_FileManager(){

//        File file = new File(path+fileName_container);

//        bitmap_container = (Bitmap) file;
//        bitmap_paper =
//        bitmap_organic =
//        bitmap_landfill =

    }
}
