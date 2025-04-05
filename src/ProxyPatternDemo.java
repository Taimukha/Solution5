// Интерфейс
interface Image {
    void displayThumbnail();
    void displayFullImage();
}


class HighResImage implements Image {
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


class ImageProxy implements Image {
    private String filename;
    private HighResImage realImage;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayThumbnail() {
        System.out.println("Кэштен кішкентай сурет: " + filename);
    }

    @Override
    public void displayFullImage() {
        if (realImage == null) {
            realImage = new HighResImage(filename);
        }
        realImage.displayFullImage();
    }
}

// Protection Proxy – тіркелген қолданушы ғана сурет жүктей алады
class ImageUploader {
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


public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ImageProxy("house1.jpg");

        image.displayThumbnail();       // Бірден кішкентай сурет
        System.out.println("---Қолданушы үлкейтуді басады---");
        image.displayFullImage();       // Тек осы кезде жүктеледі

        System.out.println("\n---Сурет жүктеу тесті---");
        ImageUploader uploader = new ImageUploader(false);
        uploader.uploadImage("house2.jpg");

        uploader = new ImageUploader(true);
        uploader.uploadImage("house3.jpg");
    }
}