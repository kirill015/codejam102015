package codejam.africa2010.qualification.storecredit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TaggedItemContainer<TTag, TItem> {
	private TTag tagID;
	private TItem item;
	
	public TTag getTagID() {
		return tagID;
	}
	public TItem getItem() {
		return item;
	}
	
	public TaggedItemContainer(TTag tagID, TItem item) {
		super();
		this.tagID = tagID;
		this.item = item;
	}
	
	public static<TTag, TItem> Collection<TaggedItemContainer<TTag, TItem>> tagItems(Collection<TItem> items, TTag tagValue) {
		List<TaggedItemContainer<TTag, TItem>> result = new ArrayList<TaggedItemContainer<TTag, TItem>>();
		for(TItem item : items) {
			result.add(new TaggedItemContainer<TTag, TItem>(tagValue, item));
		}
		
		return result;
	}
}
