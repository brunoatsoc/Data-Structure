public class Car implements Comparable<Car>{
    private int placa;
    private int manobra = 0;

    public void setPlaca(int p){
        placa = p;
    }

    public void setManobra(int n){
        if(n == 1){
            manobra++;
        }
    }

    public int getPlaca(){
        return placa;
    }

    public int getManobra(){
        return manobra;
    }

    @Override
    public String toString(){
        return placa + " " + manobra + "\n";
    }

    @Override
    public int compareTo(Car var){
        if(placa == var.getPlaca()){
            return 0;
        }else if(placa < var.getPlaca()){
            return -1;
        }else{
            return 1;
        }
    }
}