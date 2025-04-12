package Hierarquia;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cliente extends Pessoas {
    private String Mesa;
    private LocalDateTime DataHoraReserva;
    private String NomeReserva;
    private String Prato_Principal;
    private String Bebida;
    private String Sobremesa;

    //Scanner
    private Scanner LeituraTela_Cliente = new Scanner(System.in);
    
    //Atribuir Mesa
    public String Leitura_Reserva(){
        System.out.printf("Qual mesa deseja reservar: ");
        Mesa = LeituraTela_Cliente.nextLine();
        return Mesa;
    } 

    //Atribuir Data e Horário
    public LocalDateTime Leitura_Data(){
        System.out.printf("Data e horário da reserva (formato: ano-mes-dia hora:minutos): ");
        String dataHora = LeituraTela_Cliente.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DataHoraReserva = LocalDateTime.parse(dataHora, formatter);
        return DataHoraReserva;
    }

    public String Nome_Reserva(){
        System.out.printf("Nome: ");
        NomeReserva = LeituraTela_Cliente.nextLine();
        return NomeReserva;
    }

    public String Pedido_PratoPrincipal(){
        System.out.println("Qual vai ser o prato principal: ");
        Prato_Principal = LeituraTela_Cliente.nextLine();
        return Prato_Principal;
    }

    public String Pedido_Bebida(){
        System.out.println("Qual vai ser a bebida: ");
        Bebida = LeituraTela_Cliente.nextLine();
        return Bebida;
    }

    public String Pedido_Sobremesa(){
        System.out.println("Qual vai ser  a sobremesa: ");
        Sobremesa = LeituraTela_Cliente.nextLine();
        return Sobremesa;
    }
}

