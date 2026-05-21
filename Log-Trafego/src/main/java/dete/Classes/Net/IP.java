package dete.Classes.Net;

import java.util.Objects;
import java.util.Scanner;

public class IP {
    private String IP;

    public IP(String ip){
        this.IP = ip;
    }

    public void insertIP(String IP){
        this.IP = IP;
    }

    public String getIP() {
        return IP;
    }

    @Override
    public String toString() {
        return "IP: " + IP;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IP ip = (IP) o;
        return Objects.equals(IP, ip.IP);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(IP);
    }
}
