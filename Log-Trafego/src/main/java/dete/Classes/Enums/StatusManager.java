package dete.Classes.Enums;

public class StatusManager {
    public Status insertStatus(Integer status){
        if (status == 408) return Status.TIMEOUT;
        if (status == 500) return Status.ERROR;
        if (status == 202) return Status.SUCCESS;
        return Status.OK;
    }
}
