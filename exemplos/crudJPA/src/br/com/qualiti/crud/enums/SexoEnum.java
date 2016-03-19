package br.com.qualiti.crud.enums;

public enum SexoEnum {

	M('M'), F('F'), T('T');

	private final char sexoChar;

	public char getChar() {
		return sexoChar;
	}

	public static SexoEnum charToEnum(char sexo) {
		if (sexo == 'M') {
			return SexoEnum.M;
		} else if (sexo == 'F') {
			return SexoEnum.F;
		} else if (sexo == 'T') {
			return SexoEnum.T;
		} else {
			return null;
		}
	}

	private SexoEnum(char c) {
		this.sexoChar = c;
	}

}
