import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class Example {

	public static void main(String[] args) throws NumberParseException {
		if (args.length < 1) {
			throw new IllegalArgumentException("Must provide a phone number");
		}
		final PhoneNumberUtil util = PhoneNumberUtil.getInstance();
		final PhoneNumber num = util.parse(args[0], "US");
		if (!util.isPossibleNumber(num)) {
			throw new IllegalArgumentException("Not a possible number: " + args[0]);
		} else if (!util.isValidNumber(num)) {
			throw new IllegalArgumentException("Not a valid number: " + args[1]);
		} else {
			System.out.println("Valid and possible number: " + args[0]);
		}				
	}
}