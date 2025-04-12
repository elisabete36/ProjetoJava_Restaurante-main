package Acesso_Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Hierarquia.Cliente;

public class Cliente_Acesso {


    //CADASTRO AO BANCO DE DADOS
    public void CadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO LISTA_CLIENTES (NOMECOMPLETO, CPF, IDADE, EMAIL, SENHA) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.Leitura_Nome());
            ps.setString(2, cliente.Leitura_CPF());
            ps.setInt(3, cliente.Leitura_Idade());
            ps.setString(4, cliente.Leitura_email());
            ps.setString(5, cliente.CriarSenha());

            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    //LOGIN BANCO DE DADOS
    public boolean Cliente_Login(Cliente cliente){
        
        String sql = "SELECT * FROM LISTA_CLIENTES WHERE EMAIL = ? AND SENHA = ?";
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.LogarEmail());
            ps.setString(2, cliente.LogarSenha());

            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("SEJA BEM VINDO DE VOLTA, LOGIN REALIZADO COM SUCESSO...");
                return true; // Login bem-sucedido

            } else {
                System.out.println("ERRO!!! EMAIL OU SENHA INVALIDOS...");
                return false; // Falha no login
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
    
    //FAZER O PEDIDO
    public void CadastrarPedido(Cliente cliente){

        String sql = "INSERT INTO PEDIDOS (PRATO_PRINCIPAL, BEBIDA, SOBREMESA) VALUES(?,?,?)";
    
        PreparedStatement ps = null;
    
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.Pedido_PratoPrincipal());
            ps.setString(2, cliente.Pedido_Bebida());
            ps.setString(3, cliente.Pedido_Sobremesa());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //CONSULTAR PEDIDO
    public List<String> ConsultarPedidos(){
        String sql = "SELECT * FROM PEDIDOS";
        List<String> pedidos = new ArrayList<>();

        try(Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    String Prato_Principal = rs.getString("PRATO_PRINCIPAL");
                    String Bebida = rs.getString("BEBIDA");
                    String Sobremesa = rs.getString("SOBREMESA");

                    String pedido = String.format("\nPrato Principal: %s \nBebida: %s \nSobremesa: %s ", Prato_Principal, Bebida, Sobremesa);
                    pedidos.add(pedido);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return pedidos;  
        }

    //FAZER A RESERVAR
    public void CadastrarReserva(Cliente cliente){
        
        String sql = "INSERT INTO RESERVAS (MESA, NOME_CLIENTE, DATA_HORARIO) VALUES(?, ?, ?)"; 

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.Leitura_Reserva());
            ps.setString(2, cliente.Nome_Reserva());
            LocalDateTime dataHora = cliente.Leitura_Data();
            ps.setTimestamp(3, Timestamp.valueOf(dataHora));

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    //CONSULTAR RESERVAS
     public List<String> ConsultarReservas() {
        String sql = "SELECT * FROM RESERVAS";
        List<String> reservas = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                String mesa = rs.getString("MESA");
                String nomeCliente = rs.getString("NOME_CLIENTE");
                Timestamp dataHora = rs.getTimestamp("DATA_HORARIO");
                LocalDateTime dateTime = dataHora.toLocalDateTime();

                String reserva = String.format("Mesa: %-10s Nome do Cliente: %-20s Data: %td/%tm/%ty Hora: %tH:%tM", 
                        mesa, nomeCliente, dateTime, dateTime, dateTime, dateTime, dateTime);
                reservas.add(reserva);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
    //FAZAR O PEDIDO


