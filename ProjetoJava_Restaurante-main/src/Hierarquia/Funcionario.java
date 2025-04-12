package Hierarquia;

import java.util.Scanner;

public class Funcionario extends Pessoas {
    String Cargo;

    //Scanner
    private Scanner LeituraTela_Funcionario = new Scanner(System.in);

    public String LeituraCargo(){
        System.out.printf("Insira seu cargo: ");
        Cargo = LeituraTela_Funcionario.next();
        return Cargo;
    }
}
