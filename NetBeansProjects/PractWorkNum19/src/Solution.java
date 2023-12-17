import java.util.ArrayList;
import java.util.List;

public class Solution { //конвертация массива строк/чисел в список
    public static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] stringArray = {"Hello", "World"};
        List<String> stringList = arrayToList(stringArray);
        System.out.println(stringList);

        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = arrayToList(intArray);
        System.out.println(intList);
    }
}
