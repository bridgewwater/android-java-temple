package temp.utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 20/8/17.
 */
public class AssetsFileUtils {

    public static String readJson(Context context, String filePath) throws IOException {
        if (context == null) {
            return "";
        }

        InputStream open = context.getAssets().open(filePath);
        return readJsonFileAsInputStream(open, "");
    }

    private static String readJsonFileAsInputStream(InputStream inputStream, String charset) throws IOException {
        if (inputStream == null) {
            return "";
        }
        if (charset == null || charset.equals("")) {
            charset = "UTF-8";
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int count;
        while ((count = inputStream.read(data, 0, 1024)) != -1) {
            outputStream.write(data, 0, count);
        }
        return new String(outputStream.toByteArray(), Charset.forName(charset));
    }

    private AssetsFileUtils() {
    }
}
