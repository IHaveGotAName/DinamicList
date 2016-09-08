/**
 * Created by podd-_000 on 08.09.2016.
 */
public class DynamicStringList implements SimpleList{

    public static void main(String[] args) {
        DynamicStringList list = new DynamicStringList();
        list.add("Я нарочно иду нечесаным");
        list.add("С головой, как керосиновая лампа, на плечах");
        list.add("Ваших душ безлиственную осень");
        list.add("Мне нравится в потемках освещать");
        list.add("Мне нравится, когда каменья брани");
        list.add("Летят в меня, как град грозы");
        list.add("Я только крепче жму руками");
        list.add("Моих волос качнувшихся пузырь");
        System.out.println("Добавление:");
        System.out.println(list);
        System.out.println("Извлечение последнего элемента:");
        System.out.println(list.get());
        System.out.println("Извлечение 3 элемента:");
        System.out.println(list.get(3));
        System.out.println("Удаление последнего элемента:");
        list.remove();
        System.out.println(list);
        System.out.println("Удаление 5 элемента:");
        list.remove(5);
        System.out.println(list);
        System.out.println("Удаление всех элементов:");
        list.delete();
        System.out.println(list);

    }


    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int index;

    public DynamicStringList() {
        elements= new String [DEFAULT_CAPACITY];
    }

    public DynamicStringList(int capacity) {
        elements = new String[capacity];
    }

    public void add(String element) {
        if (index == elements.length)
            growArray();
        elements[index++] = element;
    }

    private void growArray() {
        String[] newArray = new String[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    public String get() {
        return elements[index - 1];
    }


    public String get(int id) {

        return elements[id];
    }

    public String remove() {
        String result = elements[index - 1];
        index--;
        return result;
    }

    public String remove(int id) {
        String result = get(id);
        System.arraycopy(elements, id+1 , elements, id, index - id -1);
        index--;
        return result;
    }

    public boolean delete() {
        if (index == 0)
            return false;

        index = 0;
        elements = new String[DEFAULT_CAPACITY];
        return true;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < index; i++) {
            result += elements[i] + " |";
        }
        result += "]";
        return result;
    }
}

