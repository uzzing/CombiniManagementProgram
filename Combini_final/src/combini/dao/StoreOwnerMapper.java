package combini.dao;

import combini.vo.StoreOwner;

public interface StoreOwnerMapper {
	
	// register store owner
	public int register(StoreOwner storeOwner);
	
	// login system
	public StoreOwner login(StoreOwner storeOwner);
}

