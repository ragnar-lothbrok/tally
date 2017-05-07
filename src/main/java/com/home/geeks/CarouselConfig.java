package com.home.geeks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by raghunandangupta on 6/9/16.
 * This class will have configuration of carousels. How products will be visible on
 * each carousel request.
 */
public class CarouselConfig implements Serializable {

    /**
     * For what kind of Ads we have to apply logic.
     */
    private List<String> adTypes;

    /**
     * On which page we have to modify carousel logic.
     */
    private List<String> pageTypes;

    /**
     * Minimum Slot Count after that we will randomize products display.
     */
    private Integer maxSlotCount;

    /**
     * Minimum product count needed for removing duplicacy.
     */
    private Integer minProductsCount;

    /**
     * Minimum products which will be displayed in each carousel
     */
    private Integer minProductPerSlot;

    public List<String> getAdTypes() {
        return adTypes;
    }

    public void setAdTypes(List<String> adTypes) {
        this.adTypes = adTypes;
    }

    public List<String> getPageTypes() {
        return pageTypes;
    }

    public void setPageTypes(List<String> pageTypes) {
        this.pageTypes = pageTypes;
    }

    public Integer getMaxSlotCount() {
        return maxSlotCount;
    }

    public void setMaxSlotCount(Integer maxSlotCount) {
        this.maxSlotCount = maxSlotCount;
    }

    public Integer getMinProductsCount() {
        return minProductsCount;
    }

    public void setMinProductsCount(Integer minProductsCount) {
        this.minProductsCount = minProductsCount;
    }

    public Integer getMinProductPerSlot() {
        return minProductPerSlot;
    }

    public void setMinProductPerSlot(Integer minProductPerSlot) {
        this.minProductPerSlot = minProductPerSlot;
    }

    @Override
	public String toString() {
		return "CarouselConfig [adTypes=" + adTypes + ", pageTypes=" + pageTypes + ", maxSlotCount=" + maxSlotCount + ", minProductsCount="
				+ minProductsCount + ", minProductPerSlot=" + minProductPerSlot + "]";
	}

	public static void main(String[] args) {
    	String value = "{\"adTypes\":[],\"pageTypes\":[\"clp\"],\"maxSlotCount\":5,\"minProductsCount\":100,\"minProductPerSlot\":8}";
    	 CarouselConfig carouselConfig = new Gson().fromJson(value, new TypeToken<CarouselConfig>() {
         }.getType());
    	 
    	 System.out.println(carouselConfig);
    	 
    	 List<String> productScoreContainers = new ArrayList<String>();
    	 
    	 for(int i=0;i<198;i++){
    		 productScoreContainers.add(i+"");
    	 }
    	 
    	 int slotClusterSize = 8;
    	 int slotCount = productScoreContainers.size() / slotClusterSize;
    	 System.out.println(slotClusterSize);
    	 for(int i=1;i<100;i++){
    		 int no = i;
    		 if(i % slotCount != 0){
    			 System.out.println(productScoreContainers.subList(((no-1)%slotCount)*slotClusterSize, (((no-1)%slotCount)*slotClusterSize + slotClusterSize < productScoreContainers.size() ? ((no-1)%slotCount)*slotClusterSize + slotClusterSize : productScoreContainers.size())));
    		 }else{
    			 System.out.println(productScoreContainers.subList(((no-1)%slotCount)*slotClusterSize, productScoreContainers.size()));
    		 }
    	 }
    }
}
