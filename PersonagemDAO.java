import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

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
    Thread.sleep(1000);
  }
  
  public void consultarLog() throws Exception {
    Connection conexao = ConnectionFactory.getConnection();
    
    String sql = "SELECT descricao, data_de_ocorrencia FROM tb_atividade ORDER BY data_de_ocorrencia DESC";
    PreparedStatement ps = conexao.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();

    StringBuilder mensagem = new StringBuilder();
    var dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    while (rs.next()) {
        String descricao = rs.getString("descricao");
        java.util.Date dataDeOcorrencia = rs.getTimestamp("data_de_ocorrencia");
        String dataFormatada = dateFormat.format(dataDeOcorrencia);
        mensagem.append("Descrição: ").append(descricao).append(", Data de Ocorrência: ").append(dataFormatada).append("\n");
    }
    
    JOptionPane.showMessageDialog(null, mensagem.toString(), "Log de Atividades", JOptionPane.INFORMATION_MESSAGE);
    
    rs.close();
    ps.close();
    conexao.close();
  }
}
