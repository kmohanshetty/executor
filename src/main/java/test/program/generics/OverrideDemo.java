package test.program.generics;

// Overriding a generic method in a generic class.
class Geno<T> {
    T ob; // declare an object of type T

    // Pass the constructor a reference to
    // an object of type T.
    Geno(T o) {
        ob = o;
    }

    // Return ob.
    T getOb() {
        System.out.print("Gen's getOb(): ");
        return ob;
    }
}

// A subclass of Gen that overrides getOb().
class Geno2<T> extends Geno<T> {

    Geno2(T o) {
        super(o);
    }

    // Override getOb().
    T getOb() {
        System.out.print("Gen2's getOb(): ");
        return ob;
    }
}

// Demonstrate generic method override.
class OverrideDemo {
    public static void main(String[] args) {

        // Create a Gen object for Integers.
        Geno<Integer> iOb = new Geno<Integer>(88);

        // Create a Gen2 object for Integers.
        Geno2<Integer> iOb2 = new Geno2<Integer>(99);

        // Create a Gen2 object for Strings.
        Geno2<String> strOb2 = new Geno2<String>("Generics Test");

        System.out.println(iOb.getOb());
        System.out.println(iOb2.getOb());
        System.out.println(strOb2.getOb());
    }
}