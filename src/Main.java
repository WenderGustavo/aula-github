//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcao = 1;

        while (opcao != 3) {
            opcao = obterOpcaoMenu(scan);
            if (opcao == 1) {  //Contultar Contato
                consultarContato(scan, agenda);

            } else if (opcao == 2) { //Adicionar Contato
                adicionarContato(scan, agenda);
            } else if (opcao == 3) { // termina o programa
                System.exit(0);
            }
        }

    }

    public static void adicionarContato(Scanner scan, Agenda agenda) {
        try {
            System.out.println("Criando contatos, entre com as informacoes");
            String nome = lerInformacaoString(scan, "Entre com o nome do contato");
            String telefone = lerInformacaoString(scan, "Entre com o telefone do contato");
            String email = lerInformacaoString(scan, "Entre com o email do contato");

            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setEmail(email);

            System.out.println("Contato a ser criado: ");
            System.out.println(contato);
            agenda.adiconarContato(contato);
        } catch (AgendaCheiaException e) {
            System.out.println(e.getMessage());

            System.out.println("Contatos da agenda");
            System.out.println(agenda);
        }
    }

    public static void consultarContato(Scanner scan, Agenda agenda) {
        String nomeContato = lerInformacaoString(scan, "Entre com o nome do contato a ser pesquisado");
        try {
            if (agenda.consultaContatoPorNome(nomeContato) >= 0);
            System.out.println("Contato existe");
        } catch (ContatoNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String lerInformacaoString(Scanner scan, String mensagem) {
        System.out.println(mensagem);
        String entrada = scan.nextLine();
        return entrada;
    }

    public static int obterOpcaoMenu(Scanner scan) {

        boolean entradaValida = false;
        int opcao = 3;
        while (!entradaValida) {
            System.out.println("Digite a opcao deseja");
            System.out.println("1: Contultar Contato");
            System.out.println("2: Adicionar Contato");
            System.out.println("3: Sair");

            try {
                String entrada = scan.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao == 1 | opcao == 2 | opcao == 3) {
                    entradaValida = true;
                } else {
                    throw new Exception("Entrada invalida");

                }
            } catch (Exception e) {
                System.out.println("Entrada Invalida, digite novamente\n");
            }
        }
        return opcao;
    }

}