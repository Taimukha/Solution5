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
