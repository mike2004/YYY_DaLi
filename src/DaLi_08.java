import lib.Data.ArrayTool;


import java.util.Arrays;

import static lib.Misc.IO.*;
import static lib.Misc.Randomizer.*;

public class DaLi_08 {
    public static void main(String[] args) {
        ex00();
    }
    public static void ex00(){
    }
    public static void ex01(){
        int[][] table = randomIntsTable(3, 4, 1, 10);
        ArrayTool.printTable(table, 6);
        for (int i = 0; i < table.length; i++) {
            print("Sum of row %d  = %d\n", i, ex01sumOfRow(table[i]));

        }
    }
    public static int ex01sumOfRow(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    public static void ex03(){
    }
    public static void ex04(){
    }
    public static void ex05(){
    }
    public static void ex06(){
    }
    public static void ex07(){
    }
    public static void ex08(){
    }
    public static void ex09(){
    }
    public static void ex10(){
    }
    public static void ex11(){
    }
    public static void ex12(){
    }
    public static void ex13(){
    }
    public static void ex14(){
    }
    public static void ex15(){
    }
    public static void ex16(){
    }
    public static void ex17(){
    }
    public static void ex18(){
    }
    public static void ex19(){
    }
    public static void ex20(){
    }
    public static void ex21(){
    }
    public static void ex22(){
    }
    public static void ex23(){
    }
    public static void ex24(){
    }
    public static void ex25(){
    }
    public static void ex26(){
    }
    public static void ex27(){
    }
    public static void ex28(){
    }
    public static void ex29(){
    }
    public static void ex30(){
    }
    public static void ex31(){
    }
    public static void ex32(){
    }
    public static void ex33(){
    }
    public static void ex34(){
    }
    public static void ex35(){
    }
    public static void ex36(){
    }
    public static void ex37(){
    }
}
