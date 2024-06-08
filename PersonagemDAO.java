
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonagemDAO { //data access object
  
  public void log(Personagem p) throws Exception{
    //cláusula catch or declare
    //1. Especificar o comando SQL
    var sql = "INSERT INTO tb_atividade(cod_atividade, descricao) VALUES (?, ?)";
    //2. Estabelecer uma conexão com o banco
    Connection conexao = ConnectionFactory.getConnection();
    //3. Preparar o comando
    PreparedStatement ps = conexao.prepareStatement(sql);
    //4. Substituir os eventuais placeholders
    
    ps.setInt(1, p.getCod_atividade());
    ps.setString(2, p.getDescricao());
    //5. Executar o comando
    ps.execute();
    //6. Fechar a conexão
    ps.close();
    conexao.close();
  }
}
