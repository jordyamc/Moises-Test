package knf.moisestest.Utils;

import java.util.ArrayList;
import java.util.List;

import static knf.moisestest.Utils.ContentHolder.jaguar_desc;
import static knf.moisestest.Utils.ContentHolder.jaguar_img;
import static knf.moisestest.Utils.ContentHolder.monoaullador_desc;
import static knf.moisestest.Utils.ContentHolder.monoaullador_img;
import static knf.moisestest.Utils.ContentHolder.no_desc_res;
import static knf.moisestest.Utils.ContentHolder.not_found_img;
import static knf.moisestest.Utils.ContentHolder.nutria_desc;
import static knf.moisestest.Utils.ContentHolder.nutria_img;
import static knf.moisestest.Utils.ContentHolder.pandarojo_desc;
import static knf.moisestest.Utils.ContentHolder.pandarojo_img;
import static knf.moisestest.Utils.ContentHolder.pinguino_desc;
import static knf.moisestest.Utils.ContentHolder.pinguino_img;
import static knf.moisestest.Utils.ContentHolder.tapir_desc;
import static knf.moisestest.Utils.ContentHolder.tapir_img;

/**
 * Created by Jordy on 19/05/2017.
 */

public class ContentFactory {
    public static List<Animal> get(AnimalType type) {
        switch (type) {
            case AVES:
                return getAves();
            case MAMIFEROS:
                return getMamiferos();
            default:
                return new ArrayList<>();
        }
    }

    private static List<Animal> getAves() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Sin nombre", not_found_img, no_desc_res, AnimalType.AVES));
        animals.add(new Animal("Sin nombre", not_found_img, no_desc_res, AnimalType.AVES));
        animals.add(new Animal("Sin nombre", not_found_img, no_desc_res, AnimalType.AVES));
        animals.add(new Animal("Sin nombre", not_found_img, no_desc_res, AnimalType.AVES));
        animals.add(new Animal("Sin nombre", not_found_img, no_desc_res, AnimalType.AVES));
        animals.add(new Animal("Sin nombre", not_found_img, no_desc_res, AnimalType.AVES));
        return animals;
    }

    private static List<Animal> getMamiferos() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Jaguar", jaguar_img, jaguar_desc, AnimalType.MAMIFEROS));
        animals.add(new Animal("Mono Aullador", monoaullador_img, monoaullador_desc, AnimalType.MAMIFEROS));
        animals.add(new Animal("Nutria", nutria_img, nutria_desc, AnimalType.MAMIFEROS));
        animals.add(new Animal("Panda Rojo", pandarojo_img, pandarojo_desc, AnimalType.MAMIFEROS));
        animals.add(new Animal("Pinguino", pinguino_img, pinguino_desc, AnimalType.MAMIFEROS));
        animals.add(new Animal("Tapir", tapir_img, tapir_desc, AnimalType.MAMIFEROS));
        return animals;
    }

    public enum AnimalType {
        AVES(0),
        MAMIFEROS(1);
        int value;

        AnimalType(int value) {
            this.value = value;
        }
    }

    public static class Animal {
        public int res_img;
        public int res_desc;
        public String name;
        public AnimalType type;

        public Animal(String name, int res_img, int res_desc, AnimalType type) {
            this.res_img = res_img;
            this.res_desc = res_desc;
            this.name = name;
            this.type = type;
        }
    }
}
