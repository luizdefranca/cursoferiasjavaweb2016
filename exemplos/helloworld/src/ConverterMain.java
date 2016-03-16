
public class ConverterMain {

	public static void main(String[] args) {
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);

		//===JAVA 7

		Converter<String, Integer> converterJAVA7 =
				new Converter<String, Integer>() {
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
		};

		Integer convertedJava7 = converterJAVA7.convert("123");
		System.out.println(convertedJava7);
	}

}
