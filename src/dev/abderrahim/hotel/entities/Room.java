package dev.abderrahim.hotel.entities;

import dev.abderrahim.hotel.types.RoomType;

public class Room {
    
    private int roomNumber;
    private RoomType type;
    private int pricePerNight;

    public Room(){
        
    }

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getPrice() {
        return pricePerNight;
    }

    public void setPrice(int newPrice) {
        if (newPrice < 0) {
            System.err.println("Price cannot be negative.");
            return;
        }
        this.pricePerNight = newPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int newNumber) {
        if (newNumber < 0) {
            System.err.println("Room number cannot be negative.");
            return;
        }
        this.roomNumber = newNumber;
    }

    public RoomType getType() {
        return type;
    }

    public void setRoomType(RoomType newType) {
        this.type = newType;
    }

}
