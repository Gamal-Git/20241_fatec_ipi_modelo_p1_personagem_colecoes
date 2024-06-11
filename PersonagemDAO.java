import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class PersonagemDAO { //data access object
  
  public void log(Personagem p, Usuario user) throws Exception{
    Connection conexao;
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;

    conexao = ConnectionFactory.getConnection();

    String sql1 = "SELECT cod_usuario FROM tb_usuario WHERE login = ? AND senha = ?";
    ps1 = conexao.prepareStatement(sql1);
    ps1.setString(1, user.getLogin());
    ps1.setString(2, user.getSenha());
    rs = ps1.executeQuery();

    if (rs.next()) {
      int codUsuario = rs.getInt("cod_usuario");
      String sql = "INSERT INTO tb_atividade(cod_atividade, descricao, cod_usuario) VALUES (?, ?, ?)";
                     
      ps = conexao.prepareStatement(sql);

      ps.setInt(1, p.getCod_atividade());
      ps.setString(2, p.getDescricao());
      ps.setInt(3, codUsuario);

      ps.execute();
      ps.close();
    }

    rs.close();
    ps1.close();
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
    int i = 0;
    while (rs.next() && i < 20) {
        String descricao = rs.getString("descricao");
        java.util.Date dataDeOcorrencia = rs.getTimestamp("data_de_ocorrencia");
        String dataFormatada = dateFormat.format(dataDeOcorrencia);
        mensagem.append("Descrição: ").append(descricao).append(", Data de Ocorrência: ").append(dataFormatada).append("\n");
        i++;
    }
    
    JOptionPane.showMessageDialog(null, mensagem.toString(), "Log de Atividades", JOptionPane.INFORMATION_MESSAGE);
    
    rs.close();
    ps.close();
    conexao.close();
  }

  public boolean loginUsuario(Usuario user){    
    try{
      var sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
      Connection conexao = ConnectionFactory.getConnection();
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.setString(1, user.getLogin());
      ps.setString(2, user.getSenha());
  
      ResultSet rs = ps.executeQuery();
  
      if(rs.next()){
        return true;
      }
    }
    catch(Exception e){ 
    }
  return false;
  }

  public void ranking(Usuario user, Personagem p) throws Exception{
    Connection conexao;
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;

    conexao = ConnectionFactory.getConnection();

    String sql1 = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
    ps1 = conexao.prepareStatement(sql1);
    ps1.setString(1, user.getLogin());
    ps1.setString(2, user.getSenha());
    rs = ps1.executeQuery();

    if (rs.next()) {
      int codUsuario = rs.getInt("cod_usuario");
      String nome = rs.getString("login");
      String sql = "INSERT INTO tb_ranking(pontuacao, login, cod_usuario) VALUES (?, ?, ?)";
                     
      ps = conexao.prepareStatement(sql);

      ps.setInt(1, user.getPontuacao());
      ps.setString(2, nome);
      ps.setInt(3, codUsuario);

      ps.execute();
      ps.close();
    }

    rs.close();
    ps1.close();
    conexao.close();
    Thread.sleep(10);
  }

  public void cadastrarUsuario(Usuario user) throws Exception{
    var sql = "INSERT INTO tb_usuario(login, senha) VALUES (?, ?)";
    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement ps = conexao.prepareStatement(sql);

    ps.setString(1, user.getLogin());
    ps.setString(2, user.getSenha());

    ps.execute();

    ps.close();
    conexao.close();
    Thread.sleep(500);
  }
}
