public class Person{
    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void setInfo(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "Person data\nAge: " + age + "\nName: " + name + "\n";
    }
}