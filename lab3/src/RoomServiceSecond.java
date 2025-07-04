public class RoomServiceSecond<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T room) {
        System.out.println("Комната №" + room.roomNumber + " почищена");
    }

    @Override
    public void reserve(T room) {
        if (room.booking) {
            throw new RoomAlreadyBookedException("Комната №" + room.roomNumber + " уже забронирована");
        }
        room.booking = true;
    }

    @Override
    public void free(T room) {
        room.booking = false;
    }
}
