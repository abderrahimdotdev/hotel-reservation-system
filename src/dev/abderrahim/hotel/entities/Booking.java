package dev.abderrahim.hotel.entities;

import java.util.Date;

public record Booking(User user, Room room, Date checkIn, Date checkOut,int totalPrice) {

    public Booking{
        // We make a defensive copy to protect from external modifications to user and room objects
        user = new User(user.getId(),user.getBalance());
        room = new Room(room.getRoomNumber(),room.getType(),room.getPrice());
    }
}
