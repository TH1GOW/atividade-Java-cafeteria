import java.util.Scanner;

public class Cafeteria_didi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] nomes = new String[5];
        double[] valoresPedidos = new double[5];
        String[] descricoesPedidos = new String[5];
        int totalClientes = 0; 

        int opcao; 

        
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Emitir relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:

                    if (totalClientes >= 5) {
                        System.out.println("Limite de 5 clientes atingido.");
                        break;
                    }

                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();

                    double totalPedido = 0.0;
                    StringBuilder descricao = new StringBuilder();

                    
                    char continuar;
                    do {
                        System.out.println("\nEscolha o produto:");
                        System.out.println("1 - Café simples (R$4.40)");
                        System.out.println("2 - Capuccino   (R$6.00)");
                        System.out.println("3 - Chá orgânico(R$3.50)");
                        System.out.println("4 - Bolo artesanal (R$7.00)");
                        System.out.print("Opção: ");
                        int prod = sc.nextInt();
                        sc.nextLine();

                        
                        switch (prod) {
                            case 1:
                                totalPedido += 4.40;
                                descricao.append("Café simples, ");
                                break;
                            case 2:
                                totalPedido += 6.00;
                                descricao.append("Capuccino, ");
                                break;
                            case 3:
                                totalPedido += 3.50;
                                descricao.append("Chá orgânico, ");
                                break;
                            case 4:
                                totalPedido += 7.00;
                                descricao.append("Bolo artesanal, ");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }

                        System.out.print("Deseja mais algum item? (s/n): ");
                        continuar = sc.next().toLowerCase().charAt(0);
                        sc.nextLine();
                    } while (continuar == 's'); 

                    
                    nomes[totalClientes] = nome;
                    valoresPedidos[totalClientes] = totalPedido;
                    descricoesPedidos[totalClientes] = descricao.toString();
                    totalClientes++;

                    System.out.printf("Pedido de %s registrado. Total: R$%.2f\n", nome, totalPedido);
                    break;

                case 2:
                   
                    if (totalClientes == 0) {
                        System.out.println("Nenhum pedido registrado ainda.");
                        break;
                    }

                    double somaTotal = 0;
                    double maior = valoresPedidos[0];
                    double menor = valoresPedidos[0];
                    String clienteMaior = nomes[0];
                    String clienteMenor = nomes[0];

                    
                    for (int i = 0; i < totalClientes; i++) {
                        System.out.printf("\nCliente: %s\nPedido: %s\nValor: R$%.2f\n",
                                nomes[i], descricoesPedidos[i], valoresPedidos[i]);
                        somaTotal += valoresPedidos[i];

                        if (valoresPedidos[i] > maior) {
                            maior = valoresPedidos[i];
                            clienteMaior = nomes[i];
                        }
                        if (valoresPedidos[i] < menor) {
                            menor = valoresPedidos[i];
                            clienteMenor = nomes[i];
                        }
                    }

                    System.out.printf("\nValor total arrecadado: R$%.2f\n", somaTotal);
                    System.out.printf("Maior pedido: %s (R$%.2f)\n", clienteMaior, maior);
                    System.out.printf("Menor pedido: %s (R$%.2f)\n", clienteMenor, menor);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0); 

        sc.close();
    }
}
