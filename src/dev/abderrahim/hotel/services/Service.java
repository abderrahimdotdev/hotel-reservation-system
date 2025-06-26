package dev.abderrahim.hotel.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.SequencedCollection;

import dev.abderrahim.hotel.entities.Booking;
import dev.abderrahim.hotel.entities.Room;
import dev.abderrahim.hotel.entities.User;
import dev.abderrahim.hotel.types.RoomType;

public class Service {

    ArrayList<Room> rooms;
    ArrayList<User> users;
    SequencedCollection<Booking> bookings;

    public Service() {
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        bookings = new LinkedList<>();
    }

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {

        // Checking if room already exists
        Room room = findRoomByNumber(roomNumber);
        boolean roomExists = room != null;

        // If the room does not exist, we insert it
        if (!roomExists) {
            rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
        } else {
            room.setRoomNumber(roomNumber);
            room.setRoomType(roomType);
            room.setPrice(roomPricePerNight);
        }
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {

    }

    public void printAll() {

    }

    public void setUser(int userId, int balance) {

    }

    public void printAllUsers() {

    }

    // -- Helping methods --

    private Room findRoomByNumber(int roomNumber) {
        return rooms.stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
    }

}
