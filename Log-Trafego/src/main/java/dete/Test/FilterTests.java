package dete.Test;

import dete.Classes.Enums.Status;
import dete.Classes.Log.LogEntry;
import dete.Classes.Log.LogProcessor;
import dete.Classes.Net.IP;
import dete.Classes.Net.Response;
import java.util.ArrayList;

public class FilterTests {
    static void main() {
        LogProcessor log = LogProcessor.getInstance();

        log.addEntriesLog(new LogEntry(
                2,
                new IP("198.132.234.60"),
                new Response(5L),
                Status.ERROR
        ));

        log.addEntriesLog(new LogEntry(
                1,
                new IP("198.132.234.60"),
                new Response(2L),
                Status.SUCCESS
        ));


        log.addEntriesLog(new LogEntry(
                3,
                new IP("198.142.234.60"),
                new Response(16L),
                Status.TIMEOUT
        ));

        log.addEntriesLog(new LogEntry(
                5,
                new IP("198.122.125.20"),
                new Response(5L),
                Status.SUCCESS
        ));

        log.addEntriesLog(new LogEntry(
                6,
                new IP("198.122.125.20"),
                new Response(10L),
                Status.SUCCESS
        ));

        log.addEntriesLog(new LogEntry(
                7,
                new IP("198.122.125.20"),
                new Response(100L),
                Status.SUCCESS
        ));



        LogEntry alvo = new LogEntry(
                1,
                new IP("198.132.234.60"),
                new Response(2L),
                Status.SUCCESS
        );

        ArrayList<LogEntry> filterMs = log.filterByMs(new Response(5L));
        ArrayList<LogEntry> filterStatus = log.filterByStatus(Status.SUCCESS);
        ArrayList<LogEntry> filterAnomaly = log.filterAnomaly(alvo);

        System.out.println("Filtragem por Response\n\n");
        for (LogEntry l : filterMs){
            System.out.println(l);
        }

        System.out.println("Filtragem por Status\n\n");
        for (LogEntry l : filterStatus){
            System.out.println(l);
        }

        System.out.println("Anomalias encontradas");

        for (LogEntry l : filterAnomaly){
            System.out.println(l);
        }

        System.out.println("\nOrdenação dos ids");
        log.filterByID();
        System.out.println("Relatórios\n\n" + log.getLogEntries());

        System.out.println("Performace: " + log.performanceCalculator() +"ms");
    }
}
