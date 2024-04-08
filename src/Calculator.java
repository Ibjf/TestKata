import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Main result = new Main();
        System.out.println("Input:");
        String expr = input.nextLine();
        String result = Main.calc(expr);
        System.out.println(result);

    }
}

    class Main {
        public static String calc(String input) {
            Main check = new Main();
            Main resultRoman = new Main();
            String exception = "throws Exception";
            String[] inputMass = input.split(" ");
            if (inputMass.length != 3) return exception;

            String res = "";
            int y = 0;
            boolean romeFlag1 = false;
            boolean romeFlag2 = false;
            int sys1 = 0;
            int sys2 = 0;
            Integer num1 = 0;
            Integer num2 = 0;
            int result;

            // проверяем два числа
            sys1 = check.checkSys(inputMass[0]);
            sys2 = check.checkSys(inputMass[2]);
            y = sys1;

            if (sys1 != sys2 )
                return exception;
            else {
                switch (y){
                    case 0:
                        return exception;
                    case 1: { // Перевожу из римских в арабские, и запоминаю
                        num1 = check.checkTo(inputMass[0]);
                        num2 = check.checkTo(inputMass[2]);
                        romeFlag1 = true;
                        break;
                    }
                    case 2: {
                        num1 = Integer.valueOf(inputMass[0]);
                        num2 = Integer.valueOf(inputMass[2]);
                        break;
                    }
                }
            }

            if (num1 <1 || num1 >10 || num2 <1 || num2 >10) return exception;

            switch (inputMass[1]) {
                case "+": {
                            result = num1 + num2;
                            break;
                        } case "-": {
                            result = num1 - num2;
                            break;
                        } case "*": {
                            result = num1 * num2;
                            break;
                        } case "/": {
                            result = num1 / num2;
                            break;
                        } default:
                            return exception;
            }
            if (romeFlag1 && result > 0) {
                res = resultRoman.arabToRome(result);
                return res;
            }

            res = Integer.toString(result);
        return res;
        }

        Integer checkSys(String num)
        {
            String[] romanTen = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arabicTen = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            int i = 0;
            int flag = 0;
            while (i < 10){
                if (num.equals(romanTen[i])) {
                    flag = 1;
                    break;
                }
                else if (num.equals(arabicTen[i])) {
                    flag = 2;
                    break;
                }
                i++;
            }
            return flag;
        }


        Integer checkTo(String romanNum){
            String[] romanTen = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            int arabNum = 0;
            for (int i=0; i<10; i++){
                if (romanTen[i].equals(romanNum)) {
                    arabNum = i + 1;
                    return arabNum;
                }
            }
            return 0;
        }
        String arabToRome(Integer num){
            String result = "";
            int x = 0;
            int[] arabNine = {1, 4, 5, 9, 10, 40, 50, 90, 100};
            String romanNine[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
            for (int i = arabNine.length-1; i >= 0; i--) {
                x = num / arabNine[i];
                for (int j = 0; j < x; j++) {
                    result = result.concat(romanNine[i]);
                }
                num = num % arabNine[i] ;
            }
            return result;
        }


}
