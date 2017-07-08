/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Open Website button is clicked. It will open the website
     * specified by the URL represented by the variable urlAsString using implicit Intents.
     *
     * @param v Button that was clicked.
     */
    public void onClickOpenWebpageButton(View v) {
        // TODO (5) Create a String that contains a URL ( make sure it starts with http:// or https:// )

        // TODO (6) Replace the Toast with a call to openWebPage, passing in the URL String from the previous step
        //Toast.makeText(this, "TODO: Open a web page when this button is clicked", Toast.LENGTH_SHORT).show();
        String siteAddress = "https://www.udacity.com";
        openWebPage(siteAddress);
    }

    /**
     * This method is called when the Open Location in Map button is clicked. It will open the
     * a map to the location represented by the variable addressString using implicit Intents.
     *
     * @param v Button that was clicked.
     */
    public void onClickOpenAddressButton(View v) {
        //Toast.makeText(this, "TODO: Open a map when this button is clicked", Toast.LENGTH_SHORT).show();
        showMapAddress("Kyiv Boryspil International Airport, Boryspil', Ukraine");

    }

    /**
     * This method is called when the Share Text Content button is clicked. It will simply share
     * the text contained within the String textThatYouWantToShare.
     *
     * @param v Button that was clicked.
     */
    public void onClickShareTextButton(View v) {
        //Toast.makeText(this, "TODO: Share text when this is clicked", Toast.LENGTH_LONG).show();
        shareText("hi dear another programs activity");
    }

    /**
     * This is where you will create and fire off your own implicit Intent. Yours will be very
     * similar to what I've done above. You can view a list of implicit Intents on the Common
     * Intents page from the developer documentation.
     *
     * @param v Button that was clicked.
     * @see <http://developer.android.com/guide/components/intents-common.html/>
     */
    public void createYourOwn(View v) {
        /*Toast.makeText(this,
                "TODO: Create Your Own Implicit Intent",
                Toast.LENGTH_SHORT)
                .show();*/
        dialPhoneNumber("0999999999");
    }

    // TODO (1) Create a method called openWebPage that accepts a String as a parameter
    // Do steps 2 - 4 within openWebPage

    // TODO (2) Use Uri.parse to parse the String into a Uri

    // TODO (3) Create an Intent with Intent.ACTION_VIEW and the webpage Uri as parameters

    // TODO (4) Verify that this Intent can be launched and then call startActivity
    void openWebPage(String siteAddress) {
        Uri siteUri = Uri.parse(siteAddress);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, siteUri);

        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }
    }

    void showMapAddress(String streetAddress) {
        Uri.Builder builder = new Uri.Builder();
        Uri mapUri = builder.scheme("geo").path("0,0").query(streetAddress).build();
        Log.d("mymymy", mapUri.toString());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    void shareText(String sharedText) {
        /*Intent textIntent = new Intent();
        textIntent.setAction(Intent.ACTION_SEND);
        textIntent.putExtra(Intent.EXTRA_TEXT, sharedText);
        textIntent.setType("text/plain");



        startActivity(Intent.createChooser(textIntent, "share text via..."));*/
        Intent sharedIntent = ShareCompat.IntentBuilder.from(this).setType("text/*").setChooserTitle("share text via...")
                .setText(sharedText).getIntent();
        startActivity(sharedIntent);

    }

    void dialPhoneNumber(String phoneNumber) {
        Uri phoneUri = new Uri.Builder().scheme("tel").path("+xyzb").build();
        Log.d("mymymy",phoneUri.toString());
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, phoneUri);

        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(dialIntent);
        }
    }
}