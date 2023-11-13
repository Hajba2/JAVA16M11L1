import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> function = new Function<>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };

        Function<String, Integer> function2 = new Function<>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s) + 2;
            }
        };

        Integer i = function.apply("78");
        System.out.println("i = " + i);

        int res = method("9000000", function);
        int res2 = method("9000000", function2);
        System.out.println("res = " + res);
        System.out.println("res2 = " + res2);
    }

    public static int method(String str, Function<String, Integer> mapper) {
        if (str.length() > 30 || str.length() < 6) {
            throw new IllegalArgumentException("can`t pars this number");
        }
        return mapper.apply(str);
    }
}