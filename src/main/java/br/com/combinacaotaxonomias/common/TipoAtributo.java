package br.com.combinacaotaxonomias.common;

public enum TipoAtributo {
    STRING("TEXT"),
    BOOLEAN("BOOLEAN"),
    INTEGER("INT"),
	FLOAT("DECIMAL"),
	ERRO("ERRO");
	
	private String tipo;
	
	TipoAtributo(String tipo){
		this.tipo = tipo;
	}
	
	public static TipoAtributo  getTipo(String tipo) {
		if (tipo.equals("TEXT")) {
			return STRING;
		}else if (tipo.equals("BOOLEAN")) {
			return BOOLEAN;
		}else if (tipo.equals("INT")) {
			return INTEGER;
		}else if (tipo.equals("DECIMAL")) {
			return FLOAT;
		}else {
			return ERRO;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
