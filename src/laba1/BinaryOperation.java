package laba1;

class BinaryOperation implements Expression {
    public enum Operation {
        PLUS('+'),
        MINUS('-'),
        DIV('/'),
        MUL('*');

        private final char symbol;

        Operation(char symbol) {
            this.symbol = symbol;
        }

    }

    private final Expression left;
    private final Expression right;
    private final Operation operation;

    public BinaryOperation(Expression left, Operation operation, Expression right) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public double evaluate() {
        double leftValue = left.evaluate();
        double rightValue = right.evaluate();

        return switch (operation) {
            case PLUS -> leftValue + rightValue;
            case MINUS -> leftValue - rightValue;
            case DIV -> leftValue / rightValue;
            case MUL -> leftValue * rightValue;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation); //а зачем ты?
        };
    }
}