public class main {
    public static void main(String[] args) {
        RoomService<EconomyRoom> economyService = new RoomServiceSecond<>();
        EconomyRoom econRoom = new EconomyRoom(101, 2, 1500, false);

        economyService.clean(econRoom);
        economyService.reserve(econRoom);

        try {
            economyService.reserve(econRoom);
        } catch (RoomAlreadyBookedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        economyService.free(econRoom);
        economyService.reserve(econRoom);

        RoomService<LuxRoom> luxService = new RoomServiceSecond<>();
        LuxRoom luxRoom = new LuxRoom(202, 3, 5000, false);

        luxService.clean(luxRoom);
        luxService.reserve(luxRoom);
        luxService.free(luxRoom);
    }
}