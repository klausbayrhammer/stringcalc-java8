import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalc {
    public static int calc(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        List<String> strings = getTokens(input);
        if (getIntStream(strings).anyMatch((x) -> x < 0)) {
            return throwExceptionWithNegativeValues(strings);
        }

        return getIntStream(strings).filter((x) -> x < 1000).sum();
    }

    private static int throwExceptionWithNegativeValues(List<String> strings) {
        IntStream negativeValues = getIntStream(strings).filter((x) -> x < 0);
        throw new IllegalArgumentException("Negatives not supported" + negativeValues.mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private static List<String> getTokens(String input) {
        String[] tokens = input.split(",");
        return Arrays.asList(tokens);
    }

    private static IntStream getIntStream(List<String> strings) {
        return strings.stream().mapToInt(Integer::valueOf);
    }
}
