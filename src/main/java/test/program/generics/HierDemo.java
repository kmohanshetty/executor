package test.program.generics;

// A subclass can add its own type parameters.
class Gend<T> {
    T ob; // declare an object of type T

    // Pass the constructor a reference to
    // an object of type T.
    Gend(T o) {
        ob = o;
    }

    // Return ob.
    T getOb() {
        return ob;
    }
}

// A subclass of Gen that defines a second
// type parameter, called V.
class Gend2<T, V> extends Gend<T> {
    V ob2;

    Gend2(T o, V o2) {
        super(o);
        ob2 = o2;
    }

    V getOb2() {
        return ob2;
    }
}

// Create an object of type Gen2. 
class HierDemo {
    public static void main(String[] args) {

        // Create a Gen2 object for String and Integer.
        Gend2<String, Integer> x =
                new Gend2<String, Integer>("Value is: ", 99);

        System.out.print(x.getOb());
        System.out.println(x.getOb2());
    }
}