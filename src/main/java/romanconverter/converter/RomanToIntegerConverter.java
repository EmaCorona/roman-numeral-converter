package romanconverter.converter;

public class RomanToIntegerConverter {
    private final String romanString;
    private boolean isDecrement;
    private int result;

    public RomanToIntegerConverter(String romanString) {
        this.romanString = romanString;
    }

    public int convert() {
        if (isValidValue(romanString)) {
            char[] characters = romanString.toCharArray();

            for (int i = 0; i < characters.length; i++) {
                checkIsComposedNumber(characters[i], characters, i);
                addOrDecrement(characters[i]);
                isDecrement = false;
            }
        }

        return result;
    }

    private void checkIsComposedNumber(char c, char[] characters, int index) {
        if (characters.length > index + 1) {
            switch (c) {
                case 'I': {
                    checkNextCharacters(characters, index, 'V', 'X');
                    break;
                }
                case 'X': {
                    checkNextCharacters(characters, index, 'L', 'C');
                    break;
                }
                case 'C': {
                    checkNextCharacters(characters, index, 'D', 'M');
                    break;
                }
            }
        }
    }

    private void addOrDecrement(char c) {
        switch (c) {
            case 'I': {
                raiseValue(1);
                break;
            }
            case 'V': {
                result += 5;
                break;
            }
            case 'X': {
                raiseValue(10);
                break;
            }
            case 'L': {
                result += 50;
                break;
            }
            case 'C': {
                raiseValue(100);
                break;
            }
            case 'D': {
                result += 500;
                break;
            }
            case 'M': {
                result += 1000;
                break;
            }
        }

    }

    private void checkNextCharacters(char[] characters, int index, char char1, char char2) {
        for (int i = index + 1; i < characters.length; i++) {
            if (characters[i] == char1 || characters[i] == char2) {
                isDecrement = true;
                break;
            }
        }
    }

    private void raiseValue(int increase) {
        if (!isDecrement) {
            result += increase;
        } else {
            result -= increase;
        }
    }

    private boolean isValidValue(String str) {
        return (!str.isEmpty() && str.length() <= 15);
    }
}
