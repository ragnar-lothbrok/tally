package com.he.capillary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HereSolutions {

	public static void main(String[] args) {
		System.out.println(matching("C1(P2-5,P4-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P4-6)C4(P4-10,P5-5)C5(P4-9)"));
		System.out.println(matching("C1(P1-5,P5-5)C2(P2-5,P4-5)C3(P3-5)C4(P2-5,P4-5)C5(P1-5,P5-5)"));
	}

	public static String matching(String input1) {
		Map<String, List<ProductBenefit>> customerProductMap = new LinkedHashMap<String, List<ProductBenefit>>();

		List<String> customers = new ArrayList<String>();
		List<String> products = new ArrayList<String>();

		String str[] = input1.split("\\)");
		for (String group : str) {
			String partition[] = group.split("\\(");
			String productScroe[] = partition[1].split(",");
			List<ProductBenefit> productBenefit = new ArrayList<ProductBenefit>();
			for (String score : productScroe) {
				productBenefit.add(new ProductBenefit(score.split("-")[0], Integer.parseInt(score.split("-")[1])));
				if (!products.contains(score.split("-")[0])) {
					products.add(score.split("-")[0]);
				}
			}
			if (!customers.contains(partition[0])) {
				customers.add(partition[0]);
			}
			if (productBenefit.size() != 0) {
				customerProductMap.put(partition[0], productBenefit);
			}
		}

		if (customers.size() != customerProductMap.size()) {
			return "Matching Not Possible";
		}

		int[][] adjacencyMat = new int[customers.size()][products.size()];
		for (int i = 0; i < customers.size(); i++) {
			for (int j = 0; j < products.size(); j++) {
				adjacencyMat[i][j] = -1;
			}
		}

		for (int i = 0; i < customers.size(); i++) {
			List<ProductBenefit> productBenefits = customerProductMap.get(customers.get(i));
			for (ProductBenefit productBenefit : productBenefits) {
				adjacencyMat[i][products.indexOf(productBenefit.getProduct())] = productBenefit.getBenefit();
			}
		}

		// for (int i = 0; i < customers.size(); i++) {
		// for (int j = 0; j < products.size(); j++) {
		// System.out.print(adjacencyMat[i][j] + " ");
		// }
		// System.out.println();
		// }

		for (int j = 0; j < products.size(); j++) {
			boolean noProduct = false;
			for (int i = 0; i < customers.size(); i++) {
				if (adjacencyMat[i][j] != -1) {
					noProduct = true;
					break;
				}
			}
			if (!noProduct) {
				return "Matching Not Possible";
			}
		}

		return findMaximum(adjacencyMat, products, customers);
	}

	public static String findMaximum(int[][] adjacencyMat, List<String> products, List<String> customers) {
		Map<Integer, List<CustomerProductBenefit>> maxScoreMapping = new HashMap<Integer, List<CustomerProductBenefit>>();

		Queue<CustomerProductBenefit> queue = new LinkedList<CustomerProductBenefit>();
		for (int j = 0; j < adjacencyMat[0].length; j++) {
			if (adjacencyMat[0][j] != -1) {
				CustomerProductBenefit tempCustomerProductBenefit = new CustomerProductBenefit(j, adjacencyMat[0][j],
						0);
				tempCustomerProductBenefit.visitedCustomer.add(0);
				tempCustomerProductBenefit.visitedProduct.add(j);
				tempCustomerProductBenefit.total = adjacencyMat[0][j];
				tempCustomerProductBenefit.nodes.add(tempCustomerProductBenefit);
				queue.add(tempCustomerProductBenefit);
				while (!queue.isEmpty()) {
					CustomerProductBenefit customerProductBenefit = queue.poll();
					if (customerProductBenefit.customer < adjacencyMat.length - 1) {
						int num = customerProductBenefit.customer + 1;
						for (int k = 0; k < adjacencyMat[num].length; k++) {
							if (adjacencyMat[num][k] != -1 && !customerProductBenefit.visitedProduct.contains(k)) {
								CustomerProductBenefit temp = new CustomerProductBenefit(k, adjacencyMat[num][k], num);

								temp.visitedCustomer.add(customerProductBenefit.customer + 1);
								temp.visitedCustomer.addAll(customerProductBenefit.visitedCustomer);

								temp.visitedProduct.addAll(customerProductBenefit.visitedProduct);
								temp.visitedProduct.add(k);

								temp.total = temp.benefit + customerProductBenefit.total;
								temp.nodes.add(temp);
								for (CustomerProductBenefit sub : customerProductBenefit.nodes) {
									if (!temp.nodes.contains(sub)) {
										temp.nodes.add(sub);
									}
								}
								queue.add(temp);
							}
						}
					} else {
						if (new HashSet<Integer>(customerProductBenefit.visitedProduct).size() == adjacencyMat[0].length
								&& new HashSet<Integer>(customerProductBenefit.visitedCustomer)
										.size() == adjacencyMat.length) {
							if (maxScoreMapping.size() == 0) {
								List<CustomerProductBenefit> CustomerProductBenefitList = new ArrayList<CustomerProductBenefit>();
								CustomerProductBenefitList.add(customerProductBenefit);
								maxScoreMapping.put(customerProductBenefit.total, CustomerProductBenefitList);
							} else {
								Integer score = new ArrayList<Integer>(maxScoreMapping.keySet()).get(0);
								boolean isPresent = false;
								if (customerProductBenefit.total == score) {
									for (CustomerProductBenefit sub : maxScoreMapping.get(score)) {
										List<CustomerProductBenefit> temp = new ArrayList<CustomerProductBenefit>(
												sub.nodes);
										temp.removeAll(customerProductBenefit.nodes);
										if (temp.size() == 0) {
											isPresent = true;
										}
									}
									if (!isPresent) {
										maxScoreMapping.get(score).add(customerProductBenefit);
									}
								} else if (customerProductBenefit.total > score) {
									maxScoreMapping.clear();
									List<CustomerProductBenefit> CustomerProductBenefitList = new ArrayList<CustomerProductBenefit>();
									CustomerProductBenefitList.add(customerProductBenefit);
									maxScoreMapping.put(customerProductBenefit.total, CustomerProductBenefitList);
								}
							}
						}
					}
				}
			}
		}

		String result = "Matching Not Possible";
		if (maxScoreMapping.size() > 0) {
			List<CustomerProductBenefit> customerProductBenefitList = maxScoreMapping
					.get(new ArrayList<Integer>(maxScoreMapping.keySet()).get(0));
			result = "" + new ArrayList<Integer>(maxScoreMapping.keySet()).get(0);
			for (int i = 0; i < customerProductBenefitList.size(); i++) {
				CustomerProductBenefit tempcustomerProductBenefit = customerProductBenefitList.get(i);
				Collections.reverse(tempcustomerProductBenefit.nodes);
				for (CustomerProductBenefit subcustomerProductBenefit : tempcustomerProductBenefit.nodes) {
					result += ("(" + customers.get(subcustomerProductBenefit.customer) + ","
							+ products.get(subcustomerProductBenefit.product) + ")");
				}
				if (i < customerProductBenefitList.size() - 1) {
					result += "#"+new ArrayList<Integer>(maxScoreMapping.keySet()).get(0);
				}
			}
		}
		return result;
	}

	public static class CustomerProductBenefit {
		Integer product;
		Integer benefit;
		Integer customer;
		Integer total = 0;
		List<CustomerProductBenefit> nodes = new ArrayList<CustomerProductBenefit>();
		List<Integer> visitedCustomer = new ArrayList<Integer>();
		List<Integer> visitedProduct = new ArrayList<Integer>();

		public CustomerProductBenefit(Integer product, Integer benefit, Integer customer) {
			super();
			this.product = product;
			this.benefit = benefit;
			this.customer = customer;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((customer == null) ? 0 : customer.hashCode());
			result = prime * result + ((product == null) ? 0 : product.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CustomerProductBenefit other = (CustomerProductBenefit) obj;
			if (customer == null) {
				if (other.customer != null)
					return false;
			} else if (!customer.equals(other.customer))
				return false;
			if (product == null) {
				if (other.product != null)
					return false;
			} else if (!product.equals(other.product))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "CustomerProductBenefit [product=" + product + ", benefit=" + benefit + ", customer=" + customer
					+ ", total=" + total + ", visitedCustomer=" + visitedCustomer + ", visitedProduct=" + visitedProduct
					+ "]";
		}

	}

	static class ProductBenefit {
		private String product;
		private Integer benefit;

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public Integer getBenefit() {
			return benefit;
		}

		public void setBenefit(Integer benefit) {
			this.benefit = benefit;
		}

		public ProductBenefit() {

		}

		public ProductBenefit(String product, Integer benefit) {
			super();
			this.product = product;
			this.benefit = benefit;
		}

		@Override
		public String toString() {
			return "ProductBenefit [product=" + product + ", benefit=" + benefit + "]";
		}

	}

}
