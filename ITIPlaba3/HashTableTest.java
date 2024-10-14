public class HashTableTest {
    public static void main(String[] args) {
        // Создаём хэш-таблицу с небольшой ёмкостью для повышения вероятности коллизий
        HashTable<String, Integer> hashTable = new HashTable<>(3);

        // Добавляем элементы с разными ключами, но они могут коллизировать в малой таблице
        hashTable.put("apple", 5);  // Вероятно попадёт в индекс 1
        hashTable.put("banana", 3); // Может попасть в индекс 1 (коллизия с "apple")
        hashTable.put("orange", 7); // Тоже может коллизировать

        // Проверяем, что все элементы добавлены и доступны через get()
        System.out.println("Значение для 'apple': " + hashTable.get("apple"));  // Ожидается 5
        System.out.println("Значение для 'banana': " + hashTable.get("banana")); // Ожидается 3
        System.out.println("Значение для 'orange': " + hashTable.get("orange")); // Ожидается 7

        // Печатаем размер таблицы, чтобы убедиться, что все элементы добавлены
        System.out.println("Размер таблицы: " + hashTable.size());  // Ожидается 3

        // Проверяем, что удаление элемента корректно работает
        hashTable.remove("banana");
        System.out.println("Значение для 'banana' после удаления: " + hashTable.get("banana")); // Ожидается null
        System.out.println("Размер таблицы после удаления: " + hashTable.size());  // Ожидается 2

        // Проверяем, что остальные элементы всё ещё на месте
        System.out.println("Значение для 'apple': " + hashTable.get("apple"));  // Ожидается 5
        System.out.println("Значение для 'orange': " + hashTable.get("orange")); // Ожидается 7
    }
}
