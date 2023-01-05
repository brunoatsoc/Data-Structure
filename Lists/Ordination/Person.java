public class Person{
    private int matricula;
    private String nome;
    private float nota;

    public Person(int m, String n, float no){
        matricula = m;
        nome = n;
        nota = no;
    }

    public void setMatricula(int m){
        this.matricula = m;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setNome(float nota){
        this.nota = nota;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNome(){
        return nome;
    }

    public float getNota(){
        return nota;
    }

    @Override
    public String toString(){
        return matricula + "\n" + nome + "\n" + nota + "\n\n";
    }
}