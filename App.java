import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) {
    var menu = "1-Jogar\n2-Consultar Log\n0-Sair";
    int op = 0;
    var user = new Usuario();
    var dao = new PersonagemDAO();
    do{
      user.login =JOptionPane.showInputDialog("Login: ");
      user.senha = JOptionPane.showInputDialog("Senha: ");
    }while(!dao.loginUsuario(user));
    do{
      try{
          op = Integer.parseInt(
          JOptionPane.showInputDialog(menu)
        );
        switch(op){
          case 1: {
            var p = new Personagem();
            for (int i = 0; i < 10; i++) {
                p.jogar();
                dao.log(p, user);
              }
            break;
          }
          case 2:{
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