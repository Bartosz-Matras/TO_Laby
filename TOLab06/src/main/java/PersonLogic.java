import Person.Person;

import java.util.Locale;
import java.util.Scanner;

public class PersonLogic {

    public static void run(){
        try {
            FileClass.readFromFile();
        }catch (Exception e){
            e.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        String answer;

        while (true){
            printText();
            answer = scanner.nextLine();

            switch (answer) {
                case "1" -> addPerson();
                case "2" -> listPersons();
                case "3" -> {
                    System.out.println("Goodbye :)");
                    scanner.close();
                    FileClass.save();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Incorrect number!");
                    System.out.println();
                }
            }
        }
    }

    public static void addPerson(){
        Scanner scanner = new Scanner(System.in);
        String stringX, stringY;
        double x=0,y=0;

        System.out.println();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        while(true){
            try{
                System.out.print("Enter x coordinate: ");
                stringX = scanner.nextLine();
                x = Double.parseDouble(stringX);
                break;
            }catch (NumberFormatException e){
                System.out.println("Wrong double!");
            }
        }

        while(true){
            try{
                System.out.print("Enter y coordinate: ");
                stringY = scanner.nextLine();
                y = Double.parseDouble(stringY);
                break;
            }catch (NumberFormatException e){
                System.out.println("Wrong double!");
            }
        }

        String firstNameLetter = name.substring(0, 1).toUpperCase(Locale.ROOT);
        String nameL = name.substring(1).toLowerCase(Locale.ROOT);

        String firstSurnameLetter = surname.substring(0, 1).toUpperCase(Locale.ROOT);
        String surnameL = surname.substring(1).toLowerCase(Locale.ROOT);

        FileClass.addToList(new Person(firstNameLetter+nameL, firstSurnameLetter+surnameL, x, y));
        Person p = FileClass.addToMap(name, surname, x, y);
        System.out.println("Person added");
    }

    public static void listPersons(){
        FileClass.listPersonFromMap();
    }


    public static void printText(){
        System.out.println();
        System.out.println("Choose option: ");
        System.out.println("1.Add person");
        System.out.println("2.List person from DB");
        System.out.println("3.Exit");
        System.out.print("Enter: ");
    }


}
