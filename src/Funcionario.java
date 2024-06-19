//2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salario (BigDecimal) e função (String).

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;

    }@Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');//adiciona um . para separar as unidades de milhar
        symbols.setDecimalSeparator(',');//substitui o . por , na parte decima do número
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return super.toString() + ", Salário: " + df.format(salario) + ", Função: " + funcao;
    }
}
