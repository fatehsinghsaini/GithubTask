package saini.fateh.com.githubtask;

import android.app.Application;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by fateh on 7/5/17.
 */

public class ApplicationController extends Application {
    private static ApplicationController mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance=this;
    }

    public static synchronized ApplicationController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(getApplicationContext(),null);
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {

        if(!Utils.isNetworkAvaialable(this))
            Toast.makeText(this, R.string.network_msg, Toast.LENGTH_LONG).show();

        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

/*    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }
    */

}
