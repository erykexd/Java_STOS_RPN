package stos;

public class RPN {
    Operators operator = new Operators();

    public double count(String onp) {
        for (String token : onp.split("\\s+")) {
            this.operator.readToken(token);
        }
        return this.operator.getStos();
    }

}