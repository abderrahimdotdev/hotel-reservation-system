package dev.abderrahim.hotel;

import java.util.GregorianCalendar;

import dev.abderrahim.hotel.services.Service;
import dev.abderrahim.hotel.types.RoomType;

public class Main {
    public static void main(String[] args) throws Exception {

        Service bookinsService = new Service();
        
		bookinsService.setRoom(1,RoomType.STANDARD,1000);
		bookinsService.setRoom(2,RoomType.JUNIOR,2000);
		bookinsService.setRoom(3,RoomType.MASTER,3000);

		bookinsService.setUser(1,5000);
		bookinsService.setUser(2,10000);


		bookinsService.bookRoom(1, 2,new GregorianCalendar(2026,6,30).getTime(),new GregorianCalendar(2026,7,7).getTime());
		bookinsService.bookRoom(1, 2,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,6,30).getTime());
		bookinsService.bookRoom(1, 1,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,7,8).getTime());

		bookinsService.bookRoom(2, 1,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,7,9).getTime());
		bookinsService.bookRoom(2, 3,new GregorianCalendar(2026,7,7).getTime(),new GregorianCalendar(2026,7,8).getTime());

		bookinsService.setRoom(1,RoomType.MASTER,10000);

		bookinsService.printAll();

		bookinsService.printAllUsers();
    }
}
