package br.com.combinacaotaxonomias.common;

public class UrlApi {
	public static String peparaUrlGetAtributos(String url, String parametro) {
		return url.replace("{categoryId}", parametro);
	}
}
