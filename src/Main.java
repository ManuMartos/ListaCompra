import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> product = new ArrayList<String>();

        int option;
        while ( (option = showMenu(product) ) !=0){

            switch (option){
                case 1:
                    //Añadir producto
                    addProduct(product);
                    System.out.println();
                    break;
                case 2:
                    //Eliminar producto
                    deleteProduct(product);
                    break;
                case 3:
                    //Mostrar lista
                    showProduct(product);
                    break;
                case 4:
                    //Consultar importe
                    break;
                case 5:
                    //Pagar
                default:
            }
        }
    }

    public static void showProduct(ArrayList<String> myProduct){

        int index = 0;
        for (String task: myProduct) {
            System.out.println((index++) + " - " + task);
        }
    }

    public static void deleteProduct(ArrayList<String> myProduct){
        Scanner input = new Scanner(System.in);
        int index;

        do {
            System.out.println("Introducir el indice:");
            index = input.nextInt();
        }while ( !correctIndex(index, myProduct) );

        myProduct.remove(index);

    }

    public static boolean correctIndex(int index, ArrayList<String> myProduct){

        if (index >= 0 && index < myProduct.size() ) {
            return true;
        }else {
            return false;
        }
    }

    public static void addProduct(ArrayList<String> myProduct){
        Scanner input = new Scanner(System.in);
        String product;

        do {
            System.out.println("Introducir producto");
            product = input.nextLine().trim().replaceAll("\\s+"," ");

            if (product.length() <= 0){
                System.out.println("No se puede añadir espacios en blanco.");
            }
        }while (product.length() == 0);

        myProduct.add(product);
    }

    public static int showMenu(ArrayList<String> myProduct){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> options = new ArrayList<Integer>();
        int option;

        System.out.println("**********************************");
        System.out.println("* 1 - Añadir producto            *");
        options.add(1);
        System.out.println("* 2 - Eliminar producto          *");
        options.add(2);
        System.out.println("* 3 - Mostrar lista artículos    *");
        options.add(3);
        System.out.println("* 4 - Consultar importe total    *");
        options.add(4);
        System.out.println("* 0 - Pagar                      *");
        System.out.println("**********************************");


        do {
            System.out.println("Opcion: ");
            option = input.nextInt();
        }while ( option < 0 || option > options.size());


        return option;

    }
}
