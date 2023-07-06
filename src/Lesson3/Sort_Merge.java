package Lesson3;
import java.util.Arrays;

class Main
{
    // Реализация алгоритма сортировки слиянием в Java
    public static void main(String[] args)
    {
        int[] arr = { 12, 3, 18, 24, 0, 5, -2, 23, 2, 19};
        int[] aux = Arrays.copyOf(arr, arr.length);

        // сортируем массив `arr`, используя вспомогательный массив `aux`
        mergesort(arr, aux, 0, arr.length - 1);

        if (isSorted(arr)) {
            System.out.println(Arrays.toString(arr));
        }
    }
    // Объединяем два отсортированных подмассива `arr[low…mid]` и `arr[mid+1…high]`
    public static void merge(int[] arr, int[] aux, int low, int mid, int high)
    {
        int k = low, i = low, j = mid + 1;

        // пока есть элементы в левом и правом рядах
        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
            }
        }

        // копируем оставшиеся элементы
        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        // Вторую половину копировать не нужно (поскольку остальные элементы
        // уже находятся на своем правильном месте во вспомогательном массиве)

        // копируем обратно в исходный массив, чтобы отразить порядок сортировки
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }

    // Сортируем массив `arr[low…high]`, используя вспомогательный массив `aux`
    public static void mergesort(int[] arr, int[] aux, int low, int high)
    {
        // базовый вариант
        if (high <= low) {        // если размер прогона <= 1
            return;
        }

        // найти середину
        int mid = (low + ((high - low) >> 1));

        // рекурсивно разделяем прогоны на две половины до тех пор, пока размер прогона не станет <= 1,
        // затем объединяем их и возвращаемся вверх по цепочке вызовов

        mergesort(arr, aux, low, mid);          // разделить/объединить левую половину
        mergesort(arr, aux, mid + 1, high);     // разделить/объединить правую половину

        merge(arr, aux, low, mid, high);        // объединяем две половинки
    }

    // Функция для проверки, отсортирован ли arr в порядке возрастания или нет
    public static boolean isSorted(int[] arr)
    {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (prev > arr[i])
            {
                System.out.println("MergeSort Fails!!");
                return false;
            }
            prev = arr[i];
        }

        return true;
    }


}