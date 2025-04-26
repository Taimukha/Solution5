public class HighResImage implements Image {
    private String filename;

    public HighResImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Толық суретті жүктеу: " + filename);
    }

    @Override
    public void displayThumbnail() {
        System.out.println("Кішкентай суретті көрсету: " + filename);
    }

    @Override
    public void displayFullImage() {
        System.out.println("Толық суретті көрсету: " + filename);
    }
}
