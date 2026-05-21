package TaskManagerSystem;
import java.util.Scanner;

public class Task {
    private int ID;
    private String name;
    private String description;
    private String Stats;
    private static final Scanner scan = new Scanner(System.in);

    public Task(int ID, String name, String description, String stats){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.Stats = stats;
    }

    public Task(){}

    public void Start(){
        TaskManager taskManager = new TaskManager();
        taskManager.help();
        int number = scan.nextInt();

        while (number != 0){
            if  (number == 1) taskManager.addTask();
            if  (number == 2) taskManager.edit();
            if  (number == 3) taskManager.remove();
            if  (number == 4) taskManager.showTask();
            if  (number == 5) taskManager.help();

            new TaskManager().help();
            number = scan.nextInt();
        }

        System.out.println("Programa finalizado!");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStats() {
        return Stats;
    }

    public void setStats(String stats) {
        Stats = stats;
    }
}
