package br.com.qualiti.wrappers.booleans;

public class BooleanExamples {

	private static Boolean FALSO;
	private static Boolean FALSO_INICIALIZADO = false;

	public static void main(String[] args) {

		//convetPrimitiveToWrapper();

		//System.out.println(isAlgoAtributoNaoInicializado());
		System.out.println(isAlgoAtributoNaoInicializadoWrapper());
	}

	public static void convetPrimitiveToWrapper(){

		Boolean verdadeiro = Boolean.TRUE;
		Boolean falso = Boolean.FALSE;

		Boolean verdadeiro2 = Boolean.valueOf("true");
		Boolean falso2 = Boolean.valueOf("false");
		Boolean verdadeiro3 = Boolean.valueOf("True");
		Boolean falso3 = Boolean.valueOf("tru");

		//BOXING
		Boolean verdadeiro4 = true;
		Boolean falso4 = false;

		if(verdadeiro4){

		}

		//UNBOXING
		boolean verdadeiroPrimitivo = Boolean.TRUE;
		boolean falsoPrimitivo = Boolean.FALSE;


		System.out.println(verdadeiro);
		System.out.println(falso);
		System.out.println(verdadeiro2);
		System.out.println(falso2);
		System.out.println(verdadeiro3);
		System.out.println(falso3);

	}

	public static boolean isAlgo(){

		return Boolean.TRUE;
	}

	public static boolean isAlgoVariavel(){

		Boolean retorno = Boolean.TRUE;

		return retorno;
	}

	public static boolean isAlgoAtributoNaoInicializado()
			throws NullPointerException{

		return FALSO;
	}

	public static boolean isAlgoAtributoInicializado()
			throws NullPointerException{

		return FALSO_INICIALIZADO;
	}

	public static Boolean isAlgoAtributoNaoInicializadoWrapper(){

		return FALSO;
	}

	public static Boolean isAlgoWrapper(){

		return true;
	}

}
