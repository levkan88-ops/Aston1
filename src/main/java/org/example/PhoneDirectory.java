import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> phoneBook;

    public PhoneDirectory() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {

    phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
       
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    public void printAll() {
        if (phoneBook.isEmpty()) {
            System.out.println("Телефонный справочник пуст.");
            return;
        }

        System.out.println("Телефонный справочник:");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public boolean containsLastName(String lastName) {
        return phoneBook.containsKey(lastName);
    }

    public int size() {
        return phoneBook.size();
    }
}
