
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test {
    public static void main(String[] args) {
        //Task1
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(26, 54, 78, 88, 99, 66, 21, 44, 15, 25)).stream();

        findMinMax(
                stream,
                Integer::compareTo,
                (x, y) -> System.out.printf("Минимальное число: %s, максимальное число: %s%n", x, y)
        );

        stream.close();

        //Task 2
        List<Integer> numbers =
                List.of(0, 4, 6, 7, 2, 1, 5, 9, 7, 25, 25, 14, 13, 86, 35, 25, 8, 4, 3, 54, 522, 52, 94, 88, 17, 25);
        numbersOfDigit(numbers);
    }


    private static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> nums = stream.sorted(order).collect(Collectors.toList());
        if (!nums.isEmpty()) {
            minMaxConsumer.accept(nums.get(0), nums.get(nums.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }


    private static void numbersOfDigit(List<Integer> nums) {
        System.out.println("Четные числа:" + nums.stream()
                .filter(integer -> integer % 2 == 0)
                .count());
    }
}
