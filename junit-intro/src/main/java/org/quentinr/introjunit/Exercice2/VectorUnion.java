package org.quentinr.introjunit.Exercice2;

import java.util.Vector;
import java.util.stream.Collectors;

public class VectorUnion {

    /**
     * Ambiguité : - Ou excelusif ? Ou inclusif ? - Duplication si élément présent
     * dans A et B ? - Sensibilité au type ? - Paramètre non nuls ? - Paramètre non
     * vide
     * 
     * Specs modifiés : Ecrire une méthode de signature : public static
     * Vector<Object>(Vector<Object>, Vector<Object>) avec en paramètre des vecteurs
     * non nuls. On inclura toutes les valeurs des deux vecteurs avec
     * possibilité de duplication.
     * 
     * @throws Exception
     * 
     */
    public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) throws Exception {
        Vector<Object> merge = new Vector<Object>();

        if (a.size() == 0 || b.size() == 0) {
            throw new Exception("Can't merge empty vectors");
        }
        merge.addAll(a);
        merge.addAll(b);
        merge.stream().distinct().collect(Collectors.toCollection(Vector::new));
        return merge;
    }

}

    