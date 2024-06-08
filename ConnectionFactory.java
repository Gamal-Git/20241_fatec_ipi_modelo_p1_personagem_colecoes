import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
  private static String host = "localhost";
  private static String port = "5432";
  private static String db = "postgres";
  private static String user = "postgres";
  private static String password = "123456";
  //https://google.com:80/search
  //string de conexão
  //jdbc:postgresql://localhost:5432/20241_fatec_ipi_poo_pessoas
  //jdbc:postgresql://pgfatec-374536b-fatec-c2f0.e.aivencloud.com:28190/defaultdb?ssl=require&user=avnadmin&password=AVNS_XIthS_n0LgSbuKwcyg8
  public static Connection getConnection() throws Exception{
    //cláusula catch or declare
      var s = String.format(
        "jdbc:postgresql://%s:%s/%s",
        host, port, db
      );
      Connection conexao = DriverManager.getConnection(s, user, password);
      return conexao;
  }
}