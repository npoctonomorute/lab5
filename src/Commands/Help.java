package Commands;

import Data.Collection;

public class Help implements Command {

    private final Collection collection;

    public Help(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("insert (null {element}) : добавить новый элемент с заданным ключом");
        System.out.println("update (id {element}) : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_key null : удалить элемент из коллекции по его ключу");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script (file_name) : считать и исполнить скрипт из указанного файла");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_greater ({element}) : удалить из коллекции все элементы, превышающие заданный");
        System.out.println("remove_lower ({element}) : удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("replace_if_greater (null {element}) : заменить значение по ключу, если новое значение больше старого");
        System.out.println("remove_all_by_position (position) : удалить из коллекции все элементы, значение поля position которого эквивалентно заданному");
        System.out.println("filter_by_person (person) : вывести элементы, значение поля person которых равно заданному");
        System.out.println("filter_contains_name (name) : вывести элементы, значение поля name которых содержит заданную подстроку");
    }
}
