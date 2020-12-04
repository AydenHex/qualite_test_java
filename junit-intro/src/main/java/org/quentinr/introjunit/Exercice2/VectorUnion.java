package org.quentinr.introjunit.Exercice2;

import java.util.Vector;
import java.util.stream.Collectors;

public class VectorUnion {

    /**
     * Ambiguité : 
     *  - Formulation : Fusion de deux listes mal formulé;
     *  - Unicité ? : Si l'élement est existant dans a et b ? Duplication ou non ?
     *  - Type  ? : Si l'élelement est présent dans a et B dans deux types différents ? Que fait-on ?
     * 
     * Specs modifiés :
     * Ecrire une méthode de signature : public static Vector<Object>(Vector<Object>, Vector<Object>) retournant
     * un vecteurs d'objets.
     * Duplication possible
     * Tout type accepté "Object"
     */
    public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) {
        Vector<Object> merge = new Vector<Object>();

        merge.addAll(a);
        merge.addAll(b);
        merge.stream().distinct().collect(Collectors.toCollection(Vector::new));
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

    