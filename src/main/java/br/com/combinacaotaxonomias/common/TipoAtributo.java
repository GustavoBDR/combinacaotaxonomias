package br.com.combinacaotaxonomias.common;

public enum TipoAtributo {
    STRING,
    BOOLEAN,
    INT;
	
	public static TipoAtributo getTipo(String tipo) {
		if (tipo == "STRING" || tipo == "TEXT") {
			return STRING;
		}else if (tipo == "BOOLEAN") {
			return BOOLEAN;
		}else if (tipo == "INTEGER" || tipo == "DECIMAL") {
			return INT;
		}else {
			return null;
		}
	}
}
