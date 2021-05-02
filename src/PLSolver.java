import java.math.BigDecimal;

public class PLSolver {
    public static void main(String[] args) throws Exception {
        Console.printf("Welcome!\n");

        Console.printf("Enter number of variables: ");
        int numberOfVariables = Integer.parseInt(Console.readLine());

        PLProblem plProblem = new PLProblem(numberOfVariables);

        // Captura de variables
        for(int i = 0; i < numberOfVariables; i++) {
            Console.printf("--------------\n");
            Console.printf("Restriction %d\n", (i + 1));
            Console.printf("--------------\n");

            Console.printf("Tipo de desigualdad: ");
            String unequalityType = Console.readLine();

            PLRestriction restriction = new PLRestriction(i, PLUnequalityType.fromString(unequalityType));

            for(int j = 0; j < numberOfVariables; j++) {
                Console.printf("X%d: ", (j+1));
                BigDecimal variableValue = new BigDecimal(Console.readLine());
                restriction.addVariableValue(variableValue);
            }

            Console.printf("Solution: ");
            BigDecimal solution = new BigDecimal(Console.readLine());
            restriction.setResourceLimit(solution);

            plProblem.addRestriction(restriction);
        }

        // Captura de funcion objetivo
        Console.printf("--------------\n");
        Console.printf("Funcion Objetivo");
        Console.printf("--------------\n");

        PLFuncionObjetivo funcionObjetivo = new PLFuncionObjetivo();

        for(int j = 0; j < numberOfVariables; j++) {
            Console.printf("X%d: ", (j+1));
            BigDecimal variableValue = new BigDecimal(Console.readLine());
            funcionObjetivo.addVariableValue(variableValue);
        }

        plProblem.setFuncionObjetivo(funcionObjetivo);

        // Impresión de tabla SimpleX
        PLSimpleXTable table = plProblem.getSimpleXTable();
        Console.printf(table.toString());
    }
}
