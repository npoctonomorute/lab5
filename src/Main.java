import Data.Collection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Collection cal = new Collection();
        cal.show();
        cal.insert(19, "саня");
        cal.show();
        cal.clear();
        cal.show();
    }
}