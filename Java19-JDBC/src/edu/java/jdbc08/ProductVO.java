package edu.java.jdbc08;

import java.util.Date;

public class ProductVO {
	private int productNo;
	private String productName;
	private int productPrice;
	private int productCount;
	private String productSeller;
	private Date productDate;
	
	public ProductVO() {
	}

	public ProductVO(int productNo, String productName, int productPrice, int productCount, String productSeller,
			Date productDate) {
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productSeller = productSeller;
		this.productDate = productDate;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getProductSeller() {
		return productSeller;
	}

	public void setProductSeller(String productSeller) {
		this.productSeller = productSeller;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	@Override
	public String toString() {
		return "ProductVO [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCount=" + productCount + ", productSeller=" + productSeller + ", productDate=" + productDate
				+ "]";
	}
	
}











