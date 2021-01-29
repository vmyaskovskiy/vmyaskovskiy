package ru.job4j.lsp;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
public class ParkingTest {
    @Test
    public void whenParkTrackCar() {
        Track track = new Track(2);
        ControllCar controllCar = new ControllCar(new ParkingCar(1,2,2));
        assertThat(controllCar.executrCar(track), is(true));
        assertThat(controllCar.executrCar(track), is(true));
        assertThat(controllCar.executrCar(track), is(false));
    }
    @Test
    public void whenParkPassCar() {
        PassCar passCar = new PassCar(1);
        ControllCar controllCar = new ControllCar(new ParkingCar(1,2,2));
        assertThat(controllCar.executrCar(passCar), is(true));
        assertThat(controllCar.executrCar(passCar), is(true));
        assertThat(controllCar.executrCar(passCar), is(false));
    }
    @Test
    public void whenParkPassCarTrackCar() {
        Track track = new Track(2);
        PassCar passCar = new PassCar(1);
        ControllCar controllCar = new ControllCar(new ParkingCar(1,3,2));
        assertThat(controllCar.executrCar(track), is(true));
        assertThat(controllCar.executrCar(track), is(true));
        assertThat(controllCar.executrCar(track), is(false));
        assertThat(controllCar.executrCar(passCar), is(true));
        assertThat(controllCar.executrCar(passCar), is(false));
    }
    @Test
    public void whenParkPassCarTrackCarNull() {
        Track track = new Track(2);
        PassCar passCar = new PassCar(1);
        ControllCar controllCar = new ControllCar(new ParkingCar(0,3,2));
        assertThat(controllCar.executrCar(track), is(true));
        assertThat(controllCar.executrCar(track), is(false));
        assertThat(controllCar.executrCar(passCar), is(true));
        assertThat(controllCar.executrCar(passCar), is(false));
    }
    @Test
    public void whenParkPassCarNullTrackCar() {
        Track track = new Track(2);
        PassCar passCar = new PassCar(1);
        ControllCar controllCar = new ControllCar(new ParkingCar(1,0,2));
        assertThat(controllCar.executrCar(passCar), is(false));
        assertThat(controllCar.executrCar(track), is(true));
        assertThat(controllCar.executrCar(track), is(false));
    }

    @Test
    public void whenParkPassCarNullTrackCarNull() {
        Track track = new Track(2);
        PassCar passCar = new PassCar(1);
        ControllCar controllCar = new ControllCar(new ParkingCar(0,0,2));
        assertThat(controllCar.executrCar(passCar), is(false));
        assertThat(controllCar.executrCar(track), is(false));
    }

}
