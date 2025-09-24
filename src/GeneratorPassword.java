import java.util.*;

public class GeneratorPassword {
    private static final String LOWERCASE = "qwertyuiopasdfghjklzxcvbnm";
    private static final String UPPERCASE = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "~!@#$%^&*()-+/<>";

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("___Генератор безопасных паролей___");
        int length;
        while (true) {
            System.out.print("Введите длину пароля от 8 до 12: ");
            String input = scanner.nextLine().trim();
            try {
                length = Integer.parseInt(input);
                if (length >= 8 && length <= 12) {
                    break;
                } else {
                    System.out.println("Длина должна быть от 8 до 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }
        }
        String password = generatePassword(length);
        System.out.println("\nБезопасный пароль: " + password);
        scanner.close();
    }


    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        String all = LOWERCASE + UPPERCASE + DIGITS + SPECIAL;

        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));
        for (int i = 4; i < length; i++) {
            password.append(all.charAt(random.nextInt(all.length())));
        }

        char[] passwordChars = password.toString().toCharArray();
        for (int i = passwordChars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordChars[i];
            passwordChars[i] = passwordChars[j];
            passwordChars[j] = temp;
        }
        return new String(passwordChars);
    }
}