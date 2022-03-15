package helpz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadSave {

    public static void CreateFile(){

        File txtFile = new File("src/main/resources/Maps/testTextFile.txt");
        try {
            txtFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void WriteToFile(File f, int[] idArr){
        try {
            PrintWriter pw = new PrintWriter(f);
            for(Integer i : idArr){
                pw.println(i);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> ReadFromFile(File file){
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                list.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
            return list;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int[][] getLevelData(String name){
        File lvlFile = new File("src/main/resources/Maps/"+name+".txt");
        if (lvlFile.exists()){
            ArrayList<Integer> list = ReadFromFile(lvlFile);
            return utilz.ArrayListTo2Dint(list,10,15);
        }
        else {
            System.out.println("File: " + name + " does not exist!");
            return null;
        }
    }

    public static void CreateLevel(String name, int[] idArr){
        File newLevel = new File("src/main/resources/Maps/" + name + ".txt");
        if (newLevel.exists()){
            System.out.println("File " + name + " already exists!");
        }else {
            try {
                newLevel.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WriteToFile(newLevel,idArr);
    }


    public static void saveLevel(String name, int[][] idArr){
        File levelFile = new File("src/main/resources/Maps/" + name + ".txt");
        if (levelFile.exists()){
            WriteToFile(levelFile,utilz.TwoDto1DintArr(idArr));
        }
        else {
            System.out.println("Level does not exist!");
            return;
        }
    }


}
