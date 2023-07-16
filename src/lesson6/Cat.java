package lesson6;

import java.util.HashSet;

class CatBase{
    String name;
    String owner;
    String color;
    Integer weight;
    public CatBase(String name, String owner, String color, Integer weight){
        this.name = name;
        this.owner = owner;
        this.color = color;
        this.weight = weight;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "name: " + name + " owner: " + owner + " color " + color + " weight: " + weight;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatBase))
            return false;
        CatBase other = (CatBase) o;
        boolean ownerEquals = (this.owner == null && other.owner == null)
                || (this.owner != null && this.owner.equals(other.owner));
        boolean nameEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
        return ownerEquals && nameEquals;
    }
    @Override
    public int hashCode() {
        int result = owner == null ? 0 : owner.hashCode();
        result = 31 * result + name== null? 0: name.hashCode();

        return result;
    }
}

public class Cat {
    public static void main(String[] args) {
        CatBase cat = new CatBase("Bars", "Koly", "Black", 12);
        CatBase cat2 = new CatBase("Bars$$", "KolyNik", "White", 11);
        CatBase cat3 = new CatBase("NikosBars", "ElKoly", "White Black", 12);
        CatBase cat4 = new CatBase("KirnikBars$$", "Alica", "Yellow", 9);
        CatBase cat5 = new CatBase("KirnikBars$$", "Alica", "Green", 19);
        System.out.println(cat);
        HashSet<CatBase> setCats = new HashSet<>();
        setCats.add(cat2);
        setCats.add(cat3);
        System.out.println(setCats);
        System.out.println(cat.equals(cat2));
        System.out.println("сравнение двух одинаковых котов по кличке и имени хозяина: ");
        System.out.println(cat4.equals(cat5));
        System.out.println(cat4.hashCode() + " " + cat5.hashCode());
        System.out.println(cat.hashCode() + " " + cat2.hashCode());
    }

}
