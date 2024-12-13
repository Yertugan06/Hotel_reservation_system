import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel_reservation_system hotel = new Hotel_reservation_system(123456789, "Hotel A", 0);

        // Array of guest
        Object[][] guests = {
                {123456789, "John", 1},
                {987654321, "Jane", 2},
                {111111111, "Alice", 3},
                {222222222, "Bob", 4},
                {333333333, "Charlie", 5},
                {444444444, "Diana", 6},
                {555555555, "Eve", 7},
                {666666666, "Frank", 8},
                {777777777, "Grace", 9},
                {888888888, "Hank", 10}
        };

        for (Object[] guest : guests) {
            int phoneNumber = (int) guest[0];
            String name = (String) guest[1];
            int roomNumber = (int) guest[2];
            hotel.room_details.put(roomNumber, name + " - " + phoneNumber);

            hotel.reserve_room("12:00", "16:00", roomNumber);
        }

        hotel.free_rooms("10:00", "18:00");
        hotel.free_the_room("12:00", "16:00", 1);
        hotel.get_price("12:00", "16:00");
        hotel.get_price_list();
        System.out.println(hotel.needed_hours("12:00", "01:00"));
        hotel.change_price(1, 1600);
        hotel.change_price(2, 1600);
        hotel.get_room_detailes(5);
        hotel.get_room_detailes(20);
    }
}
