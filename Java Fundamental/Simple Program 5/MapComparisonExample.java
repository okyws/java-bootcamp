import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapComparisonExample {
  public static void main(String[] args) {
    // Using HashMap
    System.out.println("HashMap:");
    Map<String, Integer> hashMap = new HashMap<>();
    hashMap.put("apple", 1);
    hashMap.put("banana", 2);
    hashMap.put("orange", 3);
    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }

    // Using LinkedHashMap
    System.out.println("\nLinkedHashMap:");
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put("apple", 1);
    linkedHashMap.put("banana", 2);
    linkedHashMap.put("orange", 3);
    for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }
}
