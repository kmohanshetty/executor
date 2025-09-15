package test.program.generics;

// A nongeneric class can be the superclass
// of a generic subclass.

// A nongeneric class.
class NonGen {
    int num;

    NonGen(int i) {
        num = i;
    }

    int getnum() {
        return num;
    }
}

// A generic subclass.
class Genf<T> extends NonGen {
    T ob; // declare an object of type T

    // Pass the constructor a reference to
    // an object of type T.
    Genf(T o, int i) {
        super(i);
        ob = o;
    }

    // Return ob.
    T getOb() {
        return ob;
    }
}

// Create a Gen object. 
class HierDemo2 {
    public static void main(String[] args) {

        // Create a Gen object for String.
        Genf<String> w = new Genf<String>("Hello", 47);

        System.out.print(w.getOb() + " ");
        System.out.println(w.getnum());
    }
}