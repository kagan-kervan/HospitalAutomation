package src;
public class Disease {
    private String name;
    private boolean isImportant;

    public Disease(String name) {
        this.name = name;
        // Hastalığın önemini kontrol et
        isImportant = checkImportance(name);
    }

    public String getName() {
        return name;
    }

    public boolean isImportant() {
        return isImportant;
    }

    private boolean checkImportance(String name) {
        // Hastalığın önemini kontrol et
        // ... (Önem kontrolü işlemi)
        return false;
    }
}
