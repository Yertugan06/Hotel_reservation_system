import java.util.HashMap;

public class Guest {
    private int phone_number;
    private String name;

    public Guest(int phone_number, String name) {
        this.phone_number = phone_number;
        this.name = name;
    }

    public static void get_information(int room_number, HashMap<Integer, String> room_details) {
        System.out.println(room_details.getOrDefault(room_number, "No guest information available"));
        System.out.println();
    }
}
