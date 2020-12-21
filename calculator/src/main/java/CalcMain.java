import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcMain {
    public static void main(String[] args) {
        char operaciya = 0;
        String result = "";
        Convector convertor = new Convector();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String all = reader.readLine(); // Считываем все что ввели с консоли.
            for (int i = 0; i < all.length(); i++) {
                char c = all.charAt(i);
                if (c == '*' || c == '/' || c == '+' || c == '-') {
                    operaciya = c;
                }
            }
            int operationPosition = all.indexOf(operaciya);
            String op1 = all.substring(0, operationPosition).trim();
            String op2 = all.substring(operationPosition + 1).trim();
            System.out.println("operand 1 = " + op1);
            System.out.println("operand 2 = " + op2);
            boolean arabDigit1 = convertor.isArabDigit(op1);
            boolean arabDigit2 = convertor.isArabDigit(op2);
            if (arabDigit1 && arabDigit2) {
                result = String.valueOf(applyOperation(op1, op2, operaciya));
            } else if (!arabDigit1 && !arabDigit2) {
                String rome1Converted = convertor.convertToArab(op1);
                String rome2Converted = convertor.convertToArab(op2);
                int resultArab = applyOperation(rome1Converted, rome2Converted, operaciya);
                result = convertor.convertToRome(resultArab);
            } else {
                throw new IllegalArgumentException("Вы ввели арабские и Римские цифры одновременно!");
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int applyOperation(String op1, String op2, char operaciya) {
        int intOP1 = Integer.parseInt(op1);
        int intOP2 = Integer.parseInt(op2);
        if (operaciya == '+') {
            return intOP1 + intOP2;
        } else if (operaciya == '-') {
            return intOP1 - intOP2;
        } else if (operaciya == '*') {
            return intOP1 * intOP2;
        } else {
            return intOP1 / intOP2;
        }
    }
}
