import java.util.function.Function;

public class Lbd {

    public static void main(String[] args) {
        Function<String, Integer> function = new Function<>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };

        Function<String, Integer> function1 = (String s) -> {
            System.out.println("asdasd");
            return Integer.valueOf(s);
        };

        Function<String, Integer> function2 = (String s) -> {
            return Integer.valueOf(s);
        };
        Function<String, Integer> function3 = (String s) -> Integer.valueOf(s);
        Function<String, Integer> function4 = (s) -> Integer.valueOf(s);
        Function<String, Integer> function5 = s -> Integer.valueOf(s);
    }
}
