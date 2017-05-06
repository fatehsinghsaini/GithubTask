package saini.fateh.com.githubtask;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by fateh on 7/5/17.
 */

class Utils {

    public static boolean isNetworkAvaialable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
    }
