package utility.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class
ObjectService {

    private static final DateFormat FORMAT = new SimpleDateFormat("MM.dd.yyyy");


    public static String trimer (String text){
        return text.replaceAll("\\s+", " ");
    }

    public static String saveReturn(String o, String errorMsg){
        if (o==null){
            ReportService.assertTrue(false, errorMsg);
        }
        return o;
    }

}
