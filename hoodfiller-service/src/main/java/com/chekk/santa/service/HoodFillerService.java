package com.chekk.santa.service;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.chekk.santa.bean.HoodInput;


@Service
public class HoodFillerService {
	
	public List<Integer> getHoodMinItems(HoodInput hoodInput){
		List<List<Integer>> minItemsList = getHoodMinItems(hoodInput.getPresent_weights(),hoodInput.getHood_capacity());
		return minItemsList.get(minItemsList.size()-1);
	}
	
	public List<List<Integer>> getHoodMinItems(int[] present_weights, int hood_capacity) {
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> temp = new ArrayList<>();
	    helper(present_weights, 0, hood_capacity, 0, temp, result);
	    return result;
	}
	 
	private void helper(int[] present_weights, int start, int hood_capacity, int sum,
	                    List<Integer> list, List<List<Integer>> result){
	    if(sum>hood_capacity){
	        return;
	    }
	 
	    if(sum==hood_capacity){
	        result.add(new ArrayList<>(list));
	        return;
	    }
	 
	    for(int i=start; i<present_weights.length; i++){
	        list.add(present_weights[i]);
	        helper(present_weights, i, hood_capacity, sum+present_weights[i], list, result);
	        list.remove(list.size()-1);
	    }
	}

}
