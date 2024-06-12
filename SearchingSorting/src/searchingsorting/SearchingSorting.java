import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SearchingSorting {
	
	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 */
	private static Collator myCollator = Collator.getInstance();
	
	public static void main(String[] args) {
		SearchingSorting s = new SearchingSorting();
		Scanner input = new Scanner(System.in);
		
		String algo = "";
		while (!algo.equals("quit")) {
			algo = "";
			while(!s.validInput(algo, new String[] {"bubble", "selection", "insertion", "merge", "linear", "binary", "quit"})) {
				System.out.print("What algorithm would you like to execute? ");
				algo = input.nextLine();
			} 
			if (algo.equals("quit")) {
				break;
			}
			
			String type = "";
			while(!s.validInput(type, new String[] {"integers", "strings"})) {
				System.out.print("What type of data? ");
				type = input.nextLine();
			}
			
			String store = "";
			while(!s.validInput(store, new String[] {"array", "list"})) {
				System.out.print("How is it stored? ");
				store = input.nextLine();
			}
			
			String data = "";
			while (!s.validData(data, type)) {
				System.out.print("Enter the data. ");
				data = input.nextLine();
			}
			
			String target = "";
			if (algo.equals("linear") || algo.equals("binary")) {
				boolean repeat = false;
				do {
					System.out.print("What is the target value? ");
					target = input.nextLine();
					if (type.equals("integers")) {
						try {
							int i = Integer.parseInt(target);
							repeat = false;
						}
						catch (NumberFormatException e) {
							repeat  = true;
							System.out.println("Invalid Type. Expected Integer.");
						}
					}
				} while(repeat);
				
			}
			ArrayList realData = s.parseData(data, type);
			s.SortSearch(realData, algo, store, type, target);
			System.out.println("");
		}
		input.close();
		
		
	}
	
	
	private void SortSearch(ArrayList realData, String algo, String store, String type, String target) {
		String[] sData = {};
		Integer[] iData = {};
		if (type.equals("integers")) {
			Integer[] arr = new Integer[realData.size()];
			iData =  (Integer[]) realData.toArray(arr);
		}
		if (type.equals("strings")) {
			String[] arr = new String[realData.size()];
			sData = (String[]) realData.toArray(arr);
		}
		
		switch (algo) {
			case ("bubble"):
				if (store.equals("list")) {
					System.out.println("Bubble sort:" + Arrays.toString(bubble(realData).toArray()));
				}
				else if (type.equals("integers")) {
					System.out.println("Bubble sort:" + Arrays.toString(bubble(iData)));
				}
				else {
					System.out.println("Bubble sort:" + Arrays.toString(bubble(sData)));
				}
				break;
			case ("selection"):
				if (store.equals("list")) {
					System.out.println("Selection sort:" + Arrays.toString(selection(realData).toArray()));
				}
				else if (type.equals("integers")) {
					System.out.println("Selection sort:" + Arrays.toString(selection(iData)));
				}
				else {
					System.out.println("Selection sort:" + Arrays.toString(selection(sData)));
				}
				break;
			case ("insertion"):
				if (store.equals("list")) {
					System.out.println("Insertion sort:" + Arrays.toString(insertion(realData).toArray()));
				}
				else if (type.equals("integers")) {
					System.out.println("Insertion sort:" + Arrays.toString(insertion(iData)));
				}
				else {
					System.out.println("Insertion sort:" + Arrays.toString(insertion(sData)));
				}
				break;
			case ("merge"):
				if (store.equals("list")) {
					System.out.println("Merge sort:" + Arrays.toString(merge(realData).toArray()));
				}
				else if (type.equals("integers")) {
					System.out.println("Merge sort:" + Arrays.toString(insertion(iData)));
				}
				else {
					System.out.println("Merge sort:" + Arrays.toString(insertion(sData)));
				}
				break;
			case ("linear"):
				if (store.equals("list")) {
					System.out.println("Linear search:" + linear(realData, target));
				}
				else if (type.equals("integers")) {
					System.out.println("Linear search:" + linear(iData, target));
				}
				else {
					System.out.println("Linear search:" + linear(sData, target));
				}
				break;
			case ("binary"):
				if (store.equals("list")) {
					System.out.println("Binary search:" + binary(realData, target));
				}
				else if (type.equals("integers")) {
					System.out.println("Binary search:" + binary(iData, target));
				}
				else {
					System.out.println("Binary search:" + binary(sData, target));
				}
				break;
			
		}
		
		
	}

	private ArrayList<?> parseData(String data, String type) {
		if (type.equals("strings")) {
			ArrayList<String> parsed = new ArrayList<String>();
			parsed.addAll(Arrays.asList(data.split(",")));
			return parsed;
		}
		ArrayList<Integer> parsed = new ArrayList<Integer>();
		String[] split = data.split(",");
		for (int i = 0; i < split.length; i++) {
			parsed.add(Integer.parseInt(split[i]));
		}
		return parsed;
	}

	private String[] bubble(String[] data) {
		for (int j = 0; j < data.length - 1; j++) {
			for (int i = 0; i < data.length - 1 - j; i++) {
				if (myCollator.compare(data[i], data[i + 1]) > 0) {
					String temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
				}
			}
		}
		return data;
	} 
	
	private Integer[] bubble(Integer[] data) {
		for (int j = 0; j < data.length - 1; j++) {
			for (int i = 0; i < data.length - 1 - j; i++) {
				if (data[i] > data[i + 1]) {
					int temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
				}
			}
		}
		return data;
	}
	
	private ArrayList bubble(ArrayList data) {
		for (int j = 0; j < data.size() - 1; j++) {
			for (int i = 0; i < data.size() - 1 - j; i++) {
				if (data.get(0) instanceof Integer) {
					if ((int) data.get(i) > (int) data.get(i + 1)) {
						Collections.swap(data, i, i+1);
					}
				}
				else {
					if (myCollator.compare(data.get(i), data.get(i + 1)) > 0) {
						Collections.swap(data, i, i+1);
					}
				}
			}
		}
		return data;
	}
	
	private String[] selection(String[] data) {
		for (int j = 0; j < data.length; j++) {
			int min = j;	
			for (int i = j; i < data.length; i++) {
				if (myCollator.compare(data[i], data[min]) < 0) {
					min = i;
				}
			}
			String temp = data[min];
			data[min] = data[j];
			data[j] = temp;
			
		}
		return data;
	} 
	
	private Integer[] selection(Integer[] data) {
		for (int j = 0; j < data.length; j++) {
			int min = j;	
			for (int i = j; i < data.length; i++) {
				if (data[i] < data[min]) {
					min = i;
				}
			}
			int temp = data[min];
			data[min] = data[j];
			data[j] = temp;
		}
		return data;
	}
	
	private ArrayList selection(ArrayList data) {
		
		for (int j = 0; j < data.size(); j++) {
			int min = j;	
			for (int i = j; i < data.size(); i++) {
				if (data.get(0) instanceof Integer) {
					if ((int) data.get(i) < (int) data.get(min)) {
						min = i;
					}
				}
				else {
					if (myCollator.compare(data.get(i), data.get(min)) < 0) {
						min = i;
					}
				}
			}
			Collections.swap(data, min, j);
		}
		return data;
	}
	
	private String[] insertion(String[] data) {
		for (int j = 1; j < data.length; j++) {
			int i = j-1; 
			String key = (String) data[j]; 
		      
		    while (i >= 0 && myCollator.compare(data[i],key) > 0) {
		    	data[i+1] = data[i];
			    i = i-1; 
			} 
			data[i+1] = key;
			
		}
		return data;
	} 
	
	private Integer[] insertion(Integer[] data) {
		for (int j = 1; j < data.length; j++) {	
			int key = (int) data[j]; 
			int i = j-1; 
				  
			while (i >= 0 && (int)data[i] > key) 
			{	
				data[i+1] = data[i];
				i = i-1; 
			} 
			data[i+1] = key;
			
		}
		return data;
	}
	
	private ArrayList insertion(ArrayList data) {
		
		for (int j = 1; j < data.size(); j++) {
			if (data.get(0) instanceof Integer) {
				int key = (int) data.get(j); 
				int i = j-1; 
					  
				while (i >= 0 && (int)data.get(i) > key) 
				{	
					data.set(i+1, data.get(i));
					i = i-1; 
				} 
				data.set(i+1, key);
			} 
				
			else {
				int i = j-1; 
				String key = (String) data.get(j); 
			      
			    while (i >= 0 && myCollator.compare(data.get(i),key) > 0) {
			    	data.set(i+1, data.get(i));
				    i = i-1; 
				} 
				data.set(i+1, key);
			}
		}
		return data;
	}
	
	private String[] merge(String[] data) {
		if (data.length == 1) {
			return data;
		}
		
		String[] half1 = merge(Arrays.copyOfRange(data, 0, data.length / 2));
		String[] half2 = merge(Arrays.copyOfRange(data, data.length / 2, data.length));
		
		String[] solved = new String[data.length];
		int solvedIndex = 0;
		int half1Index = 0;
		int half2Index = 0;
		
		while (half1Index < half1.length || half2Index < half2.length) {
			if (half1Index < half1.length && half2Index < half2.length) {
				if (myCollator.compare((String)half1[half1Index], (String)half2[half2Index]) < 0) {
					solved[solvedIndex] = half1[half1Index];
					half1Index++;
					solvedIndex++;
				}
				else {
					solved[solvedIndex] = half2[half2Index];
					half2Index++;
					solvedIndex++;
				}
			}
			else if (half1Index == half1.length) {
				for (int i = half2Index; i < half2.length; i++) {
					solved[solvedIndex] = half2[half2Index];
					solvedIndex++;
				}
				break;
			}
			else if (half2Index == half2.length) {
				for (int i = half1Index; i < half1.length; i++) {
					solved[solvedIndex] = half1[half1Index];
					solvedIndex++;
				}
				break;
			}
		}
		return solved;
	}
	
	private Integer[] merge(Integer[] data) {
		if (data.length == 1) {
			return data;
		}
		
		Integer[] half1 = merge(Arrays.copyOfRange(data, 0, data.length / 2));
		Integer[] half2 = merge(Arrays.copyOfRange(data, data.length / 2, data.length));
		
		Integer[] solved = new Integer[data.length];
		int solvedIndex = 0;
		int half1Index = 0;
		int half2Index = 0;
		
		while (half1Index < half1.length || half2Index < half2.length) {
			if (half1Index < half1.length && half2Index < half2.length) {
				if ((int)half1[half1Index] < (int)half2[half2Index]) {
					solved[solvedIndex] = half1[half1Index];
					half1Index++;
					solvedIndex++;
				}
				else {
					solved[solvedIndex] = half2[half2Index];
					half2Index++;
					solvedIndex++;
				}
			}
			else if (half1Index == half1.length) {
				for (int i = half2Index; i < half2.length; i++) {
					solved[solvedIndex] = half2[half2Index];
					solvedIndex++;
				}
				break;
			}
			else if (half2Index == half2.length) {
				for (int i = half1Index; i < half1.length; i++) {
					solved[solvedIndex] = half1[half1Index];
					solvedIndex++;
				}
				break;
			}
		}
		return solved;
	}
	
	private ArrayList merge(ArrayList data) {
		if (data.size() == 1) {
			return data;
		}
		ArrayList half1 = merge(new ArrayList(data.subList(0, data.size()/2)));
		ArrayList half2 = merge(new ArrayList(data.subList(data.size()/2, data.size())));
		
		ArrayList solved = new ArrayList();
		
		while (half1.size() > 0 || half2.size() > 0) {
			if (half1.size() > 0 && half2.size() > 0) {
				if (data.get(0) instanceof Integer) {
					if ((int)half1.get(0) < (int)half2.get(0)) {
						solved.add(half1.remove(0));
					}
					else {
						solved.add(half2.remove(0));
					}
				}
				else {
					if (myCollator.compare((String)half1.get(0), (String)half2.get(0)) < 0) {
						solved.add(half1.remove(0));
					}
					else {
						solved.add(half2.remove(0));
					}
				}
			}
			else if (0 == half1.size()) {
				solved.addAll(half2);
				break;
			}
			else if (0 == half2.size()) {
				solved.addAll(half1);
				break;
			}
		}
		return solved;
	}
	
	private int linear(ArrayList data, Object target) {
		for (int i = 0; i < data.size(); i++) {
			Object j = (Object)data.get(i);
			Object k = (Object)target;
			if (data.get(i) instanceof Integer) {
				k =  (Object)Integer.parseInt(k.toString());
			}
			if ((j).equals(k) ) {
				return i;
			}
		}
		return -1;
		
	}
	
	private int linear(String[] data, String target) {
		for (int i = 0; i < data.length; i++) {
			if ((data[i]).equals(target) ) {
				return i;
			}
		}
		return -1;
		
	}
	
	private int linear(Integer[] data, String target) {
		int targ = Integer.parseInt(target);
		for (int i = 0; i < data.length; i++) {
			if ((data[i]).equals(targ) ) {
				return i;
			}
		}
		return -1;
		
	}
	
	private int binary(ArrayList data, Object target) {
		ArrayList sorted = merge(data);
		int index = 0;
		Object k = (Object)target;
		if (data.get(0) instanceof Integer) {
			k =  (Object)Integer.parseInt(k.toString());
		}
		int lower = 0;
		int higher = data.size() - 1;
		while(lower <= higher) {
			index = lower + (higher -  lower) / 2;
			if (data.get(0) instanceof Integer) {
				
				if (Integer.parseInt(sorted.get(index).toString()) == (Integer)k) {
					return index;
				}
				else if (Integer.parseInt(sorted.get(index).toString()) > (Integer)k) {
					higher = index - 1;
				}
				else {
					lower = index + 1;
				}
			}
			else {
				if (myCollator.compare(sorted.get(index).toString(),(String)k) == 0) {
					return index;
				}
				else if (myCollator.compare(sorted.get(index).toString(),(String)k) > 0) {
					higher = index - 1;
				}
				else {
					lower = index + 1;
				}
			}
		}
			
		
		return -1;
		
	}
	
	private int binary(Integer[] data, String target) {
		Integer[] sorted = merge(data);
		
		int index = 0;
		int lower = 0;
		int higher = data.length - 1;
		int targ = Integer.parseInt(target);
		while(lower <= higher) {
			index = lower + (higher -  lower) / 2;
				
			if (sorted[index] == targ) {
				return index;
			}
			else if (sorted[index] > targ) {
				higher = index - 1;
			}
			else {
				lower = index + 1;
			}
			
		}
		
		return -1;
		
	}
	
	private int binary(String[] data, String target) {
		String[] sorted = merge(data);
		
		int index = 0;
		int lower = 0;
		int higher = data.length - 1;
		while(lower <= higher) {
			index = lower + (higher -  lower) / 2;
				
			if (sorted[index].equals(target)) {
				return index;
			}
			else if (myCollator.compare(sorted[index], target) > 0) {
				higher = index - 1;
			}
			else {
				lower = index + 1;
			}
			
		}
		
		return -1;
		
	}
	
	private boolean validData(String data, String type) {
		if (type.equals("strings")) {
			return data.length() > 0;
		}
		
		String[] splitData = data.split(",");
		for (int i = 0; i < splitData.length; i++) {
			try {
				Integer.parseInt(splitData[i]);
			}
			catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	private boolean validInput(String input, String[] valid) {
		for (int i = 0; i < valid.length; i++) {
			if (valid[i].equals(input)) {
				return true;
			}
		}
		return false;
	}
	
}
}
