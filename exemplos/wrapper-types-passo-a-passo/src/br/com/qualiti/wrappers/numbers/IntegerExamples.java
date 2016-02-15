package br.com.qualiti.wrappers.numbers;

public class IntegerExamples {

	public static void main(String[] args) {


		int valorPrimitivo = 1;

		Integer valorWrapper = valorPrimitivo;

		valorWrapper = Integer.valueOf(1);
		//RETORNA O WRAPPER
		valorWrapper = Integer.valueOf("1");

		//RETORNA O PRIMITIVO
		valorPrimitivo = Integer.parseInt("1");
		valorWrapper = Integer.parseInt("1");//boxing

		//valorWrapper = Integer.parseInt("one");//NumberFormatException

		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);

		Integer tresWrapper = Integer.valueOf(567);
		System.out.println(Integer.toBinaryString(tresWrapper));
		System.out.println(Integer.toHexString(tresWrapper));

		tresWrapper.intValue();
		tresWrapper.floatValue();
		tresWrapper.doubleValue();

		fazAlgo(tresWrapper);
		fazAlgo(3);
	}

//	private static void fazAlgo(int parametro){
//		System.out.println("IntegerExamples.fazAlgo(int)");
//	}

	private static void fazAlgo(int... parametro){
		System.out.println("IntegerExamples.fazAlgo(int)");
	}

	private static void fazAlgo(long parametro){
		System.out.println("IntegerExamples.fazAlgo(long)");
	}

	private static void fazAlgo(Integer parametro){
		System.out.println("IntegerExamples.fazAlgo(Integer)");
	}

}
