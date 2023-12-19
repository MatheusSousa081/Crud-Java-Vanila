import java.util.Scanner;

import domain.SystemUsers;

public class App {
    public static void main(String[] args) throws Exception {
        SystemUsers system = new SystemUsers();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 5)  {
            System.out.println("""
                    ------ MENU ------
                    1- Adicionar
                    2- Listar
                    3- Atualizar
                    4- Remover
                    5- Sair
                    """);
            
            System.out.print("Escolha um opção: ");
            escolha = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (escolha) {
                case 1 -> system.createUser();
                case 2 -> system.readUsers();
                case 3 -> system.updateUser();
                case 4 -> system.deleteUser();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente");
            }
        }

        System.out.println("Programa encerrado!");
        sc.close();
    }
}
