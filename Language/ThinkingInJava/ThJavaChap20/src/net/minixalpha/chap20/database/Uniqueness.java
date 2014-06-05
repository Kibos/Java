//: annotations/database/Uniqueness.java
// Sample of nested annotations
package net.minixalpha.chap20.database;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
} ///:~
