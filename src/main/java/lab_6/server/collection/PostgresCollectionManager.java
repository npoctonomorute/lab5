package lab_6.server.collection;

import lab_6.common.Classes.*;
import lab_6.common.Classes.dto.WorkerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PostgresCollectionManager {
    private final Connection connection;

    private Map<Long, Worker> map = Collections.synchronizedMap(new HashMap<>());

    public PostgresCollectionManager(Connection connection) {
        this.connection = connection;
        map = loadMap();
    }

    private Map<Long, Worker> loadMap() {
        try {
            Map<Long, Worker> result = Collections.synchronizedMap(new HashMap<>());
            ResultSet resultSet = connection.createStatement().executeQuery("select * from workers");
            while (resultSet.next()) {
                Worker worker = transformResultSetToWorker(resultSet);
                result.put(worker.getId(), worker);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Worker transformResultSetToWorker(ResultSet resultSet) throws SQLException {
        WorkerDTO workerDTO = new WorkerDTO();
        long id = resultSet.getLong("id");
        Date creationDate = resultSet.getDate("creation_date");
        workerDTO.setName(resultSet.getString("name"));
        workerDTO.setSalary(resultSet.getDouble("salary"));
        workerDTO.setStartDate(resultSet.getDate("start_date"));
        workerDTO.setPosition(Position.values()[resultSet.getInt("position")]);
        workerDTO.setStatus(Status.values()[resultSet.getInt("status")]);
        workerDTO.setPerson(new Person(
                resultSet.getDate("p_birthday"),
                Color.values()[resultSet.getInt("p_hair_color")],
                Country.values()[resultSet.getInt("p_hair_color")],
                new Location(
                        resultSet.getDouble("p_loc_x"),
                        resultSet.getDouble("p_loc_y"),
                        resultSet.getDouble("p_loc_z"),
                        resultSet.getString("p_loc_name")
                )
        ));
        return new Worker(id, workerDTO, creationDate);
    }

    public Map<Long, Worker> getMap() {
        return map;
    }

    public int getSize() {
        return map.size();
    }

    public String getType() {
        return map.getClass().getSimpleName();
    }

    public int clear() {
        try {
            PreparedStatement ps1 = connection.prepareStatement("select count(*) from workers");
            ResultSet resultSet = ps1.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");
            PreparedStatement ps2 = connection.prepareStatement("delete from workers where true");
            ps2.execute();
            map = loadMap();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public int clearCollection(User user) {
//        try {
//            PreparedStatement ps1 = connection.prepareStatement("select count(*) from persons where owner_login = ?");
//            ps1.setString(1, user.getLogin());
//            ResultSet resultSet = ps1.executeQuery();
//            resultSet.next();
//            int count = resultSet.getInt("count");
//            PreparedStatement ps2 = connection.prepareStatement("delete from persons where owner_login = ?");
//            ps2.setString(1, user.getLogin());
//            ps2.execute();
//            collection = loadCollection();
//            return count;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public boolean removeKey(Long key) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from workers where id = ? returning *");
            preparedStatement.setLong(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            map = loadMap();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Worker createWorker(WorkerDTO workerDTO) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into workers (name, salary, start_date, position, status, p_birthday, p_hair_color, p_nationality, p_loc_x, p_loc_y, p_loc_z, p_loc_name) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *"
            );
            prepareStatementWithData(ps, workerDTO);
            // ps.setString(13, workerDTO.getOwnerLogin());
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            Worker worker = transformResultSetToWorker(resultSet);
            map.put(worker.getId(), worker);
            return worker;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Worker updateWorker(Long id, WorkerDTO workerDTO) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update workers set name = ?, salary = ?, start_date = ?, position = ?, status = ?, p_birthday = ?, p_hair_color = ?, p_nationality = ?, p_loc_x = ?, p_loc_y = ?, p_loc_z = ?, p_loc_name = ?"
                            + " where id = ? returning *"
            );
            prepareStatementWithData(ps, workerDTO);
            ps.setLong(13, id);
            // ps.setString(14, workerDTO.getOwnerLogin());
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            Worker worker = transformResultSetToWorker(resultSet);
            map.put(worker.getId(), worker);
            return worker;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void prepareStatementWithData(PreparedStatement statement, WorkerDTO workerDTO) throws SQLException {
        statement.setString(1, workerDTO.getName());
        statement.setDouble(2, workerDTO.getSalary());
        statement.setDate(3, new Date(workerDTO.getStartDate().getTime()));
        statement.setInt(4, workerDTO.getPosition().ordinal());
        statement.setInt(5, workerDTO.getStatus().ordinal());
        Person person = workerDTO.getPerson();
        if (person != null) {
            statement.setDate(6, new Date(person.getBirthday().getTime()));
            statement.setInt(7, person.getHairColor().ordinal());
            statement.setInt(8, person.getNationality().ordinal());
            Location location = person.getLocation();
            statement.setDouble(9, location.getX());
            statement.setDouble(10, location.getY());
            statement.setDouble(11, location.getZ());
            statement.setString(12, location.getName());
        } else {
            statement.setNull(6, Types.DATE);
            statement.setNull(7, Types.INTEGER);
            statement.setNull(8, Types.INTEGER);
            statement.setNull(9, Types.DOUBLE);
            statement.setNull(10, Types.DOUBLE);
            statement.setNull(11, Types.DOUBLE);
            statement.setNull(12, Types.VARCHAR);
        }
    }

    public ArrayList<Worker> filterByPerson(Person person) {
        try {
            ArrayList<Worker> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(
                    "select * from workers where p_birthday = ? and p_hair_color = ? and p_nationality = ? " +
                            "and p_loc_x = ? and p_loc_y = ? and p_loc_z = ? and p_loc_name = ?"
            );
            ps.setDate(1, new Date(person.getBirthday().getTime()));
            ps.setInt(2, person.getHairColor().ordinal());
            ps.setInt(3, person.getNationality().ordinal());
            Location location = person.getLocation();
            ps.setDouble(4, location.getX());
            ps.setDouble(5, location.getY());
            ps.setDouble(6, location.getZ());
            ps.setString(7, location.getName());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Worker worker = transformResultSetToWorker(resultSet);
                result.add(worker);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
