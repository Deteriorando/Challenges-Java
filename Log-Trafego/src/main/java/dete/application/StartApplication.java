package dete.application;

import dete.Classes.Log.LogEntry;
import dete.Classes.Log.LogProcessor;

import java.util.Scanner;

/*  TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
 *  click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 */
public class StartApplication {
    static void main() {
        Scanner scan = new Scanner(System.in);
        while (true){
            int index = scan.nextInt();

            switch (index){
                case 1 -> insertLog();
                case 2 -> getLog();
                case 3 -> performance();
                default -> throw new IllegalStateException("Unexpected value: " + index);
            }
        }
    }

    public static void insertLog(){
        new LogEntry().insertLog();
    }

    public static void getLog(){
        System.out.println(LogProcessor.getInstance().getLogEntries());
    }

    public static void filter(){
        System.out.println("Escolha um tipo de filtro!");
        System.out.println("[ 1 ] Filtro por ID");
        System.out.println("[ 2 ] Filtro por Status");
        System.out.println("[ 3 ] Filtro por tempo de resposta");
    }

    public static void performance(){
        System.out.println("Perfomace: "
            + LogProcessor.getInstance().performanceCalculator()
        );
    }

}
