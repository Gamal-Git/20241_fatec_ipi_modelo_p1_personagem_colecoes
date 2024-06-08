import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
      var menu = "1-Jogar\n2-Consultar Log";
      int op = 0;
      do{
        try{
          op = Integer.parseInt(
            JOptionPane.showInputDialog(menu)
          );
          switch(op){
            case 1: {
                var p = new Personagem();
                var dao = new PersonagemDAO();
                for (int i = 0; i < 10; i++) {
                    p.jogar(p);
                    dao.log(p);
                }
            break;
            }
            case 2:{
                var dao = new PersonagemDAO();
                dao.consultarLog();
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