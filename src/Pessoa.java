//1– Classe Pessoa com os atributos: nome (String)e data nascimento (LocalDate).

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa{
    private String nome;//argumento nome
    private LocalDate dataNascimento;//argumento data de nascimento

    //metodo construtor
    public Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        /*é usado sempre que uma nova instancia
        dessa classe for criada */
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + nome + ", Data Nascimento: " + dataNascimento.format(formatter);
    }
}
