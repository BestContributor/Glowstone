package net.glowstone.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility methods for dealing with UUIDs.
 */
public final class UuidUtils {

    private static final Pattern UUID_PATTERN = Pattern.compile("-", Pattern.LITERAL);

    private UuidUtils() {
    }

    public static UUID fromFlatString(String str) {
        // xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
        return new UUID(Long.parseUnsignedLong(str.substring(0, 16), 16), Long.parseUnsignedLong(str.substring(16), 16));
    }

    public static String toFlatString(UUID uuid) {
        return UUID_PATTERN.matcher(uuid.toString()).replaceAll(Matcher.quoteReplacement(""));
    }

}
