package com.eprops.eprops.util;

import java.io.InputStream;
import java.util.Scanner;

public final class StreamToStringService {

    private StreamToStringService() {
        throw new UnsupportedOperationException("This constructor should not be invoked");
    }

    public static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
