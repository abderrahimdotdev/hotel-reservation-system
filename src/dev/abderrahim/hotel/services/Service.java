package dev.abderrahim.hotel.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.SequencedCollection;

import dev.abderrahim.hotel.entities.Booking;
import dev.abderrahim.hotel.entities.Room;
import dev.abderrahim.hotel.entities.User;
import dev.abderrahim.hotel.types.RoomType;

public class Service {
    ArrayList<Room> rooms;
    ArrayList<User> users;
    SequencedCollection<Booking> bookings;

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {

    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {

    }

    public void printAll() {

    }

    public void setUser(int userId, int balance) {

    }

    public void printAllUsers() {

    }

}
