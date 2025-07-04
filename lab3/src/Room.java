import java.util.Random;

public class Room {
    public int roomNumber;
    public int maxPeople;
    public int pricePerNight;
    public boolean booking;

    public Room(int roomNumber, int maxPeople, int pricePerNight, boolean booking) {
        this.roomNumber = roomNumber;
        this.maxPeople = maxPeople;
        this.pricePerNight = pricePerNight;
        this.booking = booking;
    }

    public Room(int roomNumber, int pricePerNight, boolean booking) {
        this.roomNumber = roomNumber;
        this.maxPeople = generateRandomPeople(1, 6);
        this.pricePerNight = pricePerNight;
        this.booking = booking;
    }

    private int generateRandomPeople(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void printInfo() {
        System.out.println("Номер комнаты" + roomNumber +
                " Максимальное количество человек в комнате: " + maxPeople +
                " Цена за ночь: " + pricePerNight +
                " Забронирована: " + (booking ? "Да" : "Нет"));
    }
}

class EconomyRoom extends Room {
    public EconomyRoom(int roomNumber, int maxPeople, int pricePerNight, boolean booking) {
        super(roomNumber, maxPeople, pricePerNight, booking);
    }

    public EconomyRoom(int roomNumber, int pricePerNight, boolean booking) {
        super(roomNumber, pricePerNight, booking);
    }
}
abstract class ProRoom extends Room {
    public ProRoom(int roomNumber, int maxPeople, int pricePerNight, boolean booking) {
        super(roomNumber, maxPeople, pricePerNight, booking);
    }

    public ProRoom(int roomNumber, int pricePerNight, boolean booking) {
        super(roomNumber, pricePerNight, booking);
    }
}
class StandardRoom extends ProRoom {
    public StandardRoom(int roomNumber, int maxPeople, int pricePerNight, boolean booking) {
        super(roomNumber, maxPeople, pricePerNight, booking);
    }

    public StandardRoom(int roomNumber, int pricePerNight, boolean booking) {
        super(roomNumber, pricePerNight, booking);
    }
}
class LuxRoom extends ProRoom {
    public LuxRoom(int roomNumber, int maxPeople, int pricePerNight, boolean booking) {
        super(roomNumber, maxPeople, pricePerNight, booking);
    }

    public LuxRoom(int roomNumber, int pricePerNight, boolean booking) {
        super(roomNumber, pricePerNight, booking);
    }
}

class UltraLuxRoom extends LuxRoom {
    public UltraLuxRoom(int roomNumber, int maxPeople, int pricePerNight, boolean booking) {
        super(roomNumber, maxPeople, pricePerNight, booking);
    }

    public UltraLuxRoom(int roomNumber, int pricePerNight, boolean booking) {
        super(roomNumber, pricePerNight, booking);
    }
}