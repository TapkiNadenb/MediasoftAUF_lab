import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Random;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@FunctionalInterface
interface Printable {
    void print();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface DeprecatedEx {
    String message();
}

@DeprecatedEx(message = "Используйте NewClass вместо StariyClass")
class StariyClass {
    @DeprecatedEx(message = "Используйте newMethod() вместо stariyMethod()")
    public void stariyMethod() {
        System.out.println("Выполнение устаревшего метода stariyMethod");
    }

    public void newMethod() {
        System.out.println("Выполнение нового метода newMethod");
    }
}

class HeavyBox {
    private final int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1.1: Лямбда выражение для интерфейса Printable");
        Printable printable = () -> System.out.println("Пытаюсь печатать через лямбду!");
        printable.print();

        System.out.println("\nЗадание 1.2: Проверка пустой строки");
        Predicate<String> notNull = s -> s != null;
        Predicate<String> notEmpty = s -> s != null && !s.isEmpty();
        Predicate<String> notNullAndNotEmpty = notNull.and(notEmpty);
        String[] testStrings = { null, "", "Hello", " " };
        for (String str : testStrings) {
            System.out.printf("Строка: %s -> notNull: %b, notEmpty: %b, both: %b%n",
                    str == null ? "null" : "\"" + str + "\"",
                    notNull.test(str), notEmpty.test(str), notNullAndNotEmpty.test(str));
        }

        System.out.println("\nЗадание 1.3: Проверка строки");
        Predicate<String> startsWithJ = s -> s != null && s.startsWith("J");
        Predicate<String> startsWithN = s -> s != null && s.startsWith("N");
        Predicate<String> endsWithA   = s -> s != null && s.endsWith("A");
        Predicate<String> check3 = (startsWithJ.or(startsWithN)).and(endsWithA);
        String[] samples3 = { "SEVA", "JAVA", "PRIORA", "TEST", null, "MILAN", "NTESTA", "NA" };
        for (String str : samples3) {
            System.out.printf("Строка: %s -> %b%n",
                    str == null ? "null" : "\"" + str + "\"",
                    check3.test(str));
        }

        System.out.println("\nЗадание 1.4: Лямбда выражение для HeavyBox.");
        Consumer<HeavyBox> shipped = box ->
                System.out.println("Отгрузилт ящик с весом " + box.getWeight());
        Consumer<HeavyBox> sending = box ->
                System.out.println("Отправляем ящик с весом " + box.getWeight());
        Consumer<HeavyBox> processBox = shipped.andThen(sending);
        HeavyBox box = new HeavyBox(50);
        processBox.accept(box);

        System.out.println("\nЗадание 1.5: Лямбда для Function.");
        Function<Integer, String> signFunction = n -> {
            if (n == null) return "Ноль";
            return n > 0 ? "Положительное число" : (n < 0 ? "Отрицательное число" : "Ноль");
        };
        Integer[] numbers = { null, -10, 0, 15 };
        for (Integer num : numbers) {
            System.out.printf("Число: %s -> %s%n",
                    num == null ? "null" : num.toString(),
                    signFunction.apply(num));
        }

        System.out.println("\nЗадание 1.6: Лямбда для Supplier.");
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);
        for (int i = 0; i < 5; i++) {
            System.out.println("Случ. число: " + randomSupplier.get());
        }

        System.out.println("\nЗадание 2.1: Кастомная аннотация @DeprecatedEx");
        handleDeprecatedEx(StariyClass.class);
    }

    public static void handleDeprecatedEx(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx anno = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("Внимание: класс '" + clazz.getSimpleName() + "' устарел. Альтернатива: '"
                    + anno.message() + "'");
        }
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx anno = m.getAnnotation(DeprecatedEx.class);
                System.out.println("Внимание: метод '" + m.getName() + "' устарел. Альтернатива: '"
                        + anno.message() + "'");
            }
        }
    }
}
