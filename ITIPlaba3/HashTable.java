import java.util.LinkedList;

// Класс для хранения пар ключ-значение
class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

// Реализация хэш-таблицы с использованием метода цепочек
public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    // Хэш-функция для вычисления индекса
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    // Метод для добавления элемента
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value); // Если ключ уже существует, обновляем значение
                return;
            }
        }

        table[index].add(new Entry<>(key, value)); // Добавляем новую пару
        size++;
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null; // Возвращаем null, если ключ не найден
    }

    // Метод для удаления элемента по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    // Метод для проверки размера таблицы
    public int size() {
        return size;
    }

    // Метод для проверки пустоты таблицы
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Добавление элементов
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);
        hashTable.put("pear", 2);

        // Поиск элементов
        System.out.println("Значение для ключа 'apple': " + hashTable.get("apple"));
        System.out.println("Значение для ключа 'banana': " + hashTable.get("banana"));

        // Удаление элемента
        hashTable.remove("banana");
        System.out.println("Значение для ключа 'banana' после удаления: " + hashTable.get("banana"));

        // Размер таблицы
        System.out.println("Размер таблицы: " + hashTable.size());
        System.out.println("Таблица пуста? " + hashTable.isEmpty());
    }
}
