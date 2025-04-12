package Acesso_Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Hierarquia.Funcionario;

public class Funcionario_Acesso {

    //CADASTRO FUNCIONARIO
    public void CadastrarFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO LISTA_FUNCIONARIOS (NOMECOMPLETO, CPF, IDADE, EMAIL, SENHA, CARGO) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

         try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, funcionario.Leitura_Nome());
            ps.setString(2, funcionario.Leitura_CPF());
            ps.setInt(3, funcionario.Leitura_Idade());
            ps.setString(4, funcionario.Leitura_email());
            ps.setString(5, funcionario.CriarSenha());
            ps.setString(6, funcionario.LeituraCargo());

            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    //LOGIN FUNCIONARIO
    public boolean Funcionario_Login(Funcionario funcionario){

        String sql = "SELECT * FROM LISTA_FUNCIONARIOS WHERE EMAIL = ? AND SENHA = ?";
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.LogarEmail());
            ps.setString(2, funcionario.LogarSenha());

            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("DE VOLTA AO TRABALHO :) LOGIN REALIZADO COM SUCESSO...");
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
