package Person;


public class PersonProxy implements IPerson {
    private Person person;

    public PersonProxy() {}

    @Override
    public void execute() {
        if (person == null){
            person = new Person();
        }else{
            person.execute();
        }
    }

    public Person getPerson(){
        return person;
    }

    public String getName(){
        return person.getName();
    }
}
