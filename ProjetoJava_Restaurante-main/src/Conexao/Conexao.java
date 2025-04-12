package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //Atributos de conexão
    private static final String url = "jdbc:mysql://127.0.0.1:3306/clientes";
    private static final String user = "root";
    private static final String password = "5002541memes"; 

    //Atributo de conexão
    private static Connection conn;

    //Metodo de conexão
    public static Connection getConexao(){
        try {
        if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;

        }else{
            return conn;
        }
        } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        return null;
        }
    }
}
