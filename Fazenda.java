import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fazenda {
    private static List<Animais> plantel = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- MENU FAZENDA ---");
            System.out.println("1. Incluir animal");
            System.out.println("2. Consultar animal");
            System.out.println("3. Avaliar animal (Atualizar medidas)");
            System.out.println("4. Registrar venda");
            System.out.println("5. Registrar perda");
            System.out.println("6. Relatório por tipo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: incluirAnimal(); break;
                case 2: consultarAnimal(); break;
                case 3: avaliarAnimal(); break;
                case 4: registrarVenda(); break;
                case 5: registrarPerda(); break;
                case 6: relatorioPorTipo(); break;
            }
        } while (opcao != 0);
    }

    public static void incluirAnimal() {
        System.out.println("Qual tipo de animal deseja incluir? (1. Bovino)");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Altura: ");
        float alt = scanner.nextFloat();
        System.out.print("Comprimento: ");
        float comp = scanner.nextFloat();
        System.out.print("Largura: ");
        float larg = scanner.nextFloat();
        System.out.print("Peso: ");
        float peso = scanner.nextFloat();
        scanner.nextLine();

        if (tipo == 1) {
            Animais novoAnimal = new Bovinos(id, alt, comp, larg, peso, "Ativo");
            plantel.add(novoAnimal);
            System.out.println("Bovino incluído com sucesso!");
        }
    }

    public static void consultarAnimal() {
        System.out.print("Informe o ID para consulta: ");
        String idBusca = scanner.nextLine();
        
        for (Animais a : plantel) {
            if (a.getId().equals(idBusca) && a.getStatus().equals("Ativo")) {
                System.out.println("Tipo: " + a.getTipo() + " | ID: " + a.getId() + " | Status: " + a.getStatus() + " | Peso: " + a.getPeso() + " | Altura: " + a.getAltura());
                return;
            }
        }
        System.out.println("Animal não encontrado ou inativo.");
    }

    public static void avaliarAnimal() {
        System.out.print("Informe o ID do animal a ser avaliado: ");
        String idBusca = scanner.nextLine();

        for (Animais a : plantel) {
            if (a.getId().equals(idBusca) && a.getStatus().equals("Ativo")) {
                System.out.println("--- Medidas Atuais ---");
                System.out.println("Peso: " + a.getPeso() + " | Altura: " + a.getAltura() + " | Comprimento: " + a.getComprimento() + " | Largura: " + a.getLargura());

                System.out.print("Novo Peso: "); float novoPeso = scanner.nextFloat();
                System.out.print("Nova Altura: "); float novaAlt = scanner.nextFloat();
                System.out.print("Novo Comprimento: "); float novoComp = scanner.nextFloat();
                System.out.print("Nova Largura: "); float novaLarg = scanner.nextFloat();
                scanner.nextLine();

                if (novoPeso < a.getPeso() || novaAlt < a.getAltura() || novoComp < a.getComprimento() || novaLarg < a.getLargura()) {
                    System.out.println("ALERTA: Nova medida inferior à anterior! O animal deve ser examinado por um veterinário.");
                }

                a.setPeso(novoPeso);
                a.setAltura(novaAlt);
                a.setComprimento(novoComp);
                a.setLargura(novaLarg);
                
                System.out.println("Avaliação concluída.");
                return;
            }
        }
        System.out.println("Animal não encontrado.");
    }

    public static void registrarVenda() {
        System.out.print("Informe o ID do animal vendido: ");
        String idBusca = scanner.nextLine();

        for (Animais a : plantel) {
            if (a.getId().equals(idBusca) && a.getStatus().equals("Ativo")) {
                System.out.print("Informe o valor da venda: ");
                float valor = scanner.nextFloat();
                scanner.nextLine();
                
                a.setPrecoVenda(valor);
                a.setStatus("Vendido");
                
                System.out.println("Venda registrada com sucesso!");
                return;
            }
        }
        System.out.println("Animal não encontrado ou já não está mais ativo.");
    }

    public static void registrarPerda() {
        System.out.print("Informe o ID do animal perdido: ");
        String idBusca = scanner.nextLine();

        for (Animais a : plantel) {
            if (a.getId().equals(idBusca) && a.getStatus().equals("Ativo")) {
                a.setStatus("Perdido");
                System.out.println("Perda registrada com sucesso!");
                return;
            }
        }
        System.out.println("Animal não encontrado ou já não está mais ativo.");
    }

    public static void relatorioPorTipo() {
        System.out.print("Informe o tipo (Bovino, Suino, Equino): ");
        String tipoBusca = scanner.nextLine();
        
        System.out.println("--- Relatório de " + tipoBusca + " ---");
        for (Animais a : plantel) {
            if (a.getTipo().equalsIgnoreCase(tipoBusca) && a.getStatus().equals("Ativo")) {
                System.out.println("ID: " + a.getId() + " | Peso: " + a.getPeso() + " | Altura: " + a.getAltura());
            }
        }
    }
}
