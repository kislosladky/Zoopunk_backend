package zoopunk.backend.EntityList;

public class Coordinates {
    private float[] coordinates;

    public void setCoordinates(float latitude, float longitude) {
        coordinates = new float[2];
        coordinates[0] = latitude;
        coordinates[1] = longitude;
    }

    public float[] getCoordinates() {
        return coordinates;
    }
}
