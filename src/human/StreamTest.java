package human;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Human> humans1 = HumanGenerator.generate(10);
        List<Human> humans2 = HumanGenerator.generate(10);
        List<Human> humans3 = HumanGenerator.generate(10);

        List<List<Human>> megaList = List.of(humans1, humans2, humans3);

        Map<String, Human> res = megaList.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Human::getSalary))
                //.collect(Collectors.toMap(Human::getName, Human::getSalary));
                .collect(Collectors.toMap(Human::getName, Function.identity()));


//        for (Human h : res) {
//            System.out.println("h = " + h);
//        }
    }

    public static void a5() {
        List<Human> humans = HumanGenerator.generate(100);

        Optional<Human> res = humans.stream()
                .sorted(Comparator.comparing(Human::getSalary))
                .skip(1)
                .limit(1)
                .findFirst();

        System.out.println("res.get() = " + res.get());


//        for (Human h : res) {
//            System.out.println("h = " + h);
//        }
    }

    public static void a4() {
        List<Human> humans = HumanGenerator.generate(100);

        List<Human> res = humans.stream()
                .filter(h -> h.getSalary() > 2000)
                .sorted(Comparator.comparing(
                                Human::getSalary)
                        .reversed()
                        .thenComparing(Human::getName))
                .skip(10)
                .limit(5)
                .distinct()
                .collect(Collectors.toList());

        for (Human h : res) {
            System.out.println("h = " + h);
        }
    }

    public static void a3() {
        List<Human> humans = HumanGenerator.generate(20);

        List<Human> listToSort = new ArrayList<>();
//        for (Human h : humans) {
//            if (h.getSalary() > 1000 && h.getSalary() < 2000) {
//                listToSort.add(human);
//            }
//        }
//        listToSort.sort(Comparator.comparing(Human::getName).reversed());
//        List<Integer> toSort = new ArrayList<>();
//        for (Human human : listToSort) {
//            System.out.println(human);
//            Integer age = human.getAge();
//            toSort.add(age);
//        }
//        toSort.sort(null);
//        List<Integer> res = new ArrayList<>();
//        Set<Integer> uniqueValues = new HashSet<>();
//        for (Integer age : toSort) {
//            if (uniqueValues.add(age)) {
//                res.add(age);
//            }
//        }

        List<Integer> res = humans.stream()
                .filter(h -> h.getSalary() > 1000 && h.getSalary() < 2000)
                .sorted(Comparator.comparing(Human::getName).reversed())
                .peek(System.out::println)
                .map(h -> h.getAge())
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        for (Integer h : res) {
            System.out.println("h = " + h);
        }
    }

    public static void a2() {
        List<Human> humans = HumanGenerator.generate(20);

//        for (Human human : humans) {
//            if (human.getName().toLowerCase().startsWith("a")) {
//                if (human.getSalary() > 1000 && human.getSalary() < 2000) {
//                    res.add(human);
//                }
//            }
//        }

        List<Human> res = humans.stream()
                .filter(h -> h.getName().toLowerCase().startsWith("a"))
                .filter(h -> h.getSalary() > 1000 && h.getSalary() < 2000)
                .collect(Collectors.toList());


        for (Human h : res) {
            System.out.println("h = " + h);
        }
    }

    public static void a1() {
        List<Human> humans = HumanGenerator.generate(20);

//        for (Human h : humans) {
//            System.out.println("h = " + h);
//        }

        humans.stream()
                .peek(h -> System.out.println(h))
                .collect(Collectors.toList());

        //hStream.peek(System.out::println);
    }
}
