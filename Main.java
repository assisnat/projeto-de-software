import java.util.Scanner;
import static java.lang.System.exit;

public class main{
    static String[] userNames = new String[50];
    static String[] userLogins= new String[50];
    static String[] userPasswords = new String[100];
    static String[] communitiesNames = new String[50];
    static String[] communitiesDescriptions = new String[200];
    static int[] communitiesOwners = new int[100];
    public static int userActualID;
    public static int countUsers = 0;
    public static int[] userIDs = new int[100];
    public static int countCom = 0;
    public static int[][] communitiesRegister = new int[100][100];

    public static void createAccount(){
        Scanner input = new Scanner(System.in);
        if(countUsers >= 100){
            System.out.println("O limite máximo de usuários foi atingido!");
        }else{
            System.out.println("CRIAÇÃO DE CONTA");
            System.out.println("Por favor, insira um email válido: ");

            userLogins[countUsers] = input.next();

            System.out.println("Agora insira uma senha: ");
            userPasswords[countUsers] = input.next();

            System.out.println("Por último, insira um nome de usuário: ");
            userNames[countUsers] = input.next();

            userIDs[countUsers] = countUsers;
            countUsers++;
        }
    }

    public static void editAccount(){
        int option;
        String data;
        Scanner board = new Scanner(System.in);

        System.out.println("EDITAR CONTA");
        System.out.println("Dados atuais");
        System.out.println("Login: " + userLogins[userActualID]);
        System.out.println("Senha: " + userPasswords[userActualID]);
        System.out.println("Usuário: " + userNames[userActualID]);
        System.out.println("Escolha um campo para alterar: ");
        System.out.println("1 - Login\n2 - Senha\n3 - Usuário");

        option = board.next();

        switch(option){
            case 1:
                System.out.println("Insira o novo login: ");
                data = board.next();
                userLogins[userActualID] = data;
                System.out.println("Seu login foi alterado com sucesso!");
                break;
            case 2:
                System.out.println("Insira a nova senha: ");
                data = board.next();
                userPasswords[userActualID] = data;
                System.out.println("Sua senha foi alterada com sucesso!");
                break;
            case 3:
                System.out.println("Insira o novo usuário: ");
                data = board.next();
                userNames[userActualID] = data;
                System.out.println("Seu usuário foi alterado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void deleteAccount(){
        userNames[userActualID] = "-1";
        userLogins[userActualID] = "-1";
        userPasswords[userActualID] = "-1";
        userIDs[userActualID] = -1;
        for(int i=0;i<countCom;i++){
            if(communitiesOwners[i] == userActualID){
                communitiesNames[i] = "-1";
                communitiesDescriptions[i] = "-1";
                communitiesOwners[i] = -1;
            }
        }

        System.out.println("Perfil deletado com sucesso!");
    }

    public static void createCommunity(){
        Scanner board = new Scanner(System.in);
        String cName;
        String description;

        System.out.println("CRIAÇÃO DE COMUNIDADE");
        System.out.println("Digite um nome para a comunidade: ");
        communitiesNames[countCom] = board.nextLine();

        System.out.println("Digite uma descrição para a comunidade: ");
        communitiesDescriptions[countCom] = board.nextLine();

        communitiesOwners[countCom] = userActualID;

        countCom++;
    }

    public static void userScreen(){
        Scanner keyboard = new Scanner(System.in);
        int option;

        System.out.println("Bem vindo ao iFace, " + userNames[userActualID] + "!\n Escolha o que deseja fazer: ");

        System.out.println("1 - Criar conta");
        System.out.println("2 - Editar perfil");
        System.out.println("3 - Criar comunidade");
        System.out.println("4 - Deletar conta");
        System.out.println("5 - Sair");

        option = keyboard.nextInt();

        switch(option){
            case 1:
                createAccount();
                break;
            case 2:
                editAccount();
                break;
            case 3:
                deleteAccount();
                break;
            case 4:
                createCommunity();
                break;
            case 5:
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        int option;

        userScreen();

        option = keyboard.next();
    }
}
