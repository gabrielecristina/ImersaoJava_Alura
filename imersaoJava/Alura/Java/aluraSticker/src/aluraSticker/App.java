package aluraSticker;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		// Fazer conexão HTTP e bucar top 250 filmes - fazendo conexão
		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		// filtrar dados que interessa (titulo, poster e classificao) - expressão
		// regulares
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		// exibir e manipular odados da aplicao
		for (Map<String, String> filme : listaDeFilmes) {
			String urlImagem = filme.get("image");
			String titulo = filme.get("title");

			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo + ".png";

			geradora.cria(inputStream, nomeArquivo);
			
			InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

//			System.out.println(filme.get("title"));
//			System.out.println(filme.get("image"));
//			System.out.println(filme.get("imDbRating"));
//			// String ="\"\
//			System.out.println();
		}

	}

}
