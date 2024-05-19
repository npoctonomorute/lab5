package lab_5.JSON;

import lab_5.App.CollectionManager;
import lab_5.Data.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

public class JsonParser {
    private final String fileName;

    public JsonParser(String fileName) {
        this.fileName = fileName;
    }

    public CollectionManager parse() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Worker> workers = gson.fromJson(reader, new TypeToken<List<Worker>>() {
        }.getType());
        CollectionManager collection = new CollectionManager();

        for (Worker worker : workers) {
            worker.setId(CollectionManager.generateId());
            worker.setCreationDate(new Date());
            try {
                long id = worker.getId();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            //long id = worker.getId();
            String name = worker.getName();
            if (name == null || name.isEmpty()) {
                System.out.println("Неверный формат имени.");
                System.exit(0);
            }


            try {
                double salary = worker.getSalary();
                if (salary < 0) {
                    System.out.println("Неверный формат зарплаты");
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }


            try {
                double x = worker.getPerson().getLocation().getX();
                double y = worker.getPerson().getLocation().getY();
                double z = worker.getPerson().getLocation().getZ();
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода координат");
                System.exit(0);
            }
            try {
                Date birthday = worker.getPerson().getBirthday();
            } catch (DateTimeException e) {
                System.out.println("Неверный формат ввода дня рождения");
                System.exit(0);
            }

            String locationName = worker.getPerson().getLocation().getName();
            if (locationName == null || locationName.isEmpty()) {
                System.out.println("Неверный формат имени локации.");
                System.exit(0);
            }
            Color hairColor = worker.getPerson().getHairColor();
            Country country = worker.getPerson().getNationality();
            Status status = worker.getStatus();
            Position position = worker.getPosition();
            Date creationDate = worker.getCreationDate();
            Date startDate = worker.getStartDate();

            boolean flag1 = false;
            for (Color i : Color.values()) {
                if (i == hairColor) {
                    flag1 = true;
                    break;
                }
            }
            if (!flag1) {
                System.out.println("Неверный формат данных для цвета волос.");
                System.exit(0);
            }

            boolean flag2 = false;
            for (Country i : Country.values()) {
                if (i == country) {
                    flag2 = true;
                    break;
                }
            }
            if (!flag2) {
                System.out.println("Неверный формат данных для национальности.");
                System.exit(0);
            }

            boolean flag3 = false;
            for (Status i : Status.values()) {
                if (i == status) {
                    flag3 = true;
                    break;
                }
            }
            if (!flag3) {
                System.out.println("Неверный формат данных для статуса.");
                System.exit(0);
            }

            boolean flag4 = false;
            for (Position i : Position.values()) {
                if (i == position) {
                    flag4 = true;
                    break;
                }
            }
            if (!flag4) {
                System.out.println("Неверный формат данных для position.");
                System.exit(0);
            }

            collection.add(worker);
        }
        return collection;
    }
}
