import lib.Math.Algebra;
import lib.Math.Extras;
import lib.Math.Scales;

import static lib.Misc.IO.*;

public class DaLi_06 {
    public static void main(String[] args) {

        ex09();

    }

    public static void ex00() {

    }
    public static void ex01() {
        for (int i = 0; i < 100; i++) {
            printf("%7d", Algebra.pentagonalNumber(i) );
            if  (i%10 == 9 )println("");
        }
    }
    public static void ex02() {
        println(Algebra.sumOfDigits(225416222));
    }
    public static void ex03() {
        println(Extras.isPalindrome(12321));
        println(Extras.isPalindrome(1421));
    }
    public static void ex04() {
        println(Extras.reverse(1234));
    }
    public static void ex05() {
        println((int)Extras.max(5,6,7));
    }
    public static void ex06(int lines) {
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                printf("%3d",j);
            }
            println("");
        }
    }
    public static void ex07() {
        DaLi_02.ex21();
    }
    public static void ex08() {
        printf("%s %s %s %s %s\n", "Miles", "Kilometers", "|", "Kilometers", "Miles");
        for (int i = 1, k=20; i <= 10; i++, k+=5) {
            printf("%-8d %-7.3f %s %-10d %.3f\n",  i, Scales.mileToKilometer(i),"|", k, Scales.kilometerToMile(k));
        }
    }
    public static void ex09() {
        printf("%s %s %3s %s %5s\n", "Kilogram", "Pound", "|", "Pound", "Kilogram");
        for (int k = 1, p=20; k <= 10; k+=2, p+=5) {
            printf("%-8d %-7.3f %s %-5d %.3f\n",  k, Scales.kilogramToPound(k),"|", p, Scales.poundToKilogram(p));
        }

    }
    public static void ex10() {

    }
    public static void ex11() {

    }
    public static void ex12() {

    }
    public static void ex13() {

    }
    public static void ex14() {

    }
    public static void ex15() {

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
    public static void ex34() {

    }
    public static void ex35() {

    }
    public static void ex36() {

    }
    public static void ex37() {

    }
    public static void ex38() {

    }
    public static void ex39() {

    }
}
