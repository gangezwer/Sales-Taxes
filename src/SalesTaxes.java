import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTaxes {

    public static ArrayList<Products> productList = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public  static  void displayMenu()  {
        while (true) {
            System.out.println("\n");
            System.out.println("*************** Displaying Sales Tax Calculator Menu ***************");
            System.out.println("\n");
            System.out.println("Enter \"1\" to create new basket to add products to calculate tax");
            System.out.println("Enter \"2\" to print the bill");
            System.out.println("Enter \"3\" to start a new basket");
            System.out.println("Enter \"q\" to exit the program");
            System.out.println("\n");
            System.out.print("Select an option from the above menu: ");
            Scanner uu = new Scanner(System.in);
            String select = uu.nextLine().toLowerCase();

            switch(select) {
                case "1":
                    salesTaxesCalculation();
                    break;
                case "2":
                    printTheBill();
                    break;
                case "3":
                    productList.clear();
                    salesTaxesCalculation();
                    break;
                case "q":
                    System.exit(1);
                default:
                    System.out.println("Wrong Command");
            }
        }
    }

    public static void salesTaxesCalculation(){
        Products products = new Products();
        System.out.println("Enter the type product you want to calculate the tax(eg-GOODS/MED/FOOD..): ");
        Scanner mm = new Scanner(System.in);
        String userEntry = mm.nextLine().toUpperCase();

            System.out.println("Is the product imported or not(YES/NO): ");
            Scanner ll = new Scanner(System.in);
            String userEntryforImport = ll.nextLine().toUpperCase();

            if(userEntryforImport.equals("YES")|| userEntryforImport.equals("NO")){
                if(userEntry.equals("GOODS") && userEntryforImport.equals("NO")){
                    System.out.println("Enter the product name: ");
                    Scanner rr = new Scanner(System.in);
                    String productName = rr.nextLine().toUpperCase();

                    products.setName(productName);

                    System.out.println("Enter the product price: ");
                    Scanner nn = new Scanner(System.in);
                    double productPrice = nn.nextDouble();

                    products.setBasePrice(productPrice);

                    System.out.println("Enter the product quantity: ");
                    Scanner xx = new Scanner(System.in);
                    int productQuantity = xx.nextInt();

                    products.setQuantity(productQuantity);

                    double tax =  ((productPrice*10/100)*productQuantity);

                    double rounded = Math.round(tax * 20.0) / 20.0;

                    products.setTax(rounded);

                    double finalPrice =  (productPrice*productQuantity)+rounded;

                    products.setFinalPrice(finalPrice);
                }

                else if(userEntry.equals("GOODS")){
                    System.out.println("Enter the product name: ");
                    Scanner az = new Scanner(System.in);
                    String productName = az.nextLine().toUpperCase();

                    products.setName(productName);

                    System.out.println("Enter the product price: ");
                    Scanner ws = new Scanner(System.in);
                    double productPrice = ws.nextDouble();

                    products.setBasePrice(productPrice);

                    System.out.println("Enter the product quantity: ");
                    Scanner cv = new Scanner(System.in);
                    int productQuantity = cv.nextInt();

                    products.setQuantity(productQuantity);

                    double tax =  ((productPrice*10/100)+(productPrice*5/100)*productQuantity);

                    double rounded = Math.round(tax * 20.0) / 20.0;

                    products.setTax(rounded);

                    double finalPrice =  (productPrice*productQuantity)+rounded;

                    products.setFinalPrice(finalPrice);
                }

                else if(userEntryforImport.equals("YES")){
                    System.out.println("Enter the product name: ");
                    Scanner cf = new Scanner(System.in);
                    String productName = cf.nextLine().toUpperCase();

                    products.setName(productName);

                    System.out.println("Enter the product price: ");
                    Scanner bb = new Scanner(System.in);
                    double productPrice = bb.nextDouble();

                    products.setBasePrice(productPrice);

                    System.out.println("Enter the product quantity: ");
                    Scanner hh = new Scanner(System.in);
                    int productQuantity = hh.nextInt();

                    products.setQuantity(productQuantity);

                    double tax =  ((productPrice*5/100)*productQuantity);

                    double rounded = Math.round(tax * 20.0) / 20.0;

                    products.setTax(rounded);

                    double finalPrice =  (productPrice*productQuantity)+rounded;

                    products.setFinalPrice(finalPrice);
                }

                else {
                    System.out.println("Enter the product name: ");
                    Scanner kk = new Scanner(System.in);
                    String productName = kk.nextLine().toUpperCase();

                    products.setName(productName);

                    System.out.println("Enter the product price: ");
                    Scanner bn = new Scanner(System.in);
                    double productPrice = bn.nextDouble();

                    products.setBasePrice(productPrice);

                    System.out.println("Enter the product quantity: ");
                    Scanner oo = new Scanner(System.in);
                    int productQuantity = oo.nextInt();

                    products.setQuantity(productQuantity);

                    products.setFinalPrice(productPrice*productQuantity);

                }

                productList.add(products);

            }
            else {
                System.out.println("Enter a correct input");
            }

    }

    public static void printTheBill(){
        double totalBill = 0;
        double totalTax = 0;
        for(Products products: productList){
            System.out.println(products.getQuantity() +" "+ products.getName() +" at "+ " : " + df.format(products.getFinalPrice()));
            totalTax  += products.getTax();
            totalBill+= products.getFinalPrice();
        }

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("Total sales tax: "+df.format(totalTax));
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Total bill: "+df.format(totalBill));
    }

    public static void main(String[]args){
        displayMenu();
    }
}
