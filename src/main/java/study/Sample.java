package study;

import java.util.stream.Stream;

public class Sample {


	public static void main(String[] args) {
		Stream.of("hello", "world").forEach(System.out::println);

	}

}
