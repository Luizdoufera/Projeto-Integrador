import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Infome a descrição, data de inicio, data fim da ação");
            String descricao1 = sc.nextLine();
            String dataInico1 = sc.nextLine();
            String dataFim1 = sc.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInicio = dateFormat.parse(dataInico1);
            Date dateFim = dateFormat.parse(dataFim1);

            Acao acao1 = new Acao(descricao1, dateInicio, dateFim);
            System.out.println("Infome o percentual dessa ação");
            int percentual = sc.nextInt();
            acao1.concluirAcao(50);
            Status status1 = Status.EM_ANDAMENTO;
            acao1.InformarStatus(status1);
            System.out.println(acao1);

            System.out.println("Infome a descrição, data de inicio, data fim da ação");
            String descricao2 = sc.nextLine();
            String dataInico2 = sc.nextLine();
            String dataFim2 = sc.nextLine();

            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInicio2 = dateFormat.parse(dataInico2);
            Date dateFim2 = dateFormat.parse(dataFim2);
            
            Acao acao2 = new Acao(descricao1, dateInicio2, dateFim2);
            System.out.println("Infome o percentual dessa ação");
            int percentual2 = sc.nextInt();
            acao1.concluirAcao(percentual2);
            Status status2 = Status.FINALIZADO;
            acao1.InformarStatus(status2);
            System.out.println(acao2);

            System.out.println("Entre com as infomações da tarefa na qual essas ações pertencem: Nome, data inicio e data fim");
            String descricaoTarefa = sc.nextLine();
            String dataInicioTarefa = sc.nextLine();
            String dataFimTarefa = sc.nextLine();

            SimpleDateFormat dateFormatTarefa = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInicioTarefa = dateFormat.parse(dataInico2);
            Date dateFimTarefa = dateFormat.parse(dataFim2);

            Tarefa tarefa = new Tarefa(descricaoTarefa, dateInicioTarefa, dateFimTarefa);
            tarefa.adicionarAcao(acao1);
            tarefa.adicionarAcao(acao2);
            System.out.println(tarefa);
        }catch (InputMismatchException e) {
            System.out.println("Input invalido");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}

