package utility.services;

import utility.PropertyReader;

import java.io.*;
import java.util.*;

import static utility.services.ReportService.assertTrue;


public class FileReaderService {
    public static final String PROP_PATH = "src/test/resources/properties/";
    public static final String PROP_PATH_AUT = "properties/";

    public static List<String> listReader(String fileLocation){
        BufferedReader in;
        List<String> myList = new ArrayList<>();
        try {
            in = new BufferedReader(new FileReader(PROP_PATH+fileLocation));
            String str;
            while ((str = in.readLine()) != null) {
                myList.add(str);
            }
            in.close();
        }
        catch (IOException e){
            assertTrue(false, "Catch an exception " + e);
        }

        return myList;
    }

    public static Map<String, String> getMap(String fileLocation) {
        PropertyReader propertyReader = new PropertyReader(PROP_PATH_AUT + fileLocation);
        return new HashMap(propertyReader.getProperties());
    }

    public static Map<String,String> getMap(String fileLocation, String delimiter){
        try {
            Map<String, String> map = new HashMap<>();
            BufferedReader in = new BufferedReader( new FileReader(PROP_PATH+fileLocation));
            String line;
            while ((line = in.readLine()) !=null){
                String parts[] = line.split(delimiter);
                map.put(parts[0],parts[1]);
            }
            in.close();
            return map;
        }
        catch (IOException e){
            assertTrue(false, "Catch an exception " + e);
            return null;
        }

    }
}