package vinay.services.model;

import java.util.ArrayList;
import java.util.List;

public class FetchItemsModel {
	List<Items> items = new ArrayList<Items>();

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

}
