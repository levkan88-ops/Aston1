import java.util.List;

public class Main {
    public static void main(String[] args) {

        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Алексеев", "+7-123-456-78-90");
        phoneDirectory.add("Ветров", "+7-987-654-32-10");
        phoneDirectory.add("Сидорова", "+7-111-222-33-44");
        phoneDirectory.add("Алексеев", "+7-555-666-77-88");
        phoneDirectory.add("Ветров", "+7-999-888-77-66");

        phoneDirectory.printAll();
        System.out.println();

        System.out.println("Поиск номеров телефонов:");

        List<String> sidorovaPhones = phoneDirectory.get("Сидорова");
        System.out.println("Сидорова: " + sidorovaPhones);

        List<String> ivanovPhones = phoneDirectory.get("Алексеев");
        System.out.println("Алексеев: " + ivanovPhones);

        List<String> petrovPhones = phoneDirectory.get("Ветров");
        System.out.println("Ветров: " + petrovPhones);

        List<String> unknownPhones = phoneDirectory.get("Кузнецов");
        System.out.println("Кузнецов: " + unknownPhones);

        System.out.println("\nОбработка результатов поиска:");
        List<String> foundPhones = phoneDirectory.get("Алексеев");
        if (foundPhones.isEmpty()) {
            System.out.println("Фамилия Алексеев не найдена в справочнике.");
        } else {
            System.out.println("Найдено " + foundPhones.size() + " номер(а/ов) для Алексеев:");
            for (int i = 0; i < foundPhones.size(); i++) {
                System.out.println((i + 1) + ". " + foundPhones.get(i));
            }
        }

        System.out.println("\nДополнительная информация:");
        System.out.println("Всего уникальных фамилий: " + phoneDirectory.size());
        System.out.println("Есть ли фамилия 'Сидорова'? " + phoneDirectory.containsLastName("Сидорова"));
        System.out.println("Есть ли фамилия 'Кузнецов'? " + phoneDirectory.containsLastName("Кузнецов"));
    }
}
