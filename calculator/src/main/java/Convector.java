public class Convector {
    int arab[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String rome[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    int arabNumbers[] =    { 1,    4,   5,    9,   10,  40,  50,   90,  100};
    String romeNumbers[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

    public boolean isArabDigit(String digit) {
        for (int i = 0; i < rome.length; i++) {
            if (digit.toUpperCase().equals(rome[i])) { //проверка на Римские цифры, если это Римска цифра то вернется false
                return false;
            }
        }
        int i = Integer.parseInt(digit); // Проверка на целочисленные цифры, если мы введем любые данные кроме ИНТа, то программа закроется с ошибкой.
        return true;

    }
    public String convertToArab(String romeDigit) {
        int index = 0;
        for (int i = 0; i < rome.length; i++) {
            if (romeDigit.equals(rome[i])) {
                index = i;
                break;
            }
        }
        return String.valueOf(arab[index]);
    }
    public String convertToRome(int arabDigit) {
        String result = "";
        int hundreds = arabDigit / 100;
        int tenner = (arabDigit - 100 * hundreds) / 10;
        int unit = (arabDigit - 100 * hundreds - 10 * tenner);

        if(hundreds == 1){
            result = romeNumbers[8];
        }

        if( tenner > 0 && tenner < 4){
            for (int i = 0; i < tenner; i++) {
                result = result + romeNumbers[4];
            }
        }else if( tenner == 4){
            result = result + romeNumbers[5];
        }else if( tenner == 5){
            result = result + romeNumbers[6];
        }else if( tenner > 5 && tenner < 9){
            result = result + romeNumbers[6];
            int count = tenner - 5;
            for(int i = 0; i < count; i++){
                result = result + romeNumbers[4];
            }
        }else if( tenner == 9){
            result = result + romeNumbers[7];
        }

        if (unit > 0 && unit < 4) {
            for (int i = 0; i < unit; i++) {
                result = result + rome[0];
            }
        } else if (unit == 4) {
            result = result + romeNumbers[1];
        }else if(unit == 5){
            result = result + romeNumbers[2];
        }else if(unit > 5 && unit < 9){
            result = result + romeNumbers[2];
            int count = unit - 5;
            for(int i = 0; i < count; i++){
                result = result + romeNumbers[0];
            }
        }else if(unit == 9) {
            result = result + romeNumbers[3];
        }
        return result;
    }
}
