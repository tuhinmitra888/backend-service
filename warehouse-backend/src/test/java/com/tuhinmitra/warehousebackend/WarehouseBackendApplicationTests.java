package com.tuhinmitra.warehousebackend;

import com.tuhinmitra.warehousebackend.data.Article;
import com.tuhinmitra.warehousebackend.data.Product;
import com.tuhinmitra.warehousebackend.service.ArticleService;
import com.tuhinmitra.warehousebackend.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest
class WarehouseBackendApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ArticleService articleService;

	@MockBean
	private ProductService productService;

	@Test
	@WithUserDetails("user")
	void givenArticles_whenGetArticles_thenReturnJsonArray() throws Exception {
		Article article1 = new Article("1", "leg", 12);
		Article article2 = new Article("2", "screw", 17);

		List<Article> allArticles = Arrays.asList(article1, article2);

		given(articleService.getAll()).willReturn(allArticles);

		mvc.perform(get("/api/article")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is(article1.getName())))
				.andExpect(jsonPath("$[0].artId", is(article1.getArtId())))
				.andExpect(jsonPath("$[0].stock", is(article1.getStock())))
				.andExpect(jsonPath("$[1].name", is(article2.getName())))
				.andExpect(jsonPath("$[1].artId", is(article2.getArtId())))
				.andExpect(jsonPath("$[1].stock", is(article2.getStock())));
	}

	@Test
	@WithUserDetails("user")
	void givenProducts_whenGetProducts_thenReturnJsonArray() throws Exception {
		Product.ContainArticles containArticles1 = new Product.ContainArticles("1", 4);
		Product.ContainArticles containArticles2 = new Product.ContainArticles("2", 8);
		Product.ContainArticles containArticles3 = new Product.ContainArticles("3", 1);
		List<Product.ContainArticles> containArticlesList1 = Arrays.asList(containArticles1, containArticles2, containArticles3);

		Product product1 = new Product("Dining Chair", 123.00, containArticlesList1);

		Product.ContainArticles containArticles4 = new Product.ContainArticles("1", 4);
		Product.ContainArticles containArticles5 = new Product.ContainArticles("2", 8);
		Product.ContainArticles containArticles6 = new Product.ContainArticles("3", 1);
		List<Product.ContainArticles> containArticlesList2 = Arrays.asList(containArticles4, containArticles5, containArticles6);

		Product product2 = new Product("Dining Table", 66.0, containArticlesList2);

		List<Product> allProducts = Arrays.asList(product1, product2);

		given(productService.getAll()).willReturn(allProducts);

		mvc.perform(get("/api/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is(product1.getName())))
				.andExpect(jsonPath("$[1].name", is(product2.getName())));
	}

	@Test
	@WithUserDetails("user")
	void givenProducts_whenDeleteProduct_thenReturnOk() throws Exception {
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

		mvc.perform(delete("/api/product/Dining Chair")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@WithUserDetails("user")
	void givenProducts_whenDeleteNegativeProduct_thenReturnNotFound() throws Exception {
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);

		given(productService.deleteByName("NegativeProduct")).willReturn(responseEntity);

		mvc.perform(delete("/api/product/NegativeProduct")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	@WithUserDetails("user")
	void givenProducts_whenDeleteProductWithLowStock_thenReturnNotApplicable() throws Exception {
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);

		given(productService.deleteByName("ProductWithLowStock")).willReturn(responseEntity);

		mvc.perform(delete("/api/product/ProductWithLowStock")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotAcceptable());
	}

}
