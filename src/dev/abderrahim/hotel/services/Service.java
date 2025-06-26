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

        User user = findUserById(userId);
        boolean userExists = users != null;

        if (!userExists) {
            users.add(new User(userId, balance));
        } else {
            user.setBalance(balance);
        }
    }

    public void printAllUsers() {

        printTitle("Users:");
        printColumns("UserID", "Balance");
        System.out.println();

        for (int i = users.size() - 1; i >= 0; i--) {
            User u = users.get(i);
            printColumns("" + u.getId(), "" + u.getBalance());
        }

    }

    // -- Helping methods --

    private User findUserById(int userId) {
        return users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
    }

    private Room findRoomByNumber(int roomNumber) {
        return rooms.stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
    }

    private void printTitle(String headline) {
        System.out.println("=".repeat(headline.length()));
        System.out.println(headline);
        System.out.println("=".repeat(headline.length()));
    }

    private void printColumns(String... columns) {
        for (String s : columns) {
            System.out.printf("%-20s", s);
        }
        System.out.println();
    }

}
