package dev.abderrahim.hotel.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.SequencedCollection;

import dev.abderrahim.hotel.entities.Booking;
import dev.abderrahim.hotel.entities.Room;
import dev.abderrahim.hotel.entities.User;
import dev.abderrahim.hotel.types.RoomType;

public class Service {

    private ArrayList<Room> rooms;
    private ArrayList<User> users;
    private SequencedCollection<Booking> bookings;

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
        
        User user = findUserById(userId);
        Room room = findRoomByNumber(roomNumber);
        
        if (user == null) {
            System.err.printf("User with id %s does not exist.%n", userId);
            return;
        } else if (room == null) {
            System.err.printf("Room number %s does not exist.%n", roomNumber);
            return;
        } else if (checkIn.after(checkOut)) {
            System.err.println("Check-in date cannot be greater or equal than check-out date.");
            return;
        }
        else if (!isAvailable(room.getRoomNumber(),checkIn,checkOut)){
            System.err.println("Room not available at the specified date.");
            return;
        }
        
        long nights = ChronoUnit.DAYS.between(checkIn.toInstant(), checkOut.toInstant());
        int totalPrice = (int) nights * room.getPrice();

        if (totalPrice > user.getBalance()) {
            System.err.printf("""
                    The user does not have enough balance to book the room number %s for the specified period
                    %n""", room.getRoomNumber());
        }
        else{
            bookings.addFirst(new Booking(user, room, checkIn, checkOut, totalPrice));
            user.setBalance(user.getBalance() - totalPrice);
        }

    }

    public void printAll() {

        printTitle("Rooms:");
        printColumns("RoomNumber", "RoomType", "PricePerNight");
        System.out.println();

        for(int i = rooms.size() - 1 ; i >=0 ; i--){
            Room currentRoom = rooms.get(i);
            printColumns("" + currentRoom.getRoomNumber(), "" + currentRoom.getType(), "" + currentRoom.getPrice());
        }

        printTitle("Bookings:");
        printColumns("UserID", "RoomNumber", "RoomType", "CheckIn", "CheckOut", "TotalPrice");
        System.out.println();

        DateFormat dtFormatter = SimpleDateFormat.getDateInstance();
        bookings.forEach(bk -> {
            printColumns("" + bk.user().getId(),
                    "" + bk.room().getRoomNumber(),
                    "" + bk.room().getType(),
                    dtFormatter.format(bk.checkIn()),
                    dtFormatter.format(bk.checkOut()),
                    "" + bk.totalPrice());
        });

    }

    public void setUser(int userId, int balance) {

        User user = findUserById(userId);
        boolean userExists = user != null;

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

    // -- Helper methods --

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
    private boolean isAvailable(int roomNumber, Date checkIn, Date checkOut){
        return !bookings.stream().anyMatch(r -> {
            boolean roomAlreadyReserved = (checkIn.equals(r.checkIn()) 
                                        || (checkIn.after(r.checkIn())) && checkIn.before(r.checkOut()));
            
            return r.room().getRoomNumber() == roomNumber && roomAlreadyReserved;
        });
    }
    private void printColumns(String... columns) {
        for (String s : columns) {
            System.out.printf("%-20s", s);
        }
        System.out.println();
    }

}
