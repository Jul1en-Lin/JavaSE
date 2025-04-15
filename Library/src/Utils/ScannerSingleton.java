package Utils;


import java.util.Scanner;

//懒汉单例模式
public class ScannerSingleton {
    private static Scanner scanner;

    public ScannerSingleton() {
    }

    public static Scanner getScanner() {
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
