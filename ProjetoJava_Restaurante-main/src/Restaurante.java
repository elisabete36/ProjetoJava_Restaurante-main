import java.util.List;
import java.util.Scanner;
import Acesso_Dados.Cliente_Acesso;
import Acesso_Dados.Funcionario_Acesso;
import Hierarquia.Cliente;
import Hierarquia.Funcionario;


public class Restaurante {
    public static void main(String[] args){
       
        //Variaveis
        int op;
        //Scanners
        Scanner leitura_tela = new Scanner(System.in);
   
    //TELA INICIAL  CLIENTE/FUNCIONARIO

    while (true) {
        System.out.println("-------------  RESTAURANTE PAPA PIZZA  -------------");
        System.out.println(" ESCOLHA UMA DAS OPÇÕES A BAIXO    \n 1.Cliente \n 2.Funcionario \n 3.Saída");
        System.out.printf(" \nInsira aqui: ");
        op = leitura_tela.nextInt();

        switch (op){
            case 1: 
                handleCliente(leitura_tela);
                break;
            case 2:
                handleFuncionario(leitura_tela);
                break;

            case 3:
                System.out.println("SAINDO DO PROGRAMA...");
                leitura_tela.close();
                return;

            default:
                System.out.println("ALTERNATIVA INVALIDA"); 
            }    
        }
    }

    //Area do cliente 
    private static void handleCliente(Scanner leitura_tela) {  

    while(true){
        System.out.printf("\nSEJA BEM VINDO(A)   \nJÁ POSSUI CADASTRO?  \n1.Sim  \n2.Nao \n3.Voltar \nInsira aqui: ");
        int op = leitura_tela.nextInt();
        boolean login;
        
        if(op == 1){
            Cliente cliente = new Cliente();
            System.out.println("PARA ACESSAR SUA CONTA INFORME EMAIL E SENHA");  
            login = new Cliente_Acesso().Cliente_Login(cliente);  

            if(login){
                menuCliente(leitura_tela, cliente);
            }else{
                System.out.println("Falha ao autenticar dados!!!");
            }   
        } else if(op == 2){
            Cliente cliente = new Cliente();
            System.out.println("PARA CRIAR UMA CONTA PREENCHA AS INFORMACOES A BAIXO ");
            new Cliente_Acesso().CadastrarCliente(cliente);
            System.out.printf("SEU CADASTRO FOI REALIZADO COM SUCESSO \n3.Voltar para o menu inicial \nInsira aqui: ");
            op = leitura_tela.nextInt();
        }else if(op == 3){
            break;
        } 
    }
}

    //MENU E RESERVA DO CLIENTE
    private static void menuCliente(Scanner leitura_tela, Cliente cliente){

    while(true){
        System.out.printf("------- PAPA PIZZA ------- \n1.FAZER RESERVAS \n2.VER MESAS E PEDIDOS \n3.SAIR  \n\nInsira aqui: ");
        int op = leitura_tela.nextInt();

        if (op == 1 ){
            System.out.println("AQUI ESTÁ A LISTA DE MESAS PARA RESERVA:\nMesa1\nMesa2\nMesa3\nMesa4\nMesa5\nMesa6\nMesa7\nMesa8\nMesa9\nMesa10");
            new Cliente_Acesso().CadastrarReserva(cliente);
            System.out.println("     >>>>>> CARDAPIO <<<<<< \n\n--------Pratos Principais-------- \n1.Macarrão Carbonara..........63,50 \n2.Macarrão ao molho pesto..........45,60 \n3.Macarrão a bolonhesa..........32,43\n4.Macarrão ao molho branco..........32,43\n");
            System.out.println("--------Bebidas-------- \n1.Coca cola..........5,60 \n2.Guarána..........5,60 \n3.Fanta laranja e uva..........5,60 \n4.Sucos naturais \n   ->Laranja...........12,50 \n   ->Maracujá..........14,50 \n   ->Caju..........12,50 \n   ->Abacaxi com Hortalã..........13,50");
            System.out.println("--------Sobremesa-------- \n1.Palha Italiana..........9,90 \n2.Torta de Limão..........7,50 \n3.Torta de chocolate belga..........7,50"); 
            new Cliente_Acesso().CadastrarPedido(cliente);
            System.out.println("Reserva e Pedidos feitos com sucesso feita com sucesso!!! Voltando ao menu :)");
            continue; 
        }else if(op == 2){
            System.out.println(">>>>>>>>>> AQUI ESTÃO A SUAS RESERVAS <<<<<<<<<<");
            Cliente_Acesso acesso = new Cliente_Acesso();
            List<String> reservas = acesso.ConsultarReservas();

            for (String reserva : reservas) {
                System.out.println(reserva);
            }

            System.out.println(">>>>>>>>>> AQUI ESTÃO OS SEUS PEDIDOS <<<<<<<<<<");
            Cliente_Acesso acesso_2 = new Cliente_Acesso();
            List<String> pedidos = acesso.ConsultarPedidos();

            for(String pedido : pedidos){
                System.out.println(pedido);
            }
        }else if(op == 3){
            break;
        } 
    }
}

    //ÁREA DO FUNCIONARIO 
    private static void handleFuncionario(Scanner leitura_tela){

    while (true) {
        System.out.printf("<<<<<< AREA DOS FUNCIONARIOS >>>>>> \n1.Já sou funcionario \n2.Sou funcionario novo \n3.Voltar \nInsira aqui: ");   
        int op = leitura_tela.nextInt();
        boolean login;
            if(op == 1){
                Funcionario funcionario = new Funcionario();
                System.out.println("<<<<<< LOGIN FUNCIONARIO >>>>>>");
                login = new Funcionario_Acesso().Funcionario_Login(funcionario);
            
                if(login){
                    telaFuncionario(leitura_tela, funcionario);
                }else{
                    System.out.println("Falha ao autenticar dados!!!");
                }
            }else if(op == 2){
                Funcionario funcionario = new Funcionario();
                System.out.println("PARA CRIAR UMA CONTA PREENCHA AS INFORMACOES A BAIXO ");
                new Funcionario_Acesso().CadastrarFuncionario(funcionario);
                System.out.printf("SEU CADASTRO FOI REALIZADO COM SUCESSO \n3.Voltar para o menu inicial \nInsira aqui: ");
                op = leitura_tela.nextInt(); 
            }else if(op == 3){
                break;
            }         
        }
    }
    
    private static void telaFuncionario(Scanner leitura_tela, Funcionario funcionario){
    
    while(true){
        System.out.println("-------- FUNCIONÁRIO --------");
        System.out.println("1. VER RESERVAS");
        System.out.println("2. VOLTAR");
        System.out.print("\nInsira aqui: ");
        int op = leitura_tela.nextInt();

        if(op == 1 ){
            Funcionario_Acesso acesso = new Funcionario_Acesso();
            List<String> reservas = acesso.ConsultarReservas();

            for (String reserva : reservas) {
                System.out.println(reserva);
            }    
        }else if(op == 2 ){
            break;

            }
        }
    }  
}


        

