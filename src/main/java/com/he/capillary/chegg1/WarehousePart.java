package com.he.capillary.chegg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WarehousePart {

	public static void main(String[] args) throws IOException {

		List<Warehouse> warehouseList = new ArrayList<Warehouse>();
		Warehouse warehouse = null;

		BufferedReader br1 = new BufferedReader(new FileReader("/home/raghunandangupta/mygit/tally/src/main/java/com/he/capillary/chegg1/warehouse.txt"));
		String line = br1.readLine();
		while (line != null) {
			String str[] = line.split(",");
			warehouseList.add(new Warehouse(str[0], str[1], str[2]));
			line = br1.readLine();
		}

		BufferedReader br2 = new BufferedReader(new FileReader("/home/raghunandangupta/mygit/tally/src/main/java/com/he/capillary/chegg1/parts.txt"));
		line = br2.readLine();
		while (line != null) {
			String str[] = line.split(",");
			warehouse = new Warehouse(str[3], null, null);
			if(warehouseList.indexOf(warehouse) != -1){
				warehouseList.get(warehouseList.indexOf(warehouse)).getPartList().add(new Part(str[0], str[1], Double.parseDouble(str[2]), str[3], Integer.parseInt(str[4])));
			}
			line = br2.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		if(warehouseList.size() > 0){
			for(Warehouse tempWarehouse : warehouseList){
				sb.append(tempWarehouse.getWarehouseId()+" "+tempWarehouse.getCity()+", "+tempWarehouse.getState()+"\n");
				sb.append("Total Number of Parts: "+tempWarehouse.getPartList().size()+"\n");
				sb.append("Part#        Description          Price          Quantity\n");
				for(Part part : tempWarehouse.getPartList()){
					sb.append(part.getPartNUmber()+"   "+part.getDescription()+"   "+part.getPrice()+"   "+part.getQuantity()+"\n");
				}
				sb.append("\n\n");
			}
		}
		
		System.out.println(sb.toString());
			
	}
}
