public class Display<T> {
    private String name; // Name of the display
    private int width; // Width of the display
    private int height; // Height of the display
    private T content;

    //
    public Display(String name, int width, int height, T content) {
        this.name = name; // Initialize name
        this.width = width; // Initialize width
        this.height = height; // Initialize height
    }

    public void show() {
        System.out.println("Display Name: " + name); // Print display name
        System.out.println("Width: " + width); // Print width
        System.out.println("Height: " + height); // Print height
    }
    
}
