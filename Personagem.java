import java.util.Random;

public class Personagem{
  //variáveis de instância(objeto)
  String nome;
  private int energia;
  private int fome;
  private int sono;
  private int cod_atividade;
  private String descricao;

  //esse é o construtor padrão
  //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
  Personagem(){
    nome = null;
    energia = 10;
    fome = 0;
    sono = 0;
    cod_atividade = 0;
    descricao = null;
  }

  //construtor personalizado
  //o que viabiliza a sua existência é a sobrecarga de construtores
  Personagem(int energia, int fome, int sono){
    if (energia >= 0 && energia <= 10)
      this.energia = energia;
    if (fome >= 0 && fome <= 10)
      this.fome = fome;
    if (sono >= 0 && sono <= 10)
      this.sono = sono;
  }

  void cacar(){
    if(energia >= 2){
      energia -= 2; // energia = energia - 2;
    }
    else{
    }
    fome = Math.min(fome + 1, 10);
    //resolver com o ternário
    sono = sono < 10 ? sono + 1 : sono;
  }

  void comer() {
    //se tiver fome
      //comer e reduzir o valor de fome de 1
      //aumentar o valor de energia de 1
    //caso contrario
      //so vai avisar que esta sem fome
      switch(fome){
        case 0:
          break;
        default:
          --fome;
          energia = (energia == 10 ? energia : energia + 1);
      }
  }

  void dormir(){
    if(sono >= 1){
      sono -= 1;
      energia = Math.min(energia + 1, 10);
    }
  }

  public String toString(){
    return String.format(
      "%s: (e:%d, f:%d, s:%d)",
      nome, energia, fome, sono
    );
  }

  public int getCod_atividade(){
    return cod_atividade;
  }

  public String getDescricao(){
    return descricao;
  }

  public void jogar(Personagem p){
    var gerador = new Random();
    if(vivo(this)){
    int oQueFazer = gerador.nextInt(3);
    switch(oQueFazer){
      default:
        this.cacar();
        this.cod_atividade = 1;
        this.descricao = "caçou";
        break;
      case 1:
        this.comer();
        this.cod_atividade = 2;
        this.descricao = "comeu";
        break;
      case 2:
        this.dormir();
        this.cod_atividade = 3;
        this.descricao = "dormiu";
        break;
      }
    }
  }

  boolean vivo(Personagem p){
    if(p.energia > 0){
      return true;
    }
    else{
      return false;
    }
  }
}