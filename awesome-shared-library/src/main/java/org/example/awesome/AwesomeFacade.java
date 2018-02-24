package org.example.awesome;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Collection;

/**
 *
 * @author Matt Morrissette
 */
public class AwesomeFacade {

    private static final String DEFAULT_REGION = "US";

    private String region;

    private Collection<String> supportedRegions;

    public void doSomethingAwesomeWithThisPhoneNumber(final String phoneNumber) {
        try {
            actuallyDoSomethingAwesome(validateAndStandardizePhoneNumber(phoneNumber));
        } catch (NumberParseException exp) {
            throw new IllegalArgumentException("Unable to parse phone number: " + phoneNumber);
        }
    }

    protected void actuallyDoSomethingAwesome(final PhoneNumber phoneNumber) {
        //TODO: actually do something awesome here since you have a real possibly valid phone number!!
    }

    private PhoneNumber validateAndStandardizePhoneNumber(final String phoneNumber) throws NumberParseException {
        final PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        final PhoneNumber number = util.parse(phoneNumber, DEFAULT_REGION);
        if (!util.isValidNumber(number)) {
            throw new IllegalArgumentException("Number was not a valid number");
        } else if (!util.isPossibleNumber(number)) {
            throw new IllegalArgumentException("Number was not a possible number");
        } else if (supportedRegions != null && !supportedRegions.isEmpty() && !supportedRegions.contains(util.getRegionCodeForNumber(number))) {
            throw new IllegalArgumentException("Number was not from a supported region");
        }
        return number;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public void setSupportedRegions(final Collection<String> regions) {
        this.supportedRegions = regions;
    }

}
