public class MapTest {

    public static void main(String[] args) {
        String stmt = "A quick brown fox jumps over the lazy dog owl";

        MapTest m = new MapTest();
        m.arrange(stmt);
    }

    private void arrange(String stmt) {
        Map<String, String> mp = Arrays.stream(stmt.split(" "))
                .collect(Collectors.toMap(
                        word -> word.substring(0, 1), // Extract first character as key
                        word -> word,                 // Use entire word as value
                        (oldValue, newValue) -> newValue, // Handle potential duplicates
                        TreeMap::new                  // Ensure natural ordering of keys
                ));

        mp.entrySet().forEach(entry -> System.out.println("key " + entry.getKey() + " Value " + entry.getValue()));
    }
}
