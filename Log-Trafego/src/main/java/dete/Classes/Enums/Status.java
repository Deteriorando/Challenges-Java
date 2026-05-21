package dete.Classes.Enums;

public enum Status {
    OK(300, "OK"),
    SUCCESS(202, "SUCCESS"),
    TIMEOUT(408, "TIMEOUT"),
    ERROR(500, "ERROR");

    private final Integer status;
    private final String Message;

    Status(int Status, String Message){
        this.status = Status;
        this.Message = Message;
    }


    public Integer getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return "Status: " + Message;
    }
}
