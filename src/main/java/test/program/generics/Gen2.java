package test.program.generics;

// Can't create an instance of T.
class Genaa<T> {
    T ob;

    Genaa() {
        ob = new T(); // Illegal!!!
    }
}
