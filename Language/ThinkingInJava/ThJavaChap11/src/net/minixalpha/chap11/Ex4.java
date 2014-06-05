package net.minixalpha.chap11;

import java.util.*;

class GenMovies {
	List<String> movies;
	int size;
	int curPos;

	public GenMovies(List<String> movies) {
		this.movies = movies;
		this.size = movies.size();
		this.curPos = 0;
	}

	public String next() {
		if (curPos >= size) {
			curPos = 0;
		}
		return movies.get(curPos++);
	}

	public boolean end() {
		return curPos == size;
	}
}

public class Ex4 {

	static void fill(Collection<String> c, GenMovies genMovies) {
		// while (genMovies.end() == false) {
		// c.add(genMovies.next());
		// }

		do {
			c.add(genMovies.next());
		} while (genMovies.end() == false);
	}

	static void action(Collection<String> c, GenMovies genMovies) {
		fill(c, genMovies);
		System.out.println(c.getClass());
		System.out.println(c);
		System.out.println("---");
	}

	public static void main(String[] args) {
		List<String> movies = Arrays.asList("movie1", "movie2", "movie3");
		GenMovies genMovies = new GenMovies(movies);

		action(new HashSet<String>(), genMovies);
		action(new ArrayList<String>(), genMovies);
		action(new LinkedList<String>(), genMovies);
		action(new TreeSet<String>(), genMovies);
		action(new LinkedHashSet<String>(), genMovies);

	}

}
