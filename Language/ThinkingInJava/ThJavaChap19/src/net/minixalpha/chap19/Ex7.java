package net.minixalpha.chap19;

import java.util.EnumSet;

enum Tom {}

public class Ex7 {
	public static void main(String[] args) {
		EnumSet<Tom> enums = null;
	}
}

/* Source Code of EnumSet */
// Answer

/*
public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
Enum[] universe = getUniverse(elementType);
if (universe == null)
    throw new ClassCastException(elementType + " not an enum");

if (universe.length <= 64)
    return new RegularEnumSet<>(elementType, universe);
else
    return new JumboEnumSet<>(elementType, universe);
}
*/

// if length is smaller than 64, then create RegularEnumSet
// else create JumboEnumSet

/*
class RegularEnumSet<E extends Enum<E>> extends EnumSet<E> {
	private static final long serialVersionUID = 3411599620347842686L;
	private long elements = 0L;
*/

// RegularEnumSet use a long member to store data


/*
public boolean add(E e) {
typeCheck(e);

long oldElements = elements;
elements |= (1L << ((Enum)e).ordinal());
return elements != oldElements;
}
*/

// add will make one bit of lements to 1, according to ordinal of enum data


/*
class JumboEnumSet<E extends Enum<E>> extends EnumSet<E> {
	private static final long serialVersionUID = 334349849919042784L;
	private long elements[];
*/

// JumboEnumSet use a long array to store data