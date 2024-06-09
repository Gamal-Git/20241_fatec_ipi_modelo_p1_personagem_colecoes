import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) {
    var menu = "1-Jogar\n2-Consultar Log\n0-Sair";
    int op = 0;
    do{
      try{
        var user = new Usuario();
        var daoUser = new PersonagemDAO();
        do{
          user.login =JOptionPane.showInputDialog("Login: ");
          user.senha = JOptionPane.showInputDialog("Senha: ");
        }while(!daoUser.loginUsuario(user));
          op = Integer.parseInt(
          JOptionPane.showInputDialog(menu)
        );
        switch(op){
          case 1: {
            var p = new Personagem();
            var dao = new PersonagemDAO();
            for (int i = 0; i < 10; i++) {
                p.jogar();
                dao.log(p);
              }
            break;
          }
          case 2:{
            var dao = new PersonagemDAO();
            dao.consultarLog();
          break;
          }
          case 0:{
            JOptionPane.showMessageDialog(null, "Saindo...");
          break;
          }
          default:{
            JOptionPane.showMessageDialog(null, "Opção inválida");
          }
        }
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