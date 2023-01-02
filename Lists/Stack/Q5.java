import lib.*;

public class Q5{
    public static void main(String[] args){
        String equation = "{2 + [(16 + 2 ∧ 3) - 4)} * 3";
        Stack<Character> s = new Stack<Character>();
        
        for(int i = 0; i < equation.length(); i++){
            Character var = equation.charAt(i);

            if(var == '{' || var == '[' || var == '('){
                s.push(var);
            }else if(var == '}' || var == ']' || var == ')'){
                if(var == '}'){
                    var = '{';
                }else if(var == ']'){
                    var = '[';
                }else if(var == ')'){
                    var = '(';
                }

                if(s.isEmpty()){
                    System.out.printf("Invalido\n\n");
                    System.exit(-1);
                }else if(var.compareTo(s.stackTop()) == 0){
                    s.pop();
                }else{
                    System.out.printf("Invalido\n\n");
                    System.exit(-1);
                }
            }
        }

        if(s.isEmpty()){
            System.out.printf("Valido\n\n");
        }else{
            System.out.printf("Invalido\n\n");
        }
    }
}