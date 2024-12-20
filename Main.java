import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelReservationSystem hotel = new HotelReservationSystem(123456789, "Hotel A");

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
            int phone_number = (int) guest[0];
            String name = (String) guest[1];
            int room_number = (int) guest[2];
            hotel.put_information(phone_number, name, room_number);
            hotel.reserve("12:00", "16:00", room_number);
        }

        hotel.free_rooms("10:00", "18:00");
        hotel.free_room("12:00", "16:00", 1);
        hotel.get_price("12:00", "16:00");
        hotel.get_price_list();
        System.out.println("Needed hours: " + hotel.needed_hours("12:00", "01:00"));
        hotel.change_price(1, 1600);
        hotel.change_price(2, 1600);
        hotel.get_room_details(5);
        hotel.get_room_details(20);
    }
}
