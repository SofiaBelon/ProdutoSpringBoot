package com.example.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.produto.models.CategoriaProduto;
import com.example.produto.models.Produto;
import com.example.produto.repositories.CategoriaProdutoRepository;
import com.example.produto.repositories.ProdutoRepository;

@SpringBootApplication
public class ProdutoApplication {
	@Bean
	public CommandLineRunner initProduto(@Autowired ProdutoRepository produtoRepository, @Autowired CategoriaProdutoRepository categoriaProdutoRepository){
		return args -> {

			//inserindo produto
			produtoRepository.inserir(new Produto(0l, "Chocolate Branco", 5));
			produtoRepository.inserir(new Produto(0l, "Shampoo", 2));

			//Listar todos produtos
			System.out.println("----Listar todos os Produtos-----");
			List<Produto> listaProduto = produtoRepository.selecionarTodos();
			listaProduto.forEach(System.out::println);

			// Listar por ID
			System.out.println("---- Listar pelo ID do Produto ----");
			Long idProduto = 1L; // Suponha que você queira listar o produto com o ID 1
			List<Produto> listaProdutos = produtoRepository.selecionarPorId(idProduto);
			listaProdutos.forEach(System.out::println);

			//inserindo categoria
			categoriaProdutoRepository.inserir(new CategoriaProduto(0l, "Alimentos", "Chocolate intenso e rico, com alto teor de cacau e baixo teor de açúcar. Notas amargas e terrosas, apreciado por seus antioxidantes."));
			categoriaProdutoRepository.inserir(new CategoriaProduto(0l, "Higiene Pessoal", "Produto de limpeza capilar que remove sujeira, óleo e produtos capilares. Contém ingredientes hidratantes e pode ter propriedades específicas como fortalecimento ou controle de oleosidade."));

			//listar todas as categorias
			System.out.println("------Listar todas as Categorias------");
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.selecionarTodos();
			listaCategorias.forEach(System.out::println);

			Produto pCHO = listaProduto.get(0);
			Produto pSHA = listaProduto.get(1);
			pCHO.setCategoriaProduto(listaCategorias.get(0)); // Definindo a categoria correta para o primeiro produto
			pSHA.setCategoriaProduto(listaCategorias.get(1)); // Definindo a categoria correta para o segundo produto
			produtoRepository.editar(pCHO); // Salvando a atualização do primeiro produto no repositório
			produtoRepository.editar(pSHA); // Salvando a atualização do segundo produto no repositório


			//Listar por ID
			System.out.println("------Listar pelo ID da Categoria-------");
			Long idCategoria = 2L;
			List<CategoriaProduto> listaCategoria = categoriaProdutoRepository.selecionarPorId(idCategoria);
			listaCategoria.forEach(System.out::println);

		};
	}  


















	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

}
