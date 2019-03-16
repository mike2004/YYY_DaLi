import lib.Data.ArrayManip;
import lib.Math.NumberConverter;
import lib.Misc.FileIO;
import lib.Misc.FileIn;
import lib.Misc.FileOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import static lib.Misc.IO.*;

public abstract class DaLi_12 {

    public static void main(String[] args) {
        ex15();

    }

    public static void ex00() {
    }
    public static void ex01() {//NumberFormatException
        try {
            auxp.ch10.Calculator.main("2 / 2");
        }catch (NumberFormatException | InputMismatchException ex){
            println("Ilegal arguments");
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    public static void ex02() {//ArrayIndexOutOfBoundsException
        String[] strs = {"1", "2", "3", "4" };
        int idx = scanInt("Enter 1-4:");

        try {
            print(strs[idx]);
        }catch (IndexOutOfBoundsException ex){
            println("Catch IndexOutOfBoundsException:");
            ex.printStackTrace();
        }
    }
    public static void ex03() {//InputMismatchException
        try{
            ex02();
        }catch (InputMismatchException ex){
            println("Catch InputMismatchException:");
            ex.printStackTrace();
        }
    }
    public static void ex04() {//IllegalArgumentException
    }
    public static void ex05() {
    }
    public static void ex06() {//NumberFormatException
        try {
            print(NumberConverter.hexToDec("AAAG"));
        }catch (NumberFormatException e){
            print("Bad hex " + e.getMessage());
        }
    }
    public static void ex07() {
    }
    public static void ex08() {
    }
    public static void ex09() {
    }
    public static void ex10() {
    }
    public static void ex11() {//Remove text
        String argss = "john src/auxp/ch12/e11.txt";
        String[] args = argss.split(" ");
        Scanner scan = null;

        StringBuilder filtered = new StringBuilder();

        File f1 = new File(args[1]);
        try {
            scan = new Scanner(f1);
            while(scan.hasNextLine()){
                filtered.append(scan.nextLine().replaceAll("john", "")).append("\n");
            }
        } catch (FileNotFoundException e) {
            println("File Not Found: ");
            e.printStackTrace();
        } finally {
            try {
                assert scan != null;
                scan.close();
            } catch (NullPointerException e) {
                println("NullPointerException: ");
                e.printStackTrace();
            }
        }

        try (PrintWriter pw = new PrintWriter(f1)) {
            pw.print(filtered);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void ex12() {//Reformat Java source code
        String file = "src/auxp/ch12/e12.java";
        File f1 = new File (file);
        String str = "";
        try {
            str = FileIn.fileToString(f1);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (PrintWriter pw = new PrintWriter(f1)) {
            pw.print(str.toString().replaceAll("[{]" + "\n", "\n{\n"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void ex13() {//Count characters, words, and lines in a file
        int lines=0, chars=0, words=0;

        String file = "src/auxp/ch12/e13.txt";
        File f1 = new File (file);
        StringBuilder str = new StringBuilder();
        try(Scanner scan = new Scanner(f1)){
            while(scan.hasNextLine()) {
                lines++;
                str.append(scan.nextLine()).append("\n");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        chars = str.length();
        words = str.toString().split(" ").length;

        print("chr: " + chars + "\nwords: " + words + "\nlines: " + lines);
    }
    public static void ex14() {//Reading in a sorted file
        String file = "src/auxp/ch12/e14.txt";
        File f1 = new File (file);
        String str="";
        try {
            str = FileIn.fileToString(f1);
        }catch (FileNotFoundException e){
            println("FileNotFoundException:");
            e.printStackTrace();
        }
        print(str);

        try {
            int n = FileIn.indexOfFirstOccurrence(f1, "Benjamin");
            println(n);
        }catch (FileNotFoundException e){
            println("FileNotFoundException:");
            e.printStackTrace();
        }
        FileIO.sort(f1);
        try {
            int n = FileIn.binarySearch(f1, "Benjamin");
            println(n);
        }catch (FileNotFoundException e){
            println("FileNotFoundException:");
            e.printStackTrace();
        }
    }
    public static void ex15() {//Writing in a sorted file
        File f1 = new File ("src/auxp/ch12/e15.txt");
        String[] f,g;
        try {
            f = FileIn.fileToArray(f1);
            g = new String[f.length+1];
            System.arraycopy(f, 0, g, 0, f.length);
            g[f.length]="Franky";
            ArrayManip.bubbleSort(g);
            FileOut.printOnFile(f1, g);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void ex16() {
    }
    public static void ex17() {
    }
    public static void ex18() {
    }
    public static void ex19() {
    }
    public static void ex20() {
    }
    public static void ex21() {
    }
    public static void ex22() {
    }
    public static void ex23() {
    }
    public static void ex24() {
    }
    public static void ex25() {
    }
    public static void ex26() {
    }
    public static void ex27() {
    }
    public static void ex28() {
    }
    public static void ex29() {
    }
    public static void ex30() {
    }
    public static void ex31() {
    }
    public static void ex32() {
    }
    public static void ex33() {
    }
}