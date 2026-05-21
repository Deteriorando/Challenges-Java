package dete.Classes.Log;

import dete.Classes.Enums.Status;
import dete.Classes.Enums.StatusManager;
import dete.Classes.Net.ID;
import dete.Classes.Net.IP;
import dete.Classes.Net.Response;
import java.util.Objects;
import java.util.Scanner;

public class LogEntry implements Comparable<LogEntry> {
    private Integer id;
    private IP ip;
    private Response response;
    private Status status;


    public LogEntry(Integer id, IP ip, Response response, Status status) {
        this.id = id;
        this.ip = ip;
        this.response = response;
        this.status = status;
    }

    public LogEntry(){}

    public void insertLog(){
        Scanner scan = new Scanner(System.in);

        System.out.print("IP: ");
        String setIp = scan.nextLine();

        System.out.print("Tempo de resposta: ");
        long setResponse = scan.nextLong();

        System.out.print("Status: ");
        Integer setStatus = scan.nextInt();

        IP ip = new IP(setIp);
        Response response = new Response(setResponse);
        StatusManager statusManager = new StatusManager();

        LogEntry logEntry = new LogEntry(ID.GenerateID(),
                ip,
                response,
                statusManager.insertStatus(setStatus)
        );

        LogProcessor.getInstance().addEntriesLog(logEntry);
    }

    @Override
    public String toString() {
        return "- LogEntry -" +
                "\nid: " + id +
                "\n" + ip +
                "\n" + response +
                "\n" + status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(id, logEntry.id) && Objects.equals(ip, logEntry.ip) && Objects.equals(response, logEntry.response) && status == logEntry.status;
    }

    @Override
    public int compareTo(LogEntry o) {
        return id.compareTo(o.id);
    }

    public Integer getId() {
        return id;
    }

    public IP getIp() {
        return ip;
    }

    public Response getResponse() {
        return response;
    }

    public Status getStatus() {
        return status;
    }
}
