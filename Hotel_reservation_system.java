import java.util.HashMap;

public class HotelReservationSystem {
    protected int phone_number;
    protected String name;
    protected int twenty_four_hour_price = 20000;
    protected int twelve_hour_price = 12000;
    protected int one_hour_price = 1500;
    public int[][] rooms = new int[61][25];
    protected HashMap<Integer, String> room_details = new HashMap<>();
    private Room room;
    private Booking booking;

    public HotelReservationSystem(int phone_number, String name) {
        this.phone_number = phone_number;
        this.name = name;
        this.room = new Room(rooms, room_details);
        this.booking = new Booking(rooms);
    }

    public void change_price(int time, int changing_price) {
        if (time == 24) {
            twenty_four_hour_price = changing_price;
        } else if (time == 12) {
            twelve_hour_price = changing_price;
        } else if (time == 1) {
            one_hour_price = changing_price;
        } else {
            wrong_input();
        }
    }

    public void get_price_list() {
        System.out.println("Price for 24 hours is: " + twenty_four_hour_price + " tenge");
        System.out.println("Price for 12 hours is: " + twelve_hour_price + " tenge");
        System.out.println("Price for 1 hour is: " + one_hour_price + " tenge");
        System.out.println();
    }

    public static int needed_hours(String start_time, String end_time) {
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        int total_hours = end - start;
        if (total_hours < 0) {
            total_hours += 24;
        }
        return total_hours;
    }

    public void free_room(String start_time, String end_time, int room_number) {
        room.free_room(start_time, end_time, room_number);
    }

    public void free_rooms(String start_time, String end_time) {
        room.free_rooms_list(start_time, end_time);
    }

    public void get_room_details(int room_number) {
        Guest.get_information(room_number, room_details);
    }

    public void get_price(String start_time, String end_time) {
        booking.price(start_time, end_time, twenty_four_hour_price, twelve_hour_price, one_hour_price);
    }

    public void reserve(String start_time, String end_time, int room_number) {
        booking.reserve_room(start_time, end_time, room_number);
    }

    public void put_information(int phone_number, String name, int room_number) {
        room.put_information(phone_number, name, room_number);
    }

    public void remove(int room_number) {
        room.remove(room_number);
    }

    public void wrong_input() {
        System.out.println("Input is wrong");
        System.out.println();
    }
}
