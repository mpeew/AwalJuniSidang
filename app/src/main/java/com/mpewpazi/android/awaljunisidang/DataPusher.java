package com.mpewpazi.android.awaljunisidang;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;


/**
 * Created by mpewpazi on 5/20/16.
 */
public class DataPusher {
    private static final String urlPostFG1="http://192.168.1.100/galpal/perusahaanIdentitas/postperusahaanidentitasapi/";



    public void makePostRequest() {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG1);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>(3);
            pairs.add(new BasicNameValuePair(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS, "20150001"));
            pairs.add(new BasicNameValuePair(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY, "20150001"));
            pairs.add(new BasicNameValuePair(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN, "WINDUHAJI"));
            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
