package View;

import java.util.Scanner;
import dao.ContatoDao;
import dao.ContatoDaoInterface;
import java.sql.SQLException;
import java.util.List;
import model.Contato;

public class TesteContato {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ContatoDaoInterface contatoDao = new ContatoDao();

        // Inicializar opcao
        int opcao = -1;
        boolean continuar = true;

        do {
            // Exiba o menu aqui
            System.out.println("\033[34m------------------------\033[0m");
            System.out.println("\033[34m 🧾Menu de Contatos: 🧾\033[0m"); // Azul
            System.out.println("\033[34m1 - Adicionar Contato 👨‍🎓 \033[0m");
            System.out.println("\033[34m2 - Listar Contatos 👨‍👩‍👧\033[0m");
            System.out.println("\033[34m3 - Buscar Contato 🔎\033[0m");
            System.out.println("\033[34m4 - Alterar Contato 🔧\033[0m");
            System.out.println("\033[34m5 - Remover Contato❌\033[0m");
            System.out.println("\033[34m------------------------\033[0m");
            System.out.println("Pressione s para encerrar o Gerenciador 😁");
            System.out.print("\033[33mDigite a opção desejada: \033[0m");


            // Verifica se é um número válido
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner
                switch (opcao) {
                    case 1:
                        // Adicionar contato
                        System.out.println("------------------------");
                        System.out.println("Digite o nome do contato:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o email do contato:");
                        String email = scanner.nextLine();
                        System.out.println("Digite o endereço do contato:");
                        String endereco = scanner.nextLine();
                        System.out.println("Digite o sexo do contato (M/F):");
                        String sexo = scanner.nextLine();
                        System.out.println("Digite o celular do contato:");
                        String celular = scanner.nextLine();
                        System.out.println("------------------------");

                        Contato contato = new Contato();
                        contato.setNome(nome);
                        contato.setEmail(email);
                        contato.setEndereco(endereco);
                        contato.setSexo(sexo);
                        contato.setCelular(celular);

                        contatoDao.adiciona(contato);
                        System.out.println("\033[32mContato adicionado com sucesso!\033[0m"); // Verde
                        break;
                    case 2:
                        // Listar contatos
                        List<Contato> contatos = contatoDao.listaContatos();
                        if (contatos.isEmpty()) {
                            System.out.println("Nenhum contato cadastrado.");
                        } else {
                            for (Contato c : contatos) {
                                System.out.println("------------------------");
                                System.out.println("ID: " + c.getId());
                                System.out.println("Nome: " + c.getNome());
                                System.out.println("Email: " + c.getEmail());
                                System.out.println("Endereço: " + c.getEndereco());
                                System.out.println("Sexo: " + c.getSexo());
                                System.out.println("Celular: " + c.getCelular());
                            }
                        }
                        break;
                    case 3:
                        // Buscar contato
                        System.out.println("Digite o nome ou ID para buscar:");
                        String busca = scanner.nextLine();
                        if (busca.matches("\\d+")) { // Verifica se é um número (ID)
                            try {
                                Long id = Long.parseLong(busca);
                                Contato contatoBuscado = contatoDao.buscaPorId(id);
                                if (contatoBuscado != null) {
                                    System.out.println("------------------------");
                                    System.out.println("ID: " + contatoBuscado.getId());
                                    System.out.println("Nome: " + contatoBuscado.getNome());
                                    System.out.println("Email: " + contatoBuscado.getEmail());
                                    System.out.println("Endereço: " + contatoBuscado.getEndereco());
                                    System.out.println("Sexo: " + contatoBuscado.getSexo());
                                    System.out.println("Celular: " + contatoBuscado.getCelular());
                                } else {
                                    System.out.println("Contato não encontrado.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("ID inválido.");
                            }
                        } else {
                            List<Contato> contatosBuscados = contatoDao.buscaPorNome(busca);
                            if (contatosBuscados.isEmpty()) {
                                System.out.println("Nenhum contato encontrado com esse nome.");
                            } else {
                                for (Contato c : contatosBuscados) {
                                    System.out.println("------------------------");
                                    System.out.println("ID: " + c.getId());
                                    System.out.println("Nome: " + c.getNome());
                                    System.out.println("Email: " + c.getEmail());
                                    System.out.println("Endereço: " + c.getEndereco());
                                    System.out.println("Sexo: " + c.getSexo());
                                    System.out.println("Celular: " + c.getCelular());
                                }
                            }
                        }
                        break;
                    case 4:
                        // Alterar contato
                        System.out.println("Digite o nome do contato que deseja alterar:");
                        String nomeAlterar = scanner.nextLine();
                        List<Contato> contatosAlterar = contatoDao.buscaPorNome(nomeAlterar);
                        if (contatosAlterar.isEmpty()) {
                            System.out.println("Nenhum contato encontrado com esse nome.");
                        } else {
                            for (Contato c : contatosAlterar) {
                                System.out.println("------------------------");
                                System.out.println("ID: " + c.getId());
                                System.out.println("Nome: " + c.getNome());
                                System.out.println("Email: " + c.getEmail());
                                System.out.println("Endereço: " + c.getEndereco());
                                System.out.println("Sexo: " + c.getSexo());
                                System.out.println("Celular: " + c.getCelular());
                            }
                            System.out.println("Digite o novo endereço do contato:");
                            String novoEndereco = scanner.nextLine();
                            for (Contato c : contatosAlterar) {
                                c.setEndereco(novoEndereco);
                                contatoDao.altera(c);
                            }
                            System.out.println("\033[32mContato alterado com sucesso!\033[0m"); // Verde
                        }
                        break;
                    case 5:
                    // Remover contato
                    System.out.println("Digite o ID do contato que deseja remover:");
                    String idInput = scanner.nextLine(); // Ler a entrada como String, pois o usuário pode digitar texto

                    try {
                        // Validar se a entrada é um número válido
                        Long idRemover = Long.parseLong(idInput);

                        contatoDao.remove(idRemover);
                        System.out.println("\033[32mContato removido com sucesso!\033[0m"); // Verde
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Digite um número válido.");
                    }
                    break;
                }
            } else {
                String entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("s")) {
                    System.out.println("Obrigado");
                    continuar = false; //
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } while (continuar);

        scanner.close();
    }
}