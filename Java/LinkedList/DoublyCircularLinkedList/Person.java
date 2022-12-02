//Classe pessoa que estende a classe Comparable para implementar o compareTo
public class Person implements Comparable<Person>{
    //Atributos da classe
    private int age; //Idade da pessoa
    private String name; //Node da pessoa

    //Construtor
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }//Fim

    //Metodo getAge para obter a idade da pessoa
    public int getAge(){
        return this.age;
    }//Fim getAge

    //Metodo getName para obter o nome da pessoa
    public String getName(){
        return this.name;
    }//Fim getName

    //Metodo setInfo para atializar uma informação
    public void setInfo(int age, String name){
        this.age = age;
        this.name = name;
    }//Fim setInfo

    //Metodo que sobrescreve o metodo compareTo da classe Comparable
    @Override
    public int compareTo(Person p){
        if((p.getAge() == this.age) && p.getName().equals(this.name)){
            return 0;
        }else if(p.getAge() > this.age){
            return -1;
        }else{
            return 1;
        }
    }//Fim compareTo

    //Metodo toString para imprimir os atributos do metodo
    public String toString(){
        return "Person data\nAge: " + age + "\nName: " + name + "\n";
    }//Fim compareTo
}//Fim classe Person