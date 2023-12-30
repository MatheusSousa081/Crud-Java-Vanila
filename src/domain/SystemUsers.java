package domain;

import exceptions.UsersException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SystemUsers {
    Scanner sc = new Scanner(System.in);
    List<User> listUsers;

    public SystemUsers() {
        this.listUsers = new ArrayList<>();
    }

    public void createUser() {
        System.out.print("Insira o nome do usuário: ");
        String name = sc.nextLine();

        System.out.print("Insira o email do usuário: ");
        String email = sc.nextLine();

        User user = new User(name, email);
        listUsers.add(user);
        System.out.println("Usuário inserido com sucesso!");
        System.out.println();
    }

    public void readUsers() throws UsersException{
        if (listUsers.size() == 0) {
            throw new UsersException("Erro! não existe nenhum usuário registrado!");
        }
        System.out.println("******* Lista *******");
        System.out.println();
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println((i+1) + "- " + listUsers.get(i));
            
        }

        System.out.println();
        System.out.println("********************");
        System.out.println();
    }

    public void updateUser() throws UsersException{
        try {
        readUsers();

        System.out.print("Insira o indice do usuário que voce deseja atualizar: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice > 0 && indice <= listUsers.size()) {
            System.out.print("Insira o novo nome do usuário: ");
            String newName = sc.nextLine();

            System.out.print("Insira o novo email do usuário: ");
            String newEmail = sc.nextLine();

            listUsers.get((indice -1)).setName(newName);
            listUsers.get((indice -1)).setEmail(newEmail);

            System.out.println("Usuário atualizado com sucesso!");
            System.out.println();

        } else {
            System.out.println("Indice invalido!");
        }
        System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
            sc.nextLine();
        } catch (UsersException e) {
            System.out.println(e.getMessage());
        }
    }   

    public void deleteUser() throws UsersException{
        try {
            readUsers();

            System.out.print("Insira o indice do usuário que voce deseja remover: ");
            int indice = sc.nextInt();
            sc.nextLine();

            if (indice > 0 && indice <= listUsers.size()) {
                listUsers.remove((indice - 1));
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Indice invalido!");
            }
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
            sc.nextLine();
        } catch (UsersException e){
            System.out.println(e.getMessage());
        }
    }
}