package store.model.service;
/**
 * Define a contract for the StockService.
 * @author Tarso Bessa
 *
 */
public interface StockService {
	/**
	 * Checks the quantity of the products in stock to supply more
	 * unities.
	 */
	public void checkStock();
}
