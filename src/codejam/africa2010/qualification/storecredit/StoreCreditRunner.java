package codejam.africa2010.qualification.storecredit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class StoreCreditRunner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nTestCases = readIntLine(rdr).get(0);
		for(int testNum = 0; testNum < nTestCases; testNum++) {
			int credit = readIntLine(rdr).get(0);
			int nItems = readIntLine(rdr).get(0);
			List<Integer> prices = readIntLine(rdr);
			
			List<Integer> solution = getItemIndicesWithTotal(prices, credit);
			assert(solution.size() == 2);
			assert(solution.get(0) < solution.get(1));
			
			writer.write(String.format("Case #%d: %d %d\n", testNum, solution.get(0), solution.get(1)));
			writer.flush();
		}
		
	}
	
	private static List<Integer> getItemIndicesWithTotal(List<Integer> prices, int credit) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		List<ItemValue> priceByItem = new ArrayList<ItemValue>();
		
		for(int i = 0; i < prices.size(); i++) {
			priceByItem.add(new ItemValue(i + 1, prices.get(i)));
		}
		
		Collection<ItemValue> remainingCreditByItem = getRemainingCreditByItem(credit, priceByItem);
		
		Collection<TaggedItemContainer<ItemTag, ItemValue>> taggedItemPrices = TaggedItemContainer.tagItems(priceByItem, ItemTag.ITEM_PRICE);
		Collection<TaggedItemContainer<ItemTag, ItemValue>> taggedRemainingCredits = TaggedItemContainer.tagItems(priceByItem, ItemTag.REMAINING_CREDIT);
		
		List<TaggedItemContainer<ItemTag, ItemValue>> allTaggedItems = new ArrayList<TaggedItemContainer<ItemTag, ItemValue>>();
		allTaggedItems.addAll(taggedItemPrices);
		allTaggedItems.addAll(taggedRemainingCredits);
		
		java.util.Collections.sort(allTaggedItems, new Comparator<TaggedItemContainer<ItemTag, ItemValue>>() {

			@Override
			public int compare(TaggedItemContainer<ItemTag, ItemValue> o1, TaggedItemContainer<ItemTag, ItemValue> o2) {
				return o1.getItem().getValue() - o2.getItem().getValue();
			}
			
		});
		
		// TODO: Hash match
		
		return result;
	}
	
	private enum ItemTag {
		ITEM_PRICE, REMAINING_CREDIT
	}
	

	private static Collection<ItemValue> getRemainingCreditByItem(int totalCredit, Collection<ItemValue> priceByItem) {
		List<ItemValue> result = new ArrayList<ItemValue>();
		for(ItemValue itemPrice : priceByItem) {
			result.add(new ItemValue(itemPrice.getItemID(), totalCredit - itemPrice.getValue()));
		}
		
		return result;
	}

	private static List<Integer> readIntLine(BufferedReader rdr) throws IOException {
		String line = rdr.readLine();
		String[] tokens = line.split(" ");
		List<Integer> ints = new ArrayList<Integer>();
		
		for(int i = 0; i < tokens.length; i++) {
			String token = tokens[i].trim();
			if(token.isEmpty())
				continue;
			
			ints.add(Integer.parseInt(token));
		}
		
		return ints;
	}

}
