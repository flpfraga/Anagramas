package resources;

import java.util.Set;

public class AnagramMockTest {

    public static Set<String> getAnagramsABCD() {
        return Set.of(
                "[c, b, d, a]",
                "[d, b, a, c]",
                "[c, a, d, b]",
                "[d, c, a, b]",
                "[a, c, d, b]",
                "[c, b, a, d]",
                "[a, d, b, c]",
                "[a, b, d, c]",
                "[c, d, a, b]",
                "[a, c, b, d]",
                "[d, b, c, a]",
                "[c, a, b, d]",
                "[b, a, d, c]",
                "[b, c, d, a]",
                "[b, a, c, d]",
                "[a, d, c, b]",
                "[d, a, c, b]",
                "[a, b, c, d]",
                "[c, d, b, a]",
                "[d, a, b, c]",
                "[d, c, b, a]",
                "[b, c, a, d]",
                "[b, d, c, a]",
                "[b, d, a, c]"
        );

    }
}
