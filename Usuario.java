public class Usuario {
    String login;
    String senha;
    int pontuacao;

    Usuario(){
        login = null;
        senha = null;
        pontuacao = 0;
    }

    public String getLogin (){
        return login;
    }

    public String getSenha (){
        return senha;
    }

    public int getPontuacao (){
        return pontuacao;
    }

    public void zerarPontuacao (){
        pontuacao = 0;
    }
}