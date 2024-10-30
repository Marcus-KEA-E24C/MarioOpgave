import java.util.Scanner;

public class Ændremenukort {
    public void ændreMenukort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Fjern pizza\n2.Rediger pris\n3.Tilføj ny pizza\n4.Ændre ingrediens\n5.Ændre rækkefølge af pizza");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                removePizza();
                break;
            case 2:
                changePrice();
                break;
            case 3:
                addPizza();
                break;
            case 4:
                changeIngredients();
                break;
            case 5:
                changeMenu();
                break;
            default:
                System.out.println("Valgmulighed ikke tilgængelig. Prøv igen");

        }
    }

    public void removePizza() {
        System.out.println("Vælg en pizza du vil slette (indtast nummeret):");
        visAllePizzaer();

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();


        if (index >= 0 && index < menyPizza.size()) {
            ValuesOfPizza removedPizza = menyPizza.remove(index);
            System.out.println("Pizza '" + removedPizza.navn + "' er blevet slettet fra menuen.");
        } else {
            System.out.println("Ugyldigt valg. Prøv igen.");
        }
    }
    public void addPizza(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Navn på ny pizza");
        String navn=scanner.nextLine();
        System.out.println("Ingredientser");
        String ingredients=scanner.nextLine();
        System.out.println("Pris");
        int pris=scanner.nextInt();
        ValuesOfPizza nyPizza= new ValuesOfPizza(navn,ingredients,pris);
        System.out.println("Du har nu tilføjet "+ nyPizza.navn +" til menukortet");
    }
    public void changePrice(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Hvilken pizza vil du ændre prisen på?");
        visAllePizzaer();
        int pizza=scanner.nextInt();
        ValuesOfPizza selectPizza= menyPizza.get(pizza);
        System.out.println("Hvad vil du ændre "+selectPizza.navn + "'s pris til");
        int nyPris= scanner.nextInt();
        selectPizza.pris=nyPris;
        System.out.println("Pizza: "+selectPizza.navn +" prisen er nu: "+selectPizza.pris);

    }public void changeIngredients() {
        System.out.println("Vælg en pizza, hvor du vil ændre ingredienserne (indtast nummeret):");
        ValuesOfPizza.visAllePizzaer();

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();


        if (index >= 0 && index < menyPizza.size()) {
            System.out.println("Indtast nye ingredienser for pizzaen '" + menyPizza.get(index).navn + "':");
            scanner.nextLine();
            String nyeIngredienser = scanner.nextLine();


            menyPizza.get(index).ingredienser = nyeIngredienser;
            System.out.println("Ingredienserne for '" + ValuesOfPizza.ValuesOfPizza.menyPizza.get(index).navn + "' er nu opdateret til: " + nyeIngredienser);
        } else {
            System.out.println("Ugyldigt valg. Prøv igen.");
        }

    }
    public void changeMenu(){
        System.out.println("Nuværende rækkefølge af pizzaer:");
        ValuesOfPizza.visAllePizzaer();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast nummeret på den første pizza, du vil bytte:");
        int firstIndex = scanner.nextInt();

        System.out.println("Indtast nummeret på den anden pizza, du vil bytte:");
        int secondIndex = scanner.nextInt();


        if (firstIndex >= 0 && firstIndex < menyPizza.size() && secondIndex >= 0 && secondIndex < menyPizza.size()) {

            ValuesOfPizza temp = menyPizza.get(firstIndex);
            menyPizza.set(firstIndex, menyPizza.get(secondIndex));
            menyPizza.set(secondIndex, temp);

            System.out.println("Rækkefølgen er nu opdateret:");
            ValuesOfPizza.visAllePizzaer();
        } else {
            System.out.println("Et eller begge valg var ugyldige. Prøv igen.");
        }
    }
}

