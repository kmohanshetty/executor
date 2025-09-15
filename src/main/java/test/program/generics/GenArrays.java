package test.program.generics;

// Generics and arrays.
class Genc<T extends Number> {
    T ob;

    T[] vals; // OK

    Genc(T o, T[] nums) {
        ob = o;

        // This statement is illegal.
        // vals = new T[10]; // can't create an array of T

        // But, this statement is OK.
        vals = nums; // OK to assign reference to existent array
    }
}


class GenArrays {
    public static void main(String[] args) {
        Integer[] n = {1, 2, 3, 4, 5};

        Genc<Integer> iOb = new Genc<Integer>(50, n);

        // Can't create an array of type-specific generic references.
        // Gen<Integer>[] gens = new Gen<Integer>[10]; // Wrong!

        // This is OK.
        Genc<?>[] gens = new Genc<?>[10]; // OK
    }
}
