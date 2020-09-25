package geekbrains.lesson3_hw;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lesson3_hw {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //1 Задание
        System.out.println("Задание №1");
        int range = 10;
        playLevel(range);
        System.out.println();
        //2 Задание
        System.out.println("Задание №2");
        System.out.println();
        guessProduct ();
    }

    private static void playLevel(int range) {
        System.out.println("Ваша задача угадать число.");
        int number = (int) (Math.random() * range);
        int count = 0;
        while (true) {

            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            count++;
            if (input_number == number) {
                System.out.println("Вы угадали! Победа!");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int a = scanner.nextInt();
                if (a == 1) playLevel(range);
                else {System.out.println("Спасибо за игру!");
                    break;
                }
            } else if (input_number > number) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше.");
            }

            if (count == 3) {
                System.out.println(" Вы проиграли...");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int a = scanner.nextInt();
                if (a == 1) playLevel(range);
                else {
                    System.out.println("Спасибо за игру!");
                    break;
                }
            }
        }
    }

    public static void guessProduct () {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String word;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println(Arrays.toString(words));
        int n = random.nextInt(words.length);
        System.out.println(words[n]);
        System.out.println("Угадайте загаданное слово: ");
        char[] chars = words[n].toCharArray();
        char[] chBuff = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            chBuff[i] = '#';
        }

        while (true) {
            System.out.print("Введите слово (или 0 для выхода): ");
            word = scanner.nextLine();
            if (word.equals("0")) {
                break;
            }
            if (word.equals(words[n])) {
                System.out.println("Вы угадали");
                break;
            } else {
                System.out.println("Вы не угадали");
                char[] charWord = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (i >= charWord.length) {
                        break;
                    }
                    if (chars[i] == charWord[i]) {
                        chBuff[i] = chars[i];
                    }
                }
                System.out.println(String.valueOf(chBuff)+"###############");
            }
        }

    }
}

