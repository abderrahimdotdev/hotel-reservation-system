package dev.abderrahim.hotel.entities;

import java.util.Date;

public record Booking(User user, Room room, Date checkIn, Date checkOut,int totalPrice) {

}
