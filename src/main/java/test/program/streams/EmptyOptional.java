package test.program.streams;

import java.util.Optional;

public class EmptyOptional {
    public static void main(String[] args) {
        // Creating an empty Optional
        Optional<String> optionalValue = Optional.empty();
        String value = "";
        // Trying to call get() on an empty Optional, will throw NoSuchElementException
        if(optionalValue.isPresent() && !optionalValue.isEmpty()) {
        	value = optionalValue.get();  // This will throw NoSuchElementException
        }
    }
}
