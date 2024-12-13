import java.util.HashMap;
public class Hotel_reservation_system {

    private int phone_number;
    private String name;
    private int twenty_four_hour_price = 20000;
    private int twelve_hour_price = 12000;
    private int one_hour_price = 1500;
    public int[][] rooms = new int[61][25];
    public HashMap<Integer, String> room_details = new HashMap<>();

    public Hotel_reservation_system(int phone_number, String name, int room_number) {
        this.phone_number = phone_number;
        this.name = name;
        room_details.put(room_number, name + " - " + phone_number);
    }

    public void change_price(int time, int changing_price) {
        if (time == 24) {
            this.twenty_four_hour_price = changing_price;
        }
        else if (time == 12) {
            this.twelve_hour_price = changing_price;
        }
        else if (time == 1) {
            this.one_hour_price = changing_price;
        }
        else {
            wrong_input();
        }
    }

    public void get_price_list() {
            System.out.println("Price for 24 hours is : " + twenty_four_hour_price + " tenge");
            System.out.println("Price for 12 hours is : " + twelve_hour_price + " tenge");
            System.out.println("Price for 1 hour is : " + one_hour_price + " tenge");
            System.out.println();
    }

    public int needed_hours(String start_time, String end_time) {
        int num1 = Integer.parseInt(start_time.substring(0, 2));
        int num2 = Integer.parseInt(end_time.substring(0, 2));
        int total_hours = num2 - num1;
        if (total_hours < 0) {
            total_hours += 24;
        }
        return total_hours;
    }

    public void free_the_room(String start_time, String end_time, int room_number){
        room_details.remove(room_number);
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        if (start - end < 0) {
            end += 24;
        }
        for (int i = start; i < end; i++) {
            rooms[room_number][i % 24] = 0;
        }
        System.out.println("Room : " + room_number + " is free");
        System.out.println();
    }

    public void free_rooms(String start_time, String end_time){
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        if (start - end < 0) {
            end += 24;
        }

        System.out.println("Available rooms:");
        for (int room = 1; room < rooms.length; room++) {
            boolean isFree = true;
            for (int i = start; i < end; i++) {
                if (rooms[room][i % 24] == 1) {
                    isFree = false;
                    break;
                }
            }
            if (isFree) {
                System.out.println("Room " + room);
            }
        }
        System.out.println();
    }


    public void get_room_detailes(int room_number){
        System.out.println(room_details.getOrDefault(room_number, "No guest information available"));
        System.out.println();
    }


    public void get_price(String start_time, String end_time){
        int needed_hours = needed_hours(start_time, end_time);
        int total_price =  twelve_hour_price * needed_hours / 24 + twelve_hour_price * ((needed_hours % 24) / 12) + one_hour_price * (needed_hours % 12);
        System.out.println("Total price is : " + total_price + " tenge");
        System.out.println();
    }

    public void reserve_room(String start_time, String end_time, int room_number) {
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        if (start - end < 0) {
            end += 24;
        }
        boolean isFree = true;
        for (int i = start; i < end; i++) {
            if (rooms[room_number][i % 24] == 1) {
                isFree = false;
                break;
            }
        }
        if (isFree) {
            for (int i = start; i < end; i++) {
                rooms[room_number][i % 24] = 1;
            }
            System.out.println("Room " + room_number + " reserved from " + start_time + " to " + end_time);
        }
        else {
            System.out.println("Room " + room_number + " is not available.");
        }
        System.out.println();
    }

    public void wrong_input() {
        System.out.println("Input is wrong");
        System.out.println();
    }

}