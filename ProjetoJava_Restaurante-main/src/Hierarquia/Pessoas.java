package Hierarquia;
import java.util.Scanner;

public class Pessoas {

    //Atributos
    private String NomeCompleto;
    private String CPF;
    private int Idade;
    private String email;
    private String Senha;

    //Scanners
    Scanner leitura = new Scanner(System.in);


    //Atribuir Nome 
    public String Leitura_Nome(){
        System.out.printf("Insira seu Nome Completo: ");
        NomeCompleto = leitura.nextLine();
        return NomeCompleto;
    }

    //Atribuir CPF - CADASTRO
    public String Leitura_CPF(){
        System.out.printf("Insira seu CPF: ");
        CPF = leitura.next();
        return CPF; 
    }

    //Atribuir Idade 
    public int Leitura_Idade(){
        System.out.printf("Insira sua idade:  ");
        Idade = leitura.nextInt();
        return Idade;
    }


    //Atribuir e-mail - CADASTRO
    public String Leitura_email(){
        System.out.printf("Insira seu e-mail de contato: ");
        email = leitura.next();
        return email;
    }
    //Atribuir e-mail - LOGIN
    public String LogarEmail(){
        System.out.printf("Email: ");
        email = leitura.next();
        return email;
    }

    
    //Atribuir senha - CADASTRO
     public String CriarSenha(){
        System.out.printf("!!!! CRIE SUA SENHA !!!! \nSenha: ");
        Senha = leitura.next();
        return Senha;
    }
    //Atribuir senha - LOGIN
        public String LogarSenha(){
            System.out.printf("Senha: ");
            Senha = leitura.next();
            return Senha;
        }
}
