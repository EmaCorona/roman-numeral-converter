package romanconverter.converter;

public class IntegerToRomanConverter {
    private int number;
    private int romanNumber;
    private String romanString;

    public IntegerToRomanConverter(int number) {
        this.number = number;
    }

    public String convert() {
        while (number > 0) {
            if (number >= 1000) {
                addValue(1000, 'M');

            } else if (number >= 500) {
                if (checkLongComposedNumber(900, "CM")) {
                    continue;
                }

                addValue(500, 'D');

            } else if (number >= 100) {
                if (checkLongComposedNumber(400, "CD")) {
                    continue;
                }

                addValue(100, 'C');

            } else if (number >= 50) {
                if (checkLongComposedNumber(90, "XC")) {
                    continue;
                }

                addValue(50, 'L');

            } else if (number >= 10) {
                if (checkLongComposedNumber(40, "XL")) {
                    continue;
                }

                addValue(10, 'X');

            } else if (number >= 5) {
                if (checkShortComposedNumber(9, "IX")) {
                    break;
                }

                romanString += "V";
                romanNumber = 5;

                while (romanNumber < number) {
                    romanString += "I";
                    romanNumber++;
                }

                number -= romanNumber;
            } else {
                if (checkShortComposedNumber(4, "IV")) {
                    break;
                }

                romanString += "I";
                romanNumber++;
                number--;
            }
        }

        return romanString;
    }

    private boolean checkShortComposedNumber(int n, String value) {
        if (number == n) {
            romanString += value;
            return true;
        }

        return false;
    }

    private boolean checkLongComposedNumber(int n, String value) {
        if (number >= n) {
            romanString += value;
            romanNumber = n;
            number -= romanNumber;
            return true;
        }

        return false;
    }

    private void addValue(int n, char value) {
        romanNumber = n;
        romanString += value;
        number -= romanNumber;
    }
}