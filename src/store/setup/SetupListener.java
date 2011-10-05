package store.setup;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.security.providers.encoding.Md5PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import store.model.entity.Customer;
import store.model.entity.Group;
import store.model.entity.Product;
import store.model.service.CustomerService;
import store.model.service.ProductService;
/**
 * This class is responsible for the initialization of some
 * initial data
 * 
 * Just a helper class, it does not have anything with the application logic.
 * 
 * @author Tarso Bessa
 *
 */
public class SetupListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent scr) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		
		System.out.println("Performing initialization");
		CustomerService customerService = (CustomerService) appContext.getBean("customerService");
		ProductService productService = (ProductService) appContext.getBean("productService");
		
		List<Customer> customers = customerService.getAll();
		if(customers==null || customers.isEmpty()){
			System.out.println("There is no user: creating one...");
			Customer customer = new Customer();
			customer.setLogin("customer");
			customer.setName("mr customer");
			customer.setPass(new Md5PasswordEncoder().encodePassword("123", null));
			
			Group group = new Group();
			group.setName("ROLE_CUSTOMER");
			
			customer.setGroups(new HashSet<Group>());
			customer.getGroups().add(group);
			
			try {
				customerService.save(customer);
				System.out.println("Customer created with login 'customer' and password '123'.");
			} catch (RuntimeException e) {
				System.out.println("Error creating the user: this is bad");
				throw e;
			}
			
			
		}else{
			System.out.println("The database has " + customers.size() +" customers. Skipping user creation.");
		}
		
		List<Product> products = productService.getAll();
		
		if(products == null || products.isEmpty()){
			
			System.out.println("Creating products...");
			
			Product yearOne = new Product();
			
			yearOne.setName("Batman: Ano Um");
			yearOne.setPrice(new BigDecimal(150));
			
			Product killingJoke = new Product();
			killingJoke.setName("A Piada Mortal");
			killingJoke.setPrice(new BigDecimal(250));
			
			Product longHal = new Product();
			longHal.setName("O Long Dia das Bruxas");
			longHal.setPrice(new BigDecimal(100));
			
			Product asArk = new Product();
			asArk.setName("Asilo Arkham");
			asArk.setPrice(new BigDecimal(350));
			
			try {
				productService.save(yearOne);
				productService.save(killingJoke);
				productService.save(longHal);
				productService.save(asArk);
				
				System.out.println("Products created.");
			} catch (RuntimeException e) {
				System.out.println("Error creating products. :(");
				throw e;
			}
			
		}else{
			System.out.println("There is a lot products. Not creating anymore!");
		}
		
		System.out.println("The End!");
		
	}

}
