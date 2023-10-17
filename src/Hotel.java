import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String location;
    private List<Room> rooms;

    public Hotel(int id, String name, String location, List<Room> rooms) {
        setId(id);
        setName(name);
        setLocation(location);
        setRooms(rooms);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
