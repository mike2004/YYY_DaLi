package lib.Math;

public abstract class Scales {
    public static float kilometerToMile(float km){
        return km*0.621371f;
    }
    public static float mileToKilometer(float mile){
        return mile*1.60934f;
    }
    public static float meterToFeet(float meter){
        return meter*3.28084f;
    }
    public static float feetToMeter(float feet){
        return feet * 0.3048f;
    }
    public static float kilogramToPound(float kg) { return kg / 0.45359237f; }
    public static float poundToKilogram(float pound) { return pound *  0.45359237f; }
    public static float inchToMeter(float inch){ return  inch * 0.0254f; }
    public static float meterToInch(float meter){ return  meter / 0.0254f; }
}
