import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {


    public static void main(String[] args){
        //criando lista de funcionariosList
        List<Funcionario> funcionariosList;
        funcionariosList = new ArrayList<>();

        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela.
        funcionariosList.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        funcionariosList.add(new Funcionario("João", LocalDate.of(1990,05,12), new BigDecimal("2284.38"), "Operador"));
        funcionariosList.add(new Funcionario("Caio", LocalDate.of(1961,5,2),BigDecimal.valueOf(9836.14),"Coordenador"));
        funcionariosList.add(new Funcionario("Miguel", LocalDate.of(1988,10,14),BigDecimal.valueOf(19119.88),"Diretor"));
        funcionariosList.add(new Funcionario("Alice", LocalDate.of(1995,1,5),BigDecimal.valueOf(2234.68),"Recepcionista"));
        funcionariosList.add(new Funcionario("Heitor", LocalDate.of(1999,11,19),BigDecimal.valueOf(1582.72),"Operador"));
        funcionariosList.add(new Funcionario("Arthur", LocalDate.of(1993,3,31),BigDecimal.valueOf(4071.84),"Contador"));
        funcionariosList.add(new Funcionario("Laura", LocalDate.of(1994,7,8),BigDecimal.valueOf(3017.45),"Gerente"));
        funcionariosList.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24),BigDecimal.valueOf(1606.85),"Eletricista"));
        funcionariosList.add(new Funcionario("Helena", LocalDate.of(1996,9,2),BigDecimal.valueOf(2799.93),"Gerente"));

        //imprimir lista de funcionarios para verificar valores

        System.out.println("3.1 Lista de funcionários:");
        for (Funcionario Lista : funcionariosList) {
            System.out.println(Lista);
        }

        //3.2 – Remover o funcionário “João” da lista.
        funcionariosList.removeIf(Lista -> Lista.getNome().equals("João"));

        //3.3 – Imprimir todos os funcionários com todas suas informações
        System.out.println("\n3.2 João foi removido da lista\nLista de funcionários:");
        for (Funcionario Lista : funcionariosList) {
            System.out.println(Lista);
        }

        //3.4 Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        for (Funcionario f : funcionariosList) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            //multiplica o valor do salario por 1.1, que é o mesmo que adicionar 10%
            f.setSalario(novoSalario);
        }

        System.out.println("\n3.4 Salários aumentados em 10%\nLista de funcionários:");
        for (Funcionario f : funcionariosList) {
            System.out.println(f);
        }

        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionariosList.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        /*
        * Map<E> mapa = new Type();
        * E é o objeto declarado, nesse caso, tipo do objeto é String, e o objeto é a lista de funcionarios List<Funcionario>
        * Type é o tipo de coleção que foi usado, no caso, foi pego o pelo argumento função
        *
        */

        // 3.6 – Imprimir os funcionários, agrupados por função
        System.out.println("\n3.6 Funcionários agrupados por função:");
        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("Função: " + funcao);
            for (Funcionario f : funcionariosPorFuncao.get(funcao)) {
                System.out.println("Nome: "+f.getNome()+
                        ", Data Nascimento: "+f.getDataNascimento()+
                        ", Salário: "+f.getSalario());

            }
        }

        System.out.println("\n3.8 – funcionários que fazem aniversário no mês 10 e 12.");
        for (Funcionario f : funcionariosList) {
            //mesA = mes do aniversario
            int mesA = f.getDataNascimento().getMonthValue();
            if (mesA == 10 || mesA == 12) {
                System.out.println(f);
            }
        }

        //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Funcionario funcionarioMaisVelho = null;
        //armazena uma copia dos valores do funcionario mais velho
        for (Funcionario f : funcionariosList){
            if (funcionarioMaisVelho == null || f.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())){
                funcionarioMaisVelho = f;
            }
        }
        if (funcionarioMaisVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("\n3.9 Funcionário mais velho: " + funcionarioMaisVelho.getNome() + ", Idade: " + idade);
        }

        //3.10 – Imprimir a lista de funcionários por ordem alfabética
        List<Funcionario> ordenarFuncionarios = funcionariosList.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        System.out.println("\n3.10 Funcionários ordenados alfabeticamente:");
        for (Funcionario f : ordenarFuncionarios) {
            System.out.println(f);
        }

        //3.11 – Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionariosList) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        System.out.println("\n3.11 Total dos salários: " + String.format("%,.2f", totalSalarios));

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário
        //salário mínimo é R$1212.00
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\n3.12 Quantos salários mínimos ganha cada funcionário:");
        for (Funcionario f : funcionariosList) {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        }

    }
}

