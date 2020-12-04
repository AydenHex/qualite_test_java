package org.quentinr.introjunit.Exercice2;

import java.util.Vector;
import java.util.stream.Collectors;

public class VectorUnion {

    /**
     * Ambiguité : 
     *  - Type de vector ? Pour supprimer les dupplicata lors du merge
     * 
     * Specs modifiés :
     * Ecrire une méthode de signature : public static Vector<String>(Vector<Object>, Vector<Object>) retournant
     * un vecteurs d'objets sous format String (Afin de gérer les duplicas) les objets contenu dans A ou B.
     */
    public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) {
        Vector<Object> merge = new Vector<Object>();

        merge.addAll(a);
        merge.addAll(b);
        merge.stream().collect(Collectors.toCollection(Vector::new));
        return merge;
    }

    public static void main(String[] args) {
        Vector<Object> test = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
                add("1");
            }
        };
        Vector<Object> test2 = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1.00);
            }
        };

        Vector<Object> test3 = VectorUnion.unionSet(test, test2);

        System.out.println(test3.size());
        System.out.println(test3);
    }

}

    