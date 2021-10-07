package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

		Field[] fields = richSoilLandClass.getDeclaredFields();

		String modifier = scanner.nextLine();

		while (!modifier.equals("HARVEST")){

			List<Field> extractedFields = filterMethodsByModifier(fields, modifier);

			for (Field f : extractedFields) {
				System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName());
			}
			modifier = scanner.nextLine();
		}
	}

	public static List<Field> filterMethodsByModifier(Field[] fields, String modifier){

		List<Field> filteredCollection = new ArrayList<>();
		switch (modifier) {
			case "private":
				filteredCollection = Arrays.stream(fields)
						.filter(m -> Modifier.isPrivate(m.getModifiers()))
						.collect(Collectors.toList()
						);
				break;
			case "public":
				filteredCollection = Arrays.stream(fields)
						.filter(m -> Modifier.isPublic(m.getModifiers()))
						.collect(Collectors.toList()
						);
				break;
			case "protected":
				filteredCollection = Arrays.stream(fields)
						.filter(m -> Modifier.isProtected(m.getModifiers()))
						.collect(Collectors.toList()
						);
				break;
			case "all":
				filteredCollection = List.of(fields);
				break;
		}

		return filteredCollection;
	}
}
