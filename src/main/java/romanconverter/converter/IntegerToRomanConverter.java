package romanconverter.converter;

public class IntegerToRomanConverter {
    private int numberToConvert;
    private int romanNumber;
    private String romanString = "";

    public IntegerToRomanConverter(int number) {
        this.numberToConvert = number;
    }

    public String convert() {
        while (numberToConvert > 0) {
            if (numberToConvert >= 1000) {
                addValue(1000, 'M');

            } else if (numberToConvert >= 500) {
                if (checkLongComposedNumber(900, "CM")) {
                    continue;
                }

                addValue(500, 'D');

            } else if (numberToConvert >= 100) {
                if (checkLongComposedNumber(400, "CD")) {
                    continue;
                }

                addValue(100, 'C');

            } else if (numberToConvert >= 50) {
                if (checkLongComposedNumber(90, "XC")) {
                    continue;
                }

                addValue(50, 'L');

            } else if (numberToConvert >= 10) {
                if (checkLongComposedNumber(40, "XL")) {
                    continue;
                }

                addValue(10, 'X');

            } else if (numberToConvert >= 5) {
                if (checkShortComposedNumber(9, "IX")) {
                    break;
                }

                romanString += "V";
                romanNumber = 5;

                while (romanNumber < numberToConvert) {
                    romanString += "I";
                    romanNumber++;
                }

                numberToConvert -= romanNumber;
            } else {
                if (checkShortComposedNumber(4, "IV")) {
                    break;
                }

                romanString += "I";
                romanNumber++;
                numberToConvert--;
            }
        }

        return romanString;
    }

    private boolean checkShortComposedNumber(int number, String romanString) {
        if (this.numberToConvert == number) {
            this.romanString += romanString;
            return true;
        }

        return false;
    }

    private boolean checkLongComposedNumber(int number, String romanString) {
        if (this.numberToConvert >= number) {
            this.romanString += romanString;
            this.romanNumber = number;
            this.numberToConvert -= this.romanNumber;
            return true;
        }

        return false;
    }

    private void addValue(int number, char romanString) {
        this.romanNumber = number;
        this.romanString += romanString;
        this.numberToConvert -= this.romanNumber;
    }
}