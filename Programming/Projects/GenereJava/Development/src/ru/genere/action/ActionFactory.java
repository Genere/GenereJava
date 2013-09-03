package ru.genere.action;

import java.util.HashMap;
import java.util.Map;



public class ActionFactory {
	protected Map map = defaultMap();
	
	public ActionFactory() {
		super();
	}
	public Action create(String actionName) {
		Class klass = (Class) map.get(actionName);
		if (klass == null)
			throw new RuntimeException(getClass() + " was unable to find an action named '" + actionName + "'.");
		
		Action actionInstance = null;
		try {
			actionInstance = (Action) klass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return actionInstance;
	}
	protected Map defaultMap() {
		Map map = new HashMap();

		map.put("category", CategoryAction.class);
		map.put("test", TestAction.class);
		


		return map;
	}
}
