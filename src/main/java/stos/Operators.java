package stos;

import java.util.HashMap;
import java.util.Map;

public class Operators {

    Stos stos = new Stos();
    public Map<String, Operator> operators = new HashMap<>();

    Operators() {
        operators.put("+", new Add());
        operators.put("-", new Subtract());
        operators.put("*", new Multiply());
        operators.put("/", new Divide());
    }

    public double getStos() {
        return this.stos.pop();
    }

    public void readToken(String token) {
        if (token.matches("-?\\d+(\\.\\d+)?")) {
            this.stos.push(Double.parseDouble(token));
        } else {
            Operator tk = operators.get(token);
            if(tk != null){
                double b = this.stos.pop();
                double a = this.stos.pop();
                this.stos.push(tk.apply(a, b));
            } else {
                throw new IllegalArgumentException("Nieznany operator: " + token);
            }
        }
    }
    interface Operator {
        double apply(double a, double b);
    }

    final class Add implements Operator {
        public double apply(double a, double b) {
            return a + b;
        }
    }

    final class Subtract implements Operator {
        public double apply(double a, double b) {
            return a - b;
        }
    }

    final class Multiply implements Operator {
        public double apply(double a, double b) {
            return a * b;
        }
    }

    final class Divide implements Operator {
        public double apply(double a, double b) {
            return a / b;
        }
    }


}
