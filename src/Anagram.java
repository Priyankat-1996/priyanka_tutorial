
public class Anagram 
{
	public static void main(String[] args) {
		String one = "ANAGRAMA";
		String two = "MANAGRAM";
		System.out.println(new Anagram().test(one, two));
	}

	public boolean test(String a, String b) {

		boolean result = true;

		StringBuilder one = new StringBuilder(a.replaceAll("[\\s+\\W+]", "").toLowerCase());
		StringBuilder two = new StringBuilder(b.replaceAll("[\\s+\\W+]", "").toLowerCase());
		
		if (one.length() == two.length()) {

			int index = -1;

			for (char c : one.toString().toCharArray()) {

				index = two.indexOf(String.valueOf(c));

				if (index == -1) {
					result = false;
					break;
				}
				two.deleteCharAt(index);
			}
		} else {
			result = false;
		}

		return result;

	}

}
