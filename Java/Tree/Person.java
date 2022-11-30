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

    public boolean isEqual(Person p){
        if(this.age == p.getAge()){
            if(this.name == p.getName()){
                return true;
            }
            return false;
        }
        return false;
    }
}