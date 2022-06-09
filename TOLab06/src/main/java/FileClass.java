import Person.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.nio.file.Paths;
import java.util.*;


public class FileClass {

    private static final Map<String, Person> personMap = new HashMap<>();
    private static final List<Person> personList = new ArrayList<>();

    public static void save() {
        try{
            PrintWriter printWriter = new PrintWriter(new FileWriter("base.txt", true));
            for (Person p : personList){
                printWriter.println(p.print());
            }

            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void readFromFile() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("base.txt"));

        String sth = "";
        while((sth = bufferedReader.readLine()) != null){
            String[] strings = sth.split(" ");
            String name = strings[0];
            String surname = strings[1];
            double x = Double.parseDouble(strings[2]);
            double y = Double.parseDouble(strings[3]);
            personList.add(new Person(name, surname, x, y));
            if(!personMap.containsKey(strings[0])){
                PersonProxy proxyPerson = new PersonProxy();
                proxyPerson.execute();
                proxyPerson.getPerson().setName(name);
                proxyPerson.getPerson().setSurname(surname);
                proxyPerson.getPerson().setX(x);
                proxyPerson.getPerson().setY(y);
                proxyPerson.execute();
                personMap.put(proxyPerson.getPerson().getName(), proxyPerson.getPerson());
            }
        }

    }

    public static Person addToMap(String name, String surname, double x, double y){
        Person p;

        if(personMap.containsKey(name)){
            p = personMap.get(name);
            p.setSurname(surname);
            p.setX(x);
            p.setY(y);
        }else{
            PersonProxy person = new PersonProxy();
            person.execute();
            person.getPerson().setName(name);
            person.getPerson().setSurname(surname);
            person.getPerson().setX(x);
            person.getPerson().setY(y);
            person.execute();
            personMap.put(person.getPerson().getName(), person.getPerson());
            p = personMap.get(name);
        }

        return p;
    }

    public static void addToList(Person person){
        personList.add(person);
    }

    public static void printList(){
        for (Person p : personList){
            System.out.println(p);
        }
    }

    public static void listPersonFromMap(){
        System.out.println();
        personMap.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();
    }

}
