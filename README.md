# Hotel Reservation System

A comprehensive Java project to manage hotel reservations.

## Features

- **Reservation Management:**
  - Book and manage hotel room reservations.
  - Check room availability for specific dates and times.
  - Cancel and update reservations.

- **Room Management:**
  - Maintain room details, including room number and guest information.
  - Track room availability across different times of the day.
  - List all available rooms for a given time period.

- **Pricing Management:**
  - Set and update room prices for different time periods (1 hour, 12 hours, 24 hours).
  - Retrieve the current price list.
  - Calculate total price based on reservation duration.

- **Guest Information:**
  - Store guest information including phone number and name.
  - Retrieve guest details based on room number.
  - Remove guest information when the room is freed.

- **Utility Functions:**
  - Calculate needed hours between two given times.
  - Handle incorrect inputs gracefully.

## Classes

### HotelReservationSystem

Manages hotel reservations, room availability, pricing, and includes guest information.

### Room

Handles room-related information and operations such as adding, freeing, and listing rooms.

### Guest

Stores and retrieves guest information.

### Booking

Manages booking operations including reservation, price calculation, and checking availability.
