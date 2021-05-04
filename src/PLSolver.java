import com.sun.javaws.exceptions.InvalidArgumentException;

import java.math.BigDecimal;

public class PLSolver {
    public static void main(String[] args) throws Exception {
        Console.printf("============================================\n");
        Console.printf(" Welcome! Linear Programming Problem Solver\n");
        Console.printf("============================================\n");

        // Capture problem data
        PLProblem plProblem = capturePLProblem();

        // Print SimpleX Table
        PLSimpleXTable table = plProblem.getSimpleXTable();
        Console.printf(table.toString());
    }

    private static PLProblem capturePLProblem() throws Exception {
        Console.printf("Enter number of variables: ");
        int numberOfVariables = Integer.parseInt(Console.readLine());

        if (numberOfVariables < 2) {
            throw new RuntimeException("Problem must have at least 2 decision variables!");
        }

        PLProblem plProblem = new PLProblem(numberOfVariables);

        for(int i = 0; i < numberOfVariables; i++) {
            Console.printf("--------------\n");
            Console.printf("Restriction %d\n", (i + 1));
            Console.printf("--------------\n");

            PLRestriction restriction = new PLRestriction(i);

            for(int j = 0; j < numberOfVariables; j++) {
                Console.printf("X%d: ", (j+1));
                BigDecimal variableValue = new BigDecimal(Console.readLine());
                restriction.addVariableValue(variableValue);
            }

            Console.printf("Tipo de desigualdad: 1. <=, 2. >=, 3. =");
            int unequalityType = Integer.parseInt(Console.readLine());
            restriction.setUnequalityType(PLUnequalityType.fromValue(unequalityType));

            Console.printf("Solution: ");
            BigDecimal solution = new BigDecimal(Console.readLine());
            restriction.setResourceLimit(solution);

            plProblem.addRestriction(restriction);
        }

        // Captura de funcion objetivo
        Console.printf("--------------\n");
        Console.printf("Funcion Objetivo\n");
        Console.printf("--------------\n");

        PLObjectiveFunction objectiveFunction = new PLObjectiveFunction();

        for(int j = 0; j < numberOfVariables; j++) {
            Console.printf("X%d: ", (j+1));
            BigDecimal variableValue = new BigDecimal(Console.readLine());
            objectiveFunction.addVariableValue(variableValue);
        }

        Console.printf("Objetivo de la función? 1. Maximizar, 2. Minimizar: ");
        objectiveFunction.setType(PLObjectiveFunctionType.fromType(Integer.parseInt(Console.readLine())));

        plProblem.setObjectiveFunction(objectiveFunction);

        return plProblem;
    }
}
