/**
 * Description: Product Class
 * Based on the requirements:
 * 1) Each product will be stored at one and only one named location within the warehouse.
 * 2) IMS will track the named physical location of a product within the warehouse and 
 * the inventory level of each product.
 * @author Yunwei Jiang
 * 
 * */
public class Product {
	private String location;
	private String id;
	private String name;
	private Integer stockLevel;
	public void setLocation(String location)
	{
		this.location = location;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setStockLevel(Integer stockLevel)
	{
		this.stockLevel = stockLevel;
	}
	public String getLocation()
	{
		return location;
	}
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public Integer getStockLevel()
	{
		return stockLevel;
	}
}
