package dev.abderrahim.hotel;

import java.util.GregorianCalendar;

import dev.abderrahim.hotel.services.Service;
import dev.abderrahim.hotel.types.RoomType;

public class Main {
    public static void main(String[] args) throws Exception {

        Service bookingService = new Service();
        
		bookingService.setRoom(1,RoomType.STANDARD,1000);
		bookingService.setRoom(2,RoomType.JUNIOR,2000);
		bookingService.setRoom(3,RoomType.MASTER,3000);

		bookingService.setUser(1,5000);
		bookingService.setUser(2,10000);


		bookingService.bookRoom(1, 2,new GregorianCalendar(2026,6,30).getTime(),new GregorianCalendar(2026,7,7).getTime());
		bookingService.bookRoom(1, 2,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,6,30).getTime());
		bookingService.bookRoom(1, 1,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,7,8).getTime());

		bookingService.bookRoom(2, 1,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,7,9).getTime());
		bookingService.bookRoom(2, 3,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,7,8).getTime());

		bookingService.setRoom(1,RoomType.MASTER,10000);

		bookingService.printAll();

		bookingService.printAllUsers();
    }
}
