import java.util.Random;

public class Personagem{
  //variáveis de instância(objeto)
  String nome;
  private int cod_atividade;
  private String descricao;

  //esse é o construtor padrão
  //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
  Personagem(){
    cod_atividade = 0;
    descricao = null;
  }
  public int getCod_atividade(){
    return cod_atividade;
  }

  public String getDescricao(){
    return descricao;
  }

  public void jogar(){
    var gerador = new Random();
    int oQueFazer = gerador.nextInt(3);
    switch(oQueFazer){
      default:
        cod_atividade = 1;
        descricao = "caçou";
        break;
      case 1:
        cod_atividade = 2;
        descricao = "comeu";
      break;
      case 2:
        cod_atividade = 3;
        descricao = "dormiu";
      break;
    }
  }
}