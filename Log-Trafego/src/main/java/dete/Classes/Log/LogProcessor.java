package dete.Classes.Log;

import dete.Classes.Enums.Status;
import dete.Classes.Net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogProcessor {
    private static final List<LogEntry> logEntries = new ArrayList<>();
    private static LogProcessor instance;

    private LogProcessor(){}

    public static LogProcessor getInstance() {
        if (instance == null) instance = new LogProcessor();
        return instance;
    }

    public void addEntriesLog(LogEntry logEntry){
        logEntries.add(logEntry);
    }

    public void deleteLog(LogEntry log){
        logEntries.removeIf(l -> l.equals(log));
    }

    public void filterByID(){
        Collections.sort(logEntries);
    }

    public ArrayList<LogEntry> filterByStatus(Status status){
        ArrayList<LogEntry> filterLogStatus = new ArrayList<>();

        for (LogEntry l : logEntries)
            if (l.getStatus() == status) {
                filterLogStatus.add(l);
            }

        return filterLogStatus;
    }

    public ArrayList<LogEntry> filterByMs(Response response){
        ArrayList<LogEntry> filterResponse = new ArrayList<>();

        for (LogEntry l : logEntries){
            if (l.getResponse().equals(response)){
                filterResponse.add(l);
            }
        }

        return filterResponse;
    }

    public ArrayList<LogEntry> filterAnomaly(LogEntry logEntry){
        ArrayList<LogEntry> Anomaly = new ArrayList<>();

        for (LogEntry l : logEntries){
            if (l.getIp().equals(logEntry.getIp())){
                Anomaly.add(l);
            }
        }

        return Anomaly;
    }

    public double performanceCalculator(){
        long timeCount = 0L;
        int statusCountSucessfull = 0;

        for (LogEntry l: logEntries){
            if (l.getStatus() == Status.SUCCESS){
                statusCountSucessfull += 1;
                timeCount += l.getResponse().getResponseMs();
            }
        }
        return (double) timeCount / statusCountSucessfull;
    }


    public List<LogEntry> getLogEntries(){
        if (logEntries.isEmpty()){
            System.out.println("Não existe nenhum log, crie um log!");
            return null;
        }

        return logEntries;
    }
}
