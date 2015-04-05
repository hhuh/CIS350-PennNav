<<<<<<< HEAD
package edu.upenn.projectcis350.cis350_pennnav;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.JsonReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Harrison on 4/5/2015.
 */
public class Reader {

    String FILENAME = "class.json";
    ArrayList<String> JSONList = new ArrayList<String>();

    public Reader(InputStream is){

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(is)));
        while(input.hasNextLine()){
            String line = input.nextLine();
            JSONList.add(line);
        }
        input.close();
    }

    public ArrayList<String> readAll(){
        return JSONList;
    }

    static public String getAttribute(String line, String attributeType){
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject)parser.parse(line);
            String product = (String)obj.get(attributeType);
            return product;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public ArrayList<String> getListOfSameAttribute(ArrayList<String> list, String attributeType, String attribute){

        ArrayList<String> reducedList = new ArrayList<String>();

        for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            String attributeMatch = getAttribute(line, attributeType);
            if(attributeMatch.equalsIgnoreCase(attribute)){
                reducedList.add(line);
            }
        }

        return reducedList;
    }
}
=======
package edu.upenn.projectcis350.cis350_pennnav;

import android.util.JsonReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Harrison on 4/5/2015.
 */
public class Reader {

    String FILENAME = "class.json";
    ArrayList<String> JSONList = new ArrayList<String>();

    public Reader(){

        try {
            Scanner input = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            while(input.hasNextLine()){
                String line = input.nextLine();
                JSONList.add(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }

    public ArrayList<String> readAll(){
        return JSONList;
    }

    public String getAttribute(String line, String attributeType){
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject)parser.parse(line);
            String product = (String)obj.get(attributeType);
            return product;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getListOfSameAttribute(ArrayList<String> list, String attributeType, String attribute){

        ArrayList<String> reducedList = new ArrayList<String>();

        for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            String attributeMatch = getAttribute(line, attributeType);
            if(attributeMatch.equalsIgnoreCase(attribute)){
                reducedList.add(line);
            }
        }

        return reducedList;
    }
}
>>>>>>> e26f5b0c5d7b76db095419bd55d5a7a77690b517
