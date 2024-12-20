public class Booking {
    private int[][] rooms;

    public Booking(int[][] rooms) {
        this.rooms = rooms;
    }

    public void reserve_room(String start_time, String end_time, int room_number) {
        int start = Integer.parseInt(start_time.substring(0, 2));
        int end = Integer.parseInt(end_time.substring(0, 2));
        if (end < start) {
            end += 24;
        }
        boolean is_free = true;
        for (int i = start; i < end; i++) {
            if (rooms[room_number][i % 24] == 1) {
                is_free = false;
                break;
            }
        }
        if (is_free) {
            for (int i = start; i < end; i++) {
                rooms[room_number][i % 24] = 1;
            }
            System.out.println("Room " + room_number + " reserved from " + start_time + " to " + end_time);
        } else {
            System.out.println("Room " + room_number + " is not available.");
        }
        System.out.println();
    }

    public void price(String start_time, String end_time, int twenty_four_hour_price, int twelve_hour_price, int one_hour_price) {
        int needed_hours = HotelReservationSystem.needed_hours(start_time, end_time);
        int total_price = twenty_four_hour_price * (needed_hours / 24)
                + twelve_hour_price * ((needed_hours % 24) / 12)
                + one_hour_price * (needed_hours % 12);
        System.out.println("Total price is: " + total_price + " tenge");
        System.out.println();
    }
}
