package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Unit unit;

		Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
		unit = (Unit) clazz.getDeclaredConstructor().newInstance();

		return unit;
	}
}
