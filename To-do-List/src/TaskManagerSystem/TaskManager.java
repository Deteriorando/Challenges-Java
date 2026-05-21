package TaskManagerSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskManager {
    private static final Scanner scan = new Scanner(System.in);
    Map<Integer, Task> tasks = new HashMap<>();
    int id = 0;

    public void addTask(){
        System.out.print("Nome: ");
        String name = scan.nextLine();
        System.out.print("Descrição: ");
        String description = scan.nextLine();
        System.out.print("Status: ");
        String Stats = scan.nextLine();
        countNoRepeat();

        tasks.put(id, new Task(id, name, description, Stats));
    }

    public void edit(){
        System.out.print("Digite o id para mudar a tarefa: ");
        String name;
        String description;
        String stats;
        int ID = scan.nextInt();
        scan.nextLine();
        int IDFounded = 0;
        Task taskEdit = new Task();

        if(tasks.isEmpty()){
            System.out.println("Não existe tasks por enquanto");
            return;
        }

        for (Task task : tasks.values()) {
            if (task.getID() == ID) {
                System.out.println("ID encontrado, começando a edição...");
                IDFounded = ID;
                taskEdit = task;
                break;
            }
        }

        if (!tasks.containsKey(IDFounded)){
            System.out.println("Esse ID não existe");
            return;
        }

        System.out.print("Nome: ");
        name = scan.nextLine();
        System.out.print("Descrição: ");
        description = scan.nextLine();
        System.out.print("Status: ");
        stats = scan.nextLine();

        taskEdit.setID(IDFounded);
        taskEdit.setName(name);
        taskEdit.setDescription(description);
        taskEdit.setStats(stats);

        tasks.replace(IDFounded, tasks.get(IDFounded), new Task(
                taskEdit.getID(),
                taskEdit.getName(),
                taskEdit.getDescription(),
                taskEdit.getStats())
        );
    }

    public void remove(){
        System.out.print("Digite o ID para remover: ");
        int ID = scan.nextInt();
        tasks.remove(ID);
    }

    public void showTask(){
        System.out.println("Número de tarefas: " + tasks.size());
        if(tasks.isEmpty()){
            System.out.println("Não existe tasks por enquanto");
            return;
        }

        // Quando for trabalhar com map, temos que pensar chave/‘item’ e usamos o foreach para trabalhar com hashmap.
        for(Task t : tasks.values()) {
            System.out.println("[");
            System.out.println("ID: " + t.getID());
            System.out.println("Nome: " + t.getName());
            System.out.println("Descrição: " + t.getDescription());
            System.out.println("Status: " + t.getStats());
            System.out.println("]");
        }
    }

    public void help(){
        System.out.println("1 - Adicionar taréfa");
        System.out.println("2 - Editar tarefa");
        System.out.println("3 - Remover tarefa");
        System.out.println("4 - Mostrar as tarefas");
        System.out.println("5 - Ajuda");
        System.out.println("0 - Sair");
        System.out.print("Digite o número para prosseguir: ");
    }

    public void countNoRepeat(){
        int num = 0;
        do {
            num++;
        } while (tasks.containsKey(num));
        id = num;
    }
}