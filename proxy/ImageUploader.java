public class ImageUploader {
    private boolean isLoggedIn;

    public ImageUploader(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void uploadImage(String filename) {
        if (isLoggedIn) {
            System.out.println("Сурет жүктелді: " + filename);
        } else {
            System.out.println("Қате: жүйеге кіріңіз.");
        }
    }
}
