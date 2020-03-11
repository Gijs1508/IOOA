package week1_files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Fileio {
    public static void main(String[] args) {
        String dirPath = "C:/Users/cross/Desktop/";
        File dir = new File(dirPath);
        File[] files = dir.listFiles();


        // List all files in the directory
        for (File fileX : files){
            System.out.println(fileX.getName());
        }

        // read data from names.txt
        File filePath = new File(dirPath + "namen.txt");

        ArrayList<String> nameList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                nameList.add(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        for(int x = 0; x < nameList.size(); x++){
            System.out.println(nameList.get(x));
        }
    }
}
