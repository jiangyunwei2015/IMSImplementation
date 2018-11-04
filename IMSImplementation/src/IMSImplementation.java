import java.lang.management.OperatingSystemMXBean;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: IMSImplementation Class
 * Implementation of InventoryManagementSystem interface
 * Based on the requirements:
 * 1) Each product will be stored at one and only one named location within the warehouse.
 * 2) IMS will track the named physical location of a product within the warehouse and 
 * the inventory level of each product.
 * @author Yunwei Jiang
 * 
 * */
public class IMSImplementation implements InventoryManagementSystem {
	
	/*
	private  HashMap<Integer, String> productNameMap = null;
	private  HashMap<Integer, String> productLocationMap = null;
	private  HashMap<Integer, Integer> productLevelMap = null;
	 */
	//No need to use three maps, just one map with <K:productID,V:Product>
	//Also because this map is shared by different user threads, so use ConcurrentHashMap.
	protected ConcurrentHashMap<String, Product> productMap = new ConcurrentHashMap<>();
	@Override
	/**
	 * Description: Dealing with picking operation of IMS.
	 * @author Yunwei Jiang
	 * */
	public PickingResult pickProduct(String productId, int amountToPick) 
	{
		//check if the product is in the map now
		if(productMap.containsKey(productId))
		{
			//check if the amount to pick is available
			int stockLevel = productMap.get(productId).getStockLevel();
			Product operatingProduct = productMap.get(productId);
			if(stockLevel >= amountToPick)
			{
				operatingProduct.setStockLevel(stockLevel - amountToPick);
				//Then subtract the amountToPick
				productMap.put(productId, operatingProduct);
				return new PickingResult(true, productId, stockLevel, amountToPick,operatingProduct.getLocation());
			}
			else
			{
				//Not enough stockLevel for this picking operation
				return new PickingResult(false, productId, stockLevel, amountToPick, operatingProduct.getLocation());
			}
		}
		//If the required productId is not in productMap
		else
		{
			return new PickingResult();
		}
	}

	@Override
	/**
	 * Description: Dealing with restocking operation of IMS.
	 * If the product is not in productMap, do I need to create a new record in map?
	 * @author Yunwei Jiang
	 * */
	public RestockingResult restockProduct(String productId, int amountToRestock) 
	{
		//check if the product is in the map now
		if(productMap.containsKey(productId))
		{
			//check if the amount to pick is available
			int stockLevel = productMap.get(productId).getStockLevel();
			Product operatingProduct = productMap.get(productId);
			operatingProduct.setStockLevel(stockLevel + amountToRestock);
			productMap.put(productId, operatingProduct);
			return new RestockingResult(true, productId, stockLevel, amountToRestock,operatingProduct.getLocation());
		}
		//If the required productId is not in productMap
		else
		{
			return new RestockingResult();
		}
	}
	
	/**
	 * Description: This is just for testing the IMS system with some operations from different users.
	 * @author Yunwei Jiang
	 * */
	public void IMSTest()
	{
		
	}
	/**
	 * Description: print out information in product map
	 * @author Yunwei Jiang
	 * */
	public void PrintProductInfo()
	{
		
	}
}
