import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) {
    int op = 0;
    var user = new Usuario();
    var dao = new PersonagemDAO();
    var p = new Personagem();
    do{
      user.login =JOptionPane.showInputDialog("Login: ");
      user.senha = JOptionPane.showInputDialog("Senha: ");
      }while(!dao.loginUsuario(user));
      do{
        try{
          var menu = "1-Jogar\n2-Consultar Log\n3-Ranking\n0-Sair";
          op = Integer.parseInt(
            JOptionPane.showInputDialog(menu)
        );
        switch(op){
          case 1: {
            for (int i = 0; i < 10; i++) {
                p.jogar(user);
                dao.log(p, user);
              }
              dao.ranking(user, p);
            break;
          }
          case 2:{
            dao.consultarLog();
          break;
          }
          case 3:{
            dao.consultarRanking();
          }
          case 0:{
            JOptionPane.showMessageDialog(null, "Saindo...");
          break;
          }
          default:{
            JOptionPane.showMessageDialog(null, "Opção inválida");
          break;
          }
        }
        user.zerarPontuacao();
      }
      catch(Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(
          null, "Coisas ruins aconteceram..."
        );
      }
    }while(op != 0);   
  }  
}