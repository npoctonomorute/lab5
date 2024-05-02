//package App;
//
//import Data.*;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
//public class Converter {
//    public static HashMap<String, Object> workerToMap(Worker worker){
//        HashMap<String, Object> data = new LinkedHashMap<>();
//        data.put("id", worker.getId());
//        data.put("name", worker.getName());
//        data.put("creationDate", worker.getCreationDate());
//        data.put("salary", worker.getSalary());
//        data.put("startDate", worker.getStartDate());
//        data.put("position", worker.getPosition());
//        data.put("status", worker.getStatus());
//        data.put("birthday", worker.getPerson().getBirthday());
//        data.put("hairColor", worker.getPerson().getHairColor());
//        data.put("nation", worker.getPerson().getNationality());
//        data.put("coordinatesX", worker.getPerson().getLocation().getX());
//        data.put("coordinatesY", worker.getPerson().getLocation().getY());
//        data.put("coordinatesZ", worker.getPerson().getLocation().getZ());
//        data.put("locationName", worker.getPerson().getLocation().getName());
//        return data;
//    }
//
//    public static String mapToJson(HashMap<String, Object> map){
//        StringBuilder json = new StringBuilder();
//        json.append("{\n");
//        for (HashMap.Entry<String, Object> entry : map.entrySet()){
//            json.append("\t\"").append(entry.getKey()).append("\":");
//            if ((entry.getValue() instanceof Boolean) || (entry.getValue() instanceof Integer)){
//                json.append(entry.getValue());
//            } else {
//                json.append("\"").append(entry.getValue()).append("\"");
//            }
//            json.append(",\n");
//        }
//        json.deleteCharAt(json.length() - 2);
//        json.append("},\n");
//        return json.toString();
//    }
//
//    public static String tabJson(String json){
//        String[] rows = json.split("\n");
//        StringBuilder tabbedJson = new StringBuilder();
//        for (String row : rows){
//            tabbedJson.append("\n\t").append(row);
//        }
//        return tabbedJson.toString();
//    }
//
//    public static Worker parsedToWorker(WorkerParsedData workerParsedData) {
//        WorkerData worker = new WorkerData();
//        worker.setName(workerParsedData.getName());
//        Location location = new Location();
//        location.setX(workerParsedData.getX());
//        location.setY(workerParsedData.getY());
//        location.setZ(workerParsedData.getZ());
//        location.setName(workerParsedData.getLocationName());
//        Person person = new Person();
//        person.setBirthday(workerParsedData.getBirthday());
//        person.setHairColor(workerParsedData.getHairColor());
//        person.setLocation(location);
//        worker.setPerson(person);
//        worker.setPosition(workerParsedData.getPosition());
//        worker.setStatus(workerParsedData.getStatus());
//        return new Worker(workerParsedData.getId(), worker);
//    }
//}